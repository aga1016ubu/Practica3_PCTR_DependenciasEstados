package src.p03.c01;

import java.util.Enumeration;
import java.util.Hashtable;

public class Parque implements IParque{

	private int contadorPersonasTotales;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
	private int aforoMaximo;
	
	
	public Parque(int aforo) {	
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
		this.aforoMaximo = aforo;
	}


	@Override
	public void entrarAlParque(String puerta){		
		
		// TODO
		comprobarAntesDeEntrar();
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO
		int contadorDePuerta = contadoresPersonasPuerta.get(puerta);
		contadorDePuerta+=1;
		contadoresPersonasPuerta.put(puerta, contadorDePuerta);
				
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)+1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
		
		// TODO
		// Comrpobar invariante
		checkInvariante();
		
		// TODO
		
	}
	
	// 
	// TODO Método salirDelParque
	//
	@Override
	public void salirDelParque(String puerta) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	private void imprimirInfo (String puerta, String movimiento){
		System.out.println(movimiento + " por puerta " + puerta);
		System.out.println("--> Personas en el parque " + contadorPersonasTotales); //+ " tiempo medio de estancia: "  + tmedio);
		
		// Iteramos por todas las puertas e imprimimos sus entradas
		for(String p: contadoresPersonasPuerta.keySet()){
			System.out.println("----> Por puerta " + p + " " + contadoresPersonasPuerta.get(p));
		}
		System.out.println(" ");
	}
	
	private int sumarContadoresPuerta() {
		int sumaContadoresPuerta = 0;
			Enumeration<Integer> iterPuertas = contadoresPersonasPuerta.elements();
			while (iterPuertas.hasMoreElements()) {
				sumaContadoresPuerta += iterPuertas.nextElement();
			}
		return sumaContadoresPuerta;
	}
	
	protected void checkInvariante() {
		assert sumarContadoresPuerta() == contadorPersonasTotales : "INV: La suma de contadores de las puertas debe ser igual al valor del contador del parte";
		assert contadorPersonasTotales <= aforoMaximo : "INV: El n�mero de personas supera el aforo m�ximo permitido";
		assert contadorPersonasTotales >= 0 : "INV: No pueden salir personas si est� vac�o el parque";

	}

	protected void comprobarAntesDeEntrar(){	// TODO
		//
		// TODO
		//
	}

	protected void comprobarAntesDeSalir(){		// TODO
		//
		// TODO
		//
	}


}
