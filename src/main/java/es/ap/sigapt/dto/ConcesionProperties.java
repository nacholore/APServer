package es.ap.sigapt.dto;

import es.ap.sigapt.dto.base.PropertiesImpl;

public class ConcesionProperties extends PropertiesImpl {

	private String description;
	private String expediente;
	private String titular;
	private String code;
	private String port;

	public ConcesionProperties() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
