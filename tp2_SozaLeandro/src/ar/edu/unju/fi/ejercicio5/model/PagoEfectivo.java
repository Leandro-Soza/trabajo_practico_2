package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {

	private double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
	}

	
	
	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}



	public double getMontoPagado() {
		return montoPagado;
	}



	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}



	public LocalDate getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}



	@Override
	public void realizarPago(double monto) {
		double descuento=0, desc=10;
		descuento=monto*(desc/100);
		setMontoPagado(monto-descuento);
	}

	@Override
	public void imprimirRecibo() {
		String fecha=LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
		System.out.println("*****DATOS DE RECIBO*****");
		System.out.println("Fecha de pago: "+fecha);
		System.out.println("Monto pagado: $"+getMontoPagado());
		System.out.println("--------------------");
	}

}
