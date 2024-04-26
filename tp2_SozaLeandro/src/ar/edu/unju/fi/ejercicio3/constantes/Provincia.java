package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611, 53291),
	SALTA(1440000, 155488),
	TUCUMAN(1730000, 22524),
	CATAMARCA(430000, 102602),
	LA_RIOJA(380000, 89680),
	SANTIAGO_DEL_ESTERO(106000, 136351);
	
	private Integer cantidadPob;
	private Integer superficie;
	
	private Provincia() {
	}

	private Provincia(Integer cantidadPob, Integer superficie) {
		this.cantidadPob = cantidadPob;
		this.superficie = superficie;
	}

	public Integer getCantidadPob() {
		return cantidadPob;
	}

	public Integer getSuperficie() {
		return superficie;
	}

	public Double calcularDensidadPoblacion() {
		return (double) (this.getCantidadPob()/this.getSuperficie());
	}
	
}
