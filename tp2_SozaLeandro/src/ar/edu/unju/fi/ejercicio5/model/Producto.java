package ar.edu.unju.fi.ejercicio5.model;


public class Producto {
	private Integer codigoProd;
	private String descripcionProd;
	private Integer precioUnit;
	private OrigenFab origenFab;
	private Categoria categoriaProd;
	private boolean estadoProd;
	
	public enum OrigenFab {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto() {
	}

	public Producto(Integer codigoProd, String descripcionProd, Integer precioUnit,
			OrigenFab origenFab, Categoria categoriaProd,  boolean estadoProd) {
		this.codigoProd = codigoProd;
		this.descripcionProd = descripcionProd;
		this.precioUnit = precioUnit;
		this.origenFab = origenFab;
		this.categoriaProd = categoriaProd;
		this.estadoProd = estadoProd;
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

	public Integer getPrecioUnit() {
		return precioUnit;
	}

	public void setPrecioUnit(Integer precioUnit) {
		this.precioUnit = precioUnit;
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

	public boolean isEstadoProd() {
		return estadoProd;
	}

	public void setEstadoProd(boolean estadoProd) {
		this.estadoProd = estadoProd;
	}

	@Override
	public String toString() {
		return "Producto=" + codigoProd + "; Descripción=" + descripcionProd + "; Precio=$"
				+ precioUnit + "; Origen=" + origenFab + "; Categoria=" + categoriaProd + "; Estado="
				+ estadoProd;
	}
	
	
	
}
