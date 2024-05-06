package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFab;

public class Main {
	
	private static Scanner sc;
	private static ArrayList<Producto> productos;
	private static ArrayList<Producto> prodComprados;
	public static void main(String[] args) {
			sc = new Scanner(System.in);
			productos = new ArrayList<>();
			prodComprados = new ArrayList<>();
			PagoTarjeta pagoTarj = new PagoTarjeta();
			PagoEfectivo pagoEfect = new PagoEfectivo();
			byte op=0;
			precargarProductos();
			do {
				try {
					op=menuOp();
					switch(op) {
					case 1: System.out.println("--------------------");
					System.out.println("***MOSTRAR PRODUCTOS***");
					mostrarProducto();
					System.out.println("--------------------");
					break;
					case 2: System.out.println("--------------------");
					System.out.println("***COMPRA DE PRODUCTOS***");
					compraProductos();
					byte opn=0;
					if(prodComprados.isEmpty()) {
						System.out.println("No necesita ingresar método de pago");
					}else {
						do {
							opn = menuPago();
							switch(opn) {
							case 1: System.out.println("***PAGO CON EFECTIVO***");
							double rdoe = montoPagar();
							pagoEfect.realizarPago(rdoe);
							pagoEfect.imprimirRecibo();
							break;
							case 2: System.out.println("**PAGO CON TARJETA***");
							String numTarj=numeroTarjeta();
							double rdo = montoPagar();
							pagoTarj.setNumeroTarjeta(numTarj);
							pagoTarj.realizarPago(rdo);
							pagoTarj.imprimirRecibo();
							break;
							default: System.out.println("***NO ELIGIO MÉTODO DE PAGO***");
							}
						}while(opn!=1 && opn!=2);
					}
					prodComprados.clear();
					System.out.println("--------------------");
					break;
					case 3: System.out.println("--------------------");
					System.out.println("***FIN DEL PROGRAMA***");
					System.out.println("--------------------");
					break;
					default: System.out.println("Opción Incorrecta!");
					}
				}catch(Exception e) {
					
				}
			}while(op!=3);
			
	}
	
	public static void precargarProductos() {
		if(productos.isEmpty()) {
			productos.add(new Producto(1, "Computadora ASUS", 350000, OrigenFab.ARGENTINA, Categoria.INFORMATICA, true));
			productos.add(new Producto(2, "Computadora R5 5600G", 250000, OrigenFab.CHINA, Categoria.INFORMATICA, true));
			productos.add(new Producto(3, "Computadora I9", 200000, OrigenFab.CHINA, Categoria.INFORMATICA, false));
			productos.add(new Producto(4, "Televisor LED", 155640, OrigenFab.BRASIL, Categoria.ELECTROHOGAR, false));
			productos.add(new Producto(5, "Horno", 120000, OrigenFab.URUGUAY, Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(6, "Celular Sony", 240000, OrigenFab.CHINA, Categoria.TELEFONIA, true));
			productos.add(new Producto(7, "Celular LG", 180000, OrigenFab.CHINA, Categoria.TELEFONIA, false));
			productos.add(new Producto(8, "Lavarropas Phillips", 400000, OrigenFab.ARGENTINA, Categoria.ELECTROHOGAR, false));
			productos.add(new Producto(9, "Auriculares", 35000, OrigenFab.URUGUAY, Categoria.INFORMATICA, false));
			productos.add(new Producto(10, "Microondas", 60000, OrigenFab.BRASIL, Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(11, "Televisor LG", 158999, OrigenFab.BRASIL, Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(12, "Destornillador Phillip", 15000, OrigenFab.ARGENTINA, Categoria.HERRAMIENTAS, true));
			productos.add(new Producto(13, "Pinza crimpeadora", 7000, OrigenFab.ARGENTINA, Categoria.HERRAMIENTAS, true));
			productos.add(new Producto(14, "Cinta metrica", 15000, OrigenFab.ARGENTINA, Categoria.HERRAMIENTAS, false));
			productos.add(new Producto(15, "Heladera Phillips", 358900, OrigenFab.URUGUAY, Categoria.ELECTROHOGAR, true));
		}
	}
	
	public static byte menuOp() {
		byte op;
		while(true) {
			try {
				System.out.println("****MENU DE OPCIONES****");
				System.out.println("1 - Mostrar productos");
				System.out.println("2 - Realizar compra");
				System.out.println("3 - Salir");
				System.out.print("Ingrese su opción: ");
				op = sc.nextByte();
				sc.nextLine();
				break;
			}catch(InputMismatchException e) {
				System.out.println("Debe ingresar un número");
				sc.nextLine();
			}
			
		}
		return op;
	}
	
	public static String numeroTarjeta() {
		String tarj = null;
		while(true) {
			System.out.println("Ingrese número de tarjeta: ");
			tarj=sc.nextLine();
			if(tarj.isEmpty()) {
				System.out.println("Número de tarjeta no puede ser vacio");
			}else if(tarj.matches("[0-9]\\d{15}")) {
				break;
			}else {
				System.out.println("Debe contener solo cantidad de 16 números");
			}
		}
		return tarj;
	}
	
	public static void mostrarProducto() {
		if(productos.isEmpty()) {
			System.out.println("No hay productos para mostrar");
		}else {
			for (Producto producto : productos) {
				System.out.println(producto);
			}
		}
	}
	
	public static void mostrarProdComp() {
		if(prodComprados.isEmpty()) {
			System.out.println("No realiza ninguna compra");
		}else {
			for(Producto prod : prodComprados) {
				System.out.println(prod);
			}
		}
	}
	
	public static void compraProductos() {
		char rta;
		int cont=0;
		do {
			System.out.println("***PRODUCTOS DISPONIBLES***");
			for (Producto producto : productos) {
				if(producto.isEstadoProd() == true) {
					System.out.println(producto);
				}
			}
			System.out.print("Ingrese código del producto a comprar: ");
			int cod = sc.nextInt();
			sc.nextLine();
			for (Producto producto : productos) {
				cont=0;
				if(producto.getCodigoProd().equals(cod) && producto.isEstadoProd() == true) {
					prodComprados.add(new Producto(cod, producto.getDescripcionProd(), producto.getPrecioUnit(), producto.getOrigenFab(), producto.getCategoriaProd(), producto.isEstadoProd()));
					System.out.println("Se agrego el producto a la lista");
					cont++;
					break;
				}
			}
			if(cont==0) {
				System.out.println("No existe el producto a agregar");
			}
			System.out.print("Desea seguir comprando? s/n ");
			rta = sc.next().charAt(0);
		}while(rta!='n' && rta!='N');
	}
	
	public static byte menuPago() {
		byte op;
		while(true) {
			try {
				System.out.println("***SELECCIONE FORMA DE PAGO***");
				System.out.println("1 - Pago efectivo");
				System.out.println("2 - Pago con tarjeta");
				System.out.print("Ingrese su opción: ");
				op = sc.nextByte();
				sc.nextLine();
				break;
			}catch(InputMismatchException e) {
				System.out.println("Debe ingresar un número");
				sc.nextLine();
			}
			
		}
		return op;
	}
	
	public static double montoPagar() {
		double suma=0;
		mostrarProdComp();
		for (Producto producto : prodComprados) {
			suma=suma+producto.getPrecioUnit();
			}
		return suma;
	}
	
}
