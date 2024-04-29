package ar.edu.unju.fi.ejercicio5.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
		double descuento;
		descuento=monto*(10/100);
		setMontoPagado(getMontoPagado()-descuento);
	}

	@Override
	public void imprimirRecibo() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		System.out.println("*****DATOS DE RECIBO*****");
		System.out.println("Fecha de pago: "+formato.format(fechaPago));
		System.out.println("Monto pagado: "+getMontoPagado());
		System.out.println("--------------------");
	}

}
