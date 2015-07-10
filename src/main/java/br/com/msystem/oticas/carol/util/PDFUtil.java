package br.com.msystem.oticas.carol.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.msystem.oticas.carol.entity.OrdemServico;
import br.com.msystem.oticas.carol.entity.Venda;
import br.com.msystem.oticas.carol.entity.VendaItem;

public class PDFUtil {

	public static byte[] imprimirVenda(Venda venda) throws JRException, IOException {
		
        List<VendaItem> lista =
            new ArrayList<VendaItem>();

        lista.addAll(venda.getListaItem());

        JasperReport report = null;

        try {
            InputStream reportStream =
                new PDFUtil().getClass().getResourceAsStream("/reports/registroVenda.jrxml");

            report = JasperCompileManager.compileReport(reportStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> parameters = new HashMap<String, Object>();
        JasperPrint print =
            JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(lista));

        byte[] reportByte = JasperExportManager.exportReportToPdf(print);
/*
        FileOutputStream out = new FileOutputStream(new File("/Users/Sergio/report.pdf"));
        out.write(reportByte);
        out.flush();
        out.close();
*/
        return reportByte;

	}
	
	public static byte[] imprimirOS(OrdemServico bean) throws JRException, IOException {

        List<OrdemServico> lista =
            new ArrayList<OrdemServico>();

        lista.add(bean);

        JasperReport report = null;

        try {
            InputStream reportStream =
                new PDFUtil().getClass().getResourceAsStream("/reports/ordemServico.jrxml");
            
            report = JasperCompileManager.compileReport(reportStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> parameters = new HashMap<String, Object>();
        JasperPrint print =
            JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(lista));

        byte[] reportByte = JasperExportManager.exportReportToPdf(print);
/*
        FileOutputStream out = new FileOutputStream(new File("/Users/Sergio/report.pdf"));
        out.write(reportByte);
        out.flush();
        out.close();
*/
        return reportByte;
    }


}
