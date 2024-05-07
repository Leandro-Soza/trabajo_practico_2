package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFab;

public class Main {
	
	private static Scanner sc;
	private static ArrayList<Producto> productos;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		productos = new ArrayList<>();
		
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
	
}
