package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611, 53291),
	SALTA(1441351, 155488),
	TUCUMAN(1731820, 22524),
	CATAMARCA(429562, 102602),
	LA_RIOJA(383865, 89680),
	SANTIAGO_DEL_ESTERO(1060906, 136351);
	
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

	public Float calcularDensidadPoblacion() {
		return cantidadPob/(float)superficie;
	}
	
}
