package me.alejandro;

/**
 * Propiedades de las que dotan las editoriales
 * @author Alejandro Ruiz Bonillo
 * @version 1.0
 */

public class Editorial {
	
	private String codigo;
	private String razonSocial;
	private String domicilio;
	private int telefono;
	private String correo;
	
	public Editorial() {
		
	}
	
	public Editorial(String codigo, String razonSocial, String domicilio, int telefono, String correo) {
		super();
		this.codigo = codigo;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */
	public String getCodigo() {
		return codigo;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public int getTelefono() {
		return telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/*
	 * TO STRING
	 */
	@Override
	public String toString() {
		return "Editorial [codigo=" + codigo + ", razonSocial=" + razonSocial + ", domicilio=" + domicilio
				+ ", telefono=" + telefono + ", correo=" + correo + "]";
	}

}
