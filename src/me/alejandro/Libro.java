package me.alejandro;

/**
 * Propiedades necesarias para un libro
 * @author Alejandro Ruiz Bonillo
 * @version 1.0
 */

import java.time.LocalDate;

public class Libro {
	private String ISBN;
	private String titulo;
	private String nombreAutores;
	private LocalDate fechaEdicion;
	private String numPaginas;
	private int tipoEncuadernacion;
	
	public Libro() {
		
	}
	
	public Libro(String ISBN, String titulo, String nombreAutores, LocalDate fechaEdicion, String numPaginas,
			int tipoEncuadernacion) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.nombreAutores = nombreAutores;
		this.fechaEdicion = fechaEdicion;
		this.numPaginas = numPaginas;
		this.tipoEncuadernacion = tipoEncuadernacion;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */
	public String getISBN() {
		return ISBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getNombreAutores() {
		return nombreAutores;
	}
	public LocalDate getFechaEdicion() {
		return fechaEdicion;
	}
	public String getNumPaginas() {
		return numPaginas;
	}
	public int getTipoEncuadernacion() {
		return tipoEncuadernacion;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setNombreAutores(String nombreAutores) {
		this.nombreAutores = nombreAutores;
	}
	public void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}
	public void setNumPaginas(String string) {
		this.numPaginas = string;
	}
	public void setTipoEncuadernacion(int tipoEncuadernacion) {
		this.tipoEncuadernacion = tipoEncuadernacion;
	}
	
	/*
	 * TO STRING
	 */
	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", nombreAutores=" + nombreAutores + ", fechaEdicion="
				+ fechaEdicion + ", numPaginas=" + numPaginas + ", tipoEncuadernacion=" + tipoEncuadernacion
				+ "]";
	}

}
