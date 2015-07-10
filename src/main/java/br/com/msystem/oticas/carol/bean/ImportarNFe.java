package br.com.msystem.oticas.carol.bean;

import org.springframework.web.multipart.MultipartFile;

public class ImportarNFe {

	private String name;

	private MultipartFile fileData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}

}
