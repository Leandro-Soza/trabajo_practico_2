package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	private static Scanner sc;
	private static ArrayList<Producto> productos;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		productos = new ArrayList<>();
		byte op = 0;
		
		do {
			try {
				op=menu();
				switch(op) {
				case 1: System.out.println("***Creación de Producto***");
				crearProducto();
				System.out.println("---------------");
				break;
				case 2: System.out.println("***Mostrar Productos***");
				mostrarProducto();
				System.out.println("---------------");
				break;
				case 3: System.out.println("***Modificación de producto***");
				modificarProducto();
				System.out.println("---------------");
				break;
				case 4: System.out.println("Fin del programa!");
				System.out.println("---------------");
				break;
				default: System.out.println("Opción Incorrecta!!");
				}
			}catch(InputMismatchException e) {
				System.out.println("ERROR en el ingreso de datos");
				System.out.println("Debe ingresar un numero entero (byte)");
				System.out.println("---------------");
				sc.nextLine();
			}
		}while(op!=4);
		sc.close();
		
	}
	
	public static byte menu() {
		System.out.println("****MENU DE OPCIONES****");
		System.out.println("1-Crear Producto");
		System.out.println("2-Mostrar Productos");
		System.out.println("3-Modificar Productos");
		System.out.println("4-Salir");
		System.out.println("--------------------");
		System.out.println("Ingrese su opción: ");
		byte op = sc.nextByte();
		return op;
	}
	
	public static String menuOrigenFabricacion() {
		System.out.println("***Origen de Fabricación***");
		System.out.println("1 - Argentina");
		System.out.println("2 - China");
		System.out.println("3 - Brasil");
		System.out.println("4 - Uruguay");
		System.out.print("Ingrese su opción: ");
		String op = sc.nextLine();
		return op;
		
	}
	
	public static String menuCategoria() {
		System.out.println("*****Categorias*****");
		System.out.println("1 - Telefonía");
		System.out.println("2 - Informática");
		System.out.println("3 - Electro hogar");
		System.out.println("4 - Herramientas");
		System.out.print("Ingrese su opción: ");
		String op = sc.nextLine();
		return op.replaceAll(" ", "");
	}
	
	public static void crearProducto() {
		try {
			System.out.print("Ingrese código de producto: ");
			Integer codigo = sc.nextInt();
			sc.nextLine();
			System.out.print("Ingrese breve descripción del producto: ");
			String descrip = sc.nextLine();
			System.out.print("Ingrese precio unitario: ");
			Float precio = sc.nextFloat();
			sc.nextLine();
			String opof = menuOrigenFabricacion();
			String opc = menuCategoria();
			productos.add(new Producto(codigo, descrip, precio, OrigenFabricacion.valueOf(opof.toUpperCase()),Categoria.valueOf(opc.toUpperCase())));
			
		}catch(Exception ex) {
			System.out.println("ERROR en el ingreso de los valores!!!");
			System.out.println("Código de producto debe ser entero");
			System.out.println("Precio debe ser numero");
			System.out.println("Eliga opción correcta para carga de datos");
		}finally {
			System.out.println("Vuelta al menú");
		}
		
	}
	
	public static void mostrarProducto() {
		if(productos.isEmpty()) {
			System.out.println("No hay nada que mostrar");
		}else {
			productos.forEach(p->System.out.println(p));
		}
	}
	
	public static void modificarProducto() {
		int cont=0;
		System.out.print("Ingrese código de producto a modificar: ");
		Integer cod = sc.nextInt();
		sc.nextLine();
		for(Producto product: productos) {
			if(product.getCodigoProd().equals(cod)) {
				boolean aux = false;
				do {
					System.out.print("Ingrese descripción producto: ");
					String descrip = sc.nextLine();
					product.setDescripcionProd(descrip);
					System.out.print("Ingrese precio unitario: ");
					Float unit = sc.nextFloat();
					sc.nextLine();
					product.setPrecioUnit(unit);
					String oprod = menuOrigenFabricacion();
					product.setOrigenProd(OrigenFabricacion.valueOf(oprod.toUpperCase()));
					String catprod = menuCategoria();
					product.setCategoriaProd(Categoria.valueOf(catprod.toUpperCase()));
					cont++;
					aux=true;
					break;
				}while(aux==false);
			}
		}
		if(cont==1) {
			System.out.println("Se modifico el producto codigo "+cod);
		}else {
			System.out.println("No existe producto a modificar!");
		}
	}
}
