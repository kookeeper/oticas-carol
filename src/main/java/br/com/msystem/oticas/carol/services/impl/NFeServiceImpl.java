package br.com.msystem.oticas.carol.services.impl;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.entity.Duplicata;
import br.com.msystem.oticas.carol.entity.Endereco;
import br.com.msystem.oticas.carol.entity.Nfe;
import br.com.msystem.oticas.carol.entity.NfeItem;
import br.com.msystem.oticas.carol.entity.Pessoa;
import br.com.msystem.oticas.carol.entity.Produto;
import br.com.msystem.oticas.carol.enums.TipoCadastroPessoa;
import br.com.msystem.oticas.carol.enums.TipoPessoa;
import br.com.msystem.oticas.carol.services.NFeService;
import br.com.msystem.oticas.carol.services.PessoaService;
import br.com.msystem.oticas.carol.services.ProdutoService;
import br.com.msystem.oticas.carol.util.NFeUtil;
import br.inf.portalfiscal.nfe.TEnderEmi;
import br.inf.portalfiscal.nfe.TNFe;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Cobr.Dup;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Emit;

@Service("nfeServiceImpl")
@Transactional
public class NFeServiceImpl implements NFeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2379559483777173056L;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private ProdutoService produtoService;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public void importarNFe(byte[] fileContent) throws JAXBException,
			ParseException {

		TNFe nfe = NFeUtil.abrirNFe(new ByteArrayInputStream(fileContent));

		Nfe bean = new Nfe();
		bean.setDataEmissaoNFe(sdf.parse(nfe.getInfNFe().getIde().getDhEmi()));
		bean.setFornecedorNFe(buscarFornecedor(nfe.getInfNFe().getEmit()));
		bean.setNumeroNFe(Integer.parseInt(nfe.getInfNFe().getIde().getNNF()));
		bean.setValorNFe(Float.parseFloat(nfe.getInfNFe().getCobr().getFat()
				.getVOrig()));
		bean.setListaItemNFe(converterListaItem(bean, nfe.getInfNFe().getDet()));
		bean.setListaDuplicata(converterListaDuplicata(bean, nfe.getInfNFe().getCobr().getDup()));

		salvar(bean);
	}

	private List<Duplicata> converterListaDuplicata(Nfe nfe, List<Dup> dup) throws ParseException {

		List<Duplicata> lista = new ArrayList<Duplicata>();

		for (Dup item : dup) {
			Duplicata bean = new Duplicata();

			bean.setNfe(nfe);
			bean.setNumero(item.getNDup());
			bean.setValor(Float.parseFloat(item.getVDup()));
			bean.setDataVencimento(sdf.parse(item.getDVenc()));

			lista.add(bean);
		}

		return lista;
	}

	private List<NfeItem> converterListaItem(Nfe nfe, List<Det> dets) {

		List<NfeItem> lista = new ArrayList<NfeItem>();

		for (Det item : dets) {
			Produto produto = buscarProduto(item.getProd());

			NfeItem bean = new NfeItem();
			bean.setNfe(nfe);
			bean.setProdutoItem(produto);
			bean.setQuantidadeItem(Float.valueOf(item.getProd().getQCom())
					.intValue());
			bean.setValorUnitarioItem(Float.parseFloat(item.getProd()
					.getVUnCom()));
			lista.add(bean);

			Float custoMedio = produto.getCustoMedioProduto();
			Integer qtdeEstoque = produto.getQuantidadeProduto();
			
			if (custoMedio == null) {
				custoMedio = 0F;
			}
			
			if (qtdeEstoque == null) {
				qtdeEstoque = 0;
			}

			float custoTotal = custoMedio * qtdeEstoque;

			custoTotal = custoTotal + bean.getValorUnitarioItem() * bean.getQuantidadeItem();
			
			int qtdeTotal = qtdeEstoque + bean.getQuantidadeItem();
			
			produto.setQuantidadeProduto(qtdeTotal);
			produto.setCustoMedioProduto(custoTotal / qtdeTotal);

		}

		return lista;
	}

	private Produto buscarProduto(Prod prod) {
		Produto produto = produtoService.buscarPorCodigo(prod.getCProd());

		if (produto == null) {
			produto = new Produto();
			produto.setCodigoProduto(prod.getCProd());
			produto.setDescricaoProduto(prod.getXProd());
			produto = produtoService.salvar(produto);
		}

		return produto;
	}

	private Pessoa buscarFornecedor(Emit emit) {
		Pessoa fornecedor = pessoaService.buscarPorCodigo(emit.getCNPJ());

		if (fornecedor == null) {
			fornecedor = new Pessoa();
			fornecedor.setCodigoPessoa(emit.getCNPJ());
			fornecedor.setEnderecoPessoa(criarEndereco(emit.getEnderEmit()));
			fornecedor.setNomePessoa(emit.getXNome());
			fornecedor.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
			fornecedor.setTipoCadastroPessoa(TipoCadastroPessoa.FORNECEDOR);

			fornecedor = pessoaService.salvar(fornecedor);
		}

		return fornecedor;
	}

	private Endereco criarEndereco(TEnderEmi enderEmit) {
		Endereco end = new Endereco();
		end.setCep(enderEmit.getCEP());
		end.setCidade(enderEmit.getXMun());
		end.setComplemento(enderEmit.getXCpl());
		end.setEstado(enderEmit.getUF().name());
		end.setLogradouro(enderEmit.getXLgr());
		end.setNumero(enderEmit.getNro());

		return end;
	}

	public List<Nfe> listar() {
		return em.createNamedQuery("nfe.findAll", Nfe.class).getResultList();
	}

	public Nfe buscarPorId(Integer id) {
		return em.find(Nfe.class, id);
	}

	public Nfe salvar(Nfe nfe) {
		if (nfe.getNfeSq() == null) {
			em.persist(nfe);
		} else {
			nfe = em.merge(nfe);
		}
		return nfe;
	}

	public List<Nfe> pesquisar(String filtro) {
		throw new UnsupportedOperationException("Filtrar NFe");
	}

}
