package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFab;

public class Main {
	
	private static Scanner sc;
	private static ArrayList<Producto> productos;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		productos = new ArrayList<>();
		byte op=0;
		do {
			try {
				precargarProductos();
				op=menu();
				switch(op) {
				case 1: System.out.println("***PRODUCTOS EN EXISTENCIA***");
				mostrarProd();
				break;
				case 2: System.out.println("***PRODUCTOS FALTANTES***");
				mostrarProdFaltantes();
				break;
				case 3: System.out.println("***INCREMENTO DE PRECIOS***");
				incremetarPrecios();
				productos.clear();
				break;
				case 4: System.out.println("***PRODUCTOS ELECTROHOGAR EN STOCK***");
				mostrarProdCat();
				break;
				case 5: System.out.println("***ORDENACION POR PRECIO DESCENDENTE");
				ordenarPrecios();
				break;
				case 6: System.out.println("***MOSTRAR EN MAYUSCULAS***");
				mostrarProdMayus();
				break;
				case 7: System.out.println("****FIN DEL PROGRAMA****");
				break;
				default: System.out.println("¡Opción Incorrecta!");
				}
			}catch(Exception e) {
				System.out.println("Verifique de ingresar datos correctos");
				sc.nextLine();
			}
		}while(op!=7);
	}
	/**
	 * Menu de opciones
	 * @return opcion elegida
	 */
	public static byte menu() {
		byte op=0;
		while(true) {
			try {
				System.out.println("****MENU DE OPCIONES****");
				System.out.println("1 - Mostrar productos");
				System.out.println("2 - Mostrar productos faltantes");
				System.out.println("3 - Incrementar los precios de los productos en un 20%");
				System.out.println("4 - Mostrar los productos que corresponden a la categoria ElectroHogar y estén disponibles para venta");
				System.out.println("5 - Ordenar los productos por precio de forma descendente");
				System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
				System.out.println("7 - Salir");
				System.out.print("Ingrese su opción: ");
				op = sc.nextByte();
				break;
			}catch(InputMismatchException e) {
				System.out.println("Debe ingresar un numero como opción!");
				sc.nextLine();
			}
		}
		return op;
	}
	/**
	 * Se realiza la precarga de productos para poder operar
	 */
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
	/**
	 * Muestra de productos en Stock
	 */
	public static void mostrarProd() {
		Consumer<Producto> products = p -> {
			if(p.isEstadoProd()==true) {
				System.out.println(p);
			}
		};
		productos.forEach(products);
	}
	/**
	 * Muestras de productos que no se encuentran en Stock
	 */
	public static void mostrarProdFaltantes() {
		Predicate<Producto> estadoFalso = p -> !p.isEstadoProd();
		productos.stream().filter(estadoFalso).forEach(System.out::println);
	}
	/**
	 * Incremento del 20% en los precios
	 */
	public static void incremetarPrecios() {
		Function<Producto, Producto> funcionIncremento = (p) -> {
			int rdo = (int) (p.getPrecioUnit() + (p.getPrecioUnit()*0.2));
			p.setPrecioUnit(rdo);
			return p;
		};
		List<Producto> productosIncrementados = new ArrayList<>();
		productosIncrementados = productos.stream().map(funcionIncremento).collect(Collectors.toList());
		productosIncrementados.forEach(System.out::println);
	}
	/**
	 * Muestra de productos por categoria ElectroHogar y que se encuentren en Stock
	 */
	public static void mostrarProdCat() {
		Predicate<Producto> listaDisponible = p -> p.getCategoriaProd().equals(Categoria.ELECTROHOGAR)
				&& p.isEstadoProd();
		productos.stream().filter(listaDisponible).forEach(System.out::println);
	}
	/**
	 * Ordenamiento por precios de mayor a menor
	 */
	public static void ordenarPrecios() {
		productos.sort(Comparator.comparing(Producto::getPrecioUnit).reversed());
		productos.forEach(p->System.out.println(p));
	}
	/**
	 * Muestra de productos cuya descripcion es en mayusculas
	 */
	public static void mostrarProdMayus() {
		Function<Producto, Producto> funcionMayuscula = (p) -> {
			String rdo = p.getDescripcionProd().toUpperCase();
			p.setDescripcionProd(rdo);
			return p;
		};
		productos.stream().map(funcionMayuscula).forEach(p->System.out.println(p));
	}
	
}
