package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
	
	//private static ArrayList<Provincia> provincias;
	
	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
		
		System.out.println("***LISTA DE PROVINCIAS***");
		for(Provincia prov: provincias) {
			System.out.println("Provincia: "+prov.name());
			System.out.println("Cantidad de población: "+prov.getCantidadPob()
			+" habitantes");
			System.out.println("Superficie: "+prov.getSuperficie()+" Km2");
			System.out.println("Densidad poblacional: "+
			String.format("%.2f",prov.calcularDensidadPoblacion())+" hab./km2");
			System.out.println("---------------");
		}
		
	}

}
