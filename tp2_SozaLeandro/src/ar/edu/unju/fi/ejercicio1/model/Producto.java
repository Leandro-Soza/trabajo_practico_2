package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private Integer codigoProd;
	private String descripcionProd;
	private Float precioUnit;
	private OrigenFabricacion origenProd;
	private Categoria categoriaProd;
	
	
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto() {
	}

	public Producto(Integer codigoProd, String descripcionProd, Float precioUnit, OrigenFabricacion origenProd,
			Categoria categoriaProd) {
		this.codigoProd = codigoProd;
		this.descripcionProd = descripcionProd;
		this.precioUnit = precioUnit;
		this.origenProd = origenProd;
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

	public OrigenFabricacion getOrigenProd() {
		return origenProd;
	}

	public void setOrigenProd(OrigenFabricacion origenProd) {
		this.origenProd = origenProd;
	}

	public Categoria getCategoriaProd() {
		return categoriaProd;
	}

	public void setCategoriaProd(Categoria categoriaProd) {
		this.categoriaProd = categoriaProd;
	}

	@Override
	public String toString() {
		return "Codigo=" + codigoProd + 
				"\nDescripcion=" + descripcionProd +
				"\nPrecio=$"+ precioUnit +
				"\nOrigen=" + origenProd + 
				"\nCategoria=" + categoriaProd;
	}
	
	
	
}
