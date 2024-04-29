package ar.edu.unju.fi.ejercicio5.model;


public class Producto {
	private Integer codigoProd;
	private String descripcionProd;
	private Float precioUnit;
	private boolean estadoProd;
	private OrigenFab origenFab;
	private Categoria categoriaProd;
	
	public enum OrigenFab {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto() {
	}

	public Producto(Integer codigoProd, String descripcionProd, Float precioUnit, boolean estadoProd,
			OrigenFab origenFab, Categoria categoriaProd) {
		this.codigoProd = codigoProd;
		this.descripcionProd = descripcionProd;
		this.precioUnit = precioUnit;
		this.estadoProd = estadoProd;
		this.origenFab = origenFab;
		this.categoriaProd = categoriaProd;
	}

	public Integer getCodigoProd() {
		return codigoProd;
	}

	public void setCodigoProd(Integer codigoProd) {
		this.codigoProd = codigoProd;
	}

	public String getDescripcionProd() {
		return descripcionProd;
	}

	public void setDescripcionProd(String descripcionProd) {
		this.descripcionProd = descripcionProd;
	}

	public Float getPrecioUnit() {
		return precioUnit;
	}

	public void setPrecioUnit(Float precioUnit) {
		this.precioUnit = precioUnit;
	}

	public boolean isEstadoProd() {
		return estadoProd;
	}

	public void setEstadoProd(boolean estadoProd) {
		this.estadoProd = estadoProd;
	}

	public OrigenFab getOrigenFab() {
		return origenFab;
	}

	public void setOrigenFab(OrigenFab origenFab) {
		this.origenFab = origenFab;
	}

	public Categoria getCategoriaProd() {
		return categoriaProd;
	}

	public void setCategoriaProd(Categoria categoriaProd) {
		this.categoriaProd = categoriaProd;
	}
	
	
	
}
