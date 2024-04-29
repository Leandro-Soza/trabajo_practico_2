package ar.edu.unju.fi.ejercicio5.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {

	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	public PagoTarjeta() {
	}
	
	

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}



	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}



	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}



	public LocalDate getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}



	public double getMontoPagado() {
		return montoPagado;
	}



	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}



	@Override
	public void realizarPago(double monto) {
		double recarga;
		recarga=monto*(15/100);
		setMontoPagado(getMontoPagado()+recarga);
	}

	@Override
	public void imprimirRecibo() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		System.out.println("*****DATOS DE RECIBO*****");
		System.out.println("Número de tarjeta: "+getNumeroTarjeta());
		System.out.println("Fecha de pago: "+formato.format(fechaPago));
		System.out.println("Monto pagado: "+getMontoPagado());
		System.out.println("--------------------");
	}

}
