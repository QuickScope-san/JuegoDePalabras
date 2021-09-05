package juegoDePalabras;

import java.util.ArrayList;

public class ControlJuegoDePalabras {
	
	//public static final int serie1 = 1,serie2 = 2;
	//public static final int nivel1=1,nivel2=2,nivel3=3,nivel4=4,nivel5=5;
	
	private GestorDeArchivosJuegoDePalabras gestorArchivo;
	private int fallos, estado, palabrasAcertadas, aciertos, nivel, serie, comparacion;
	
	public ControlJuegoDePalabras() {
		gestorArchivo = new GestorDeArchivosJuegoDePalabras();
		nivelInicial();
	}
	
	public void nivelInicial() {
		serie = 1; comparacion = 0;
		nivel = 1; fallos = 0;
		palabrasAcertadas=0; aciertos = 0;
	}
	
	
	/*public boolean compararPalabras() {
		return gestorArchivo.getPalabras().contains(gestorArchivo.getPalabrasUsuario().get(gestorArchivo.getPalabrasUsuario().size()-1));
	}
*/	
	public void pasarSerie() {
		if(nivel == 1 && serie == 1 && palabrasAcertadas == 4 && fallos <= 3) {      //nivel 1, serie 2
			nivel=1; serie=2; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		if(nivel == 2 && serie == 1 && palabrasAcertadas == 6 && fallos <= 4) {		//nivel 2, serie 2
			nivel=2; serie=2; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		if(nivel == 3 && serie == 1 && palabrasAcertadas == 8 && fallos <= 6) {		//nivel 3, serie 2
			nivel=3; serie=2; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		if(nivel == 4 && serie == 1 && palabrasAcertadas == 10 && fallos <= 7) {	//nivel 4, serie 2
			nivel=4; serie=2; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		if(nivel == 5 && serie == 1 && palabrasAcertadas == 12 && fallos <= 9) {	//nivel 5, serie 2
			nivel=5; serie=2; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		
	}
	
	public void pasarNivel() {
			//pasarSerie();
			if(nivel == 1 && serie == 2 && palabrasAcertadas == 7 || palabrasAcertadas == 8 && fallos <= 3) {		//nivel 2, serie 1
				fallos = 0; nivel=2; serie=1; aciertos = 0; palabrasAcertadas = 0;
				gestorArchivo.vaciarArchivo();
				gestorArchivo.leerPalabrasJugador();
			}
			if(nivel == 2 && serie == 2 && palabrasAcertadas == 9 || palabrasAcertadas == 12 && fallos <= 4) {		//nivel 3, serie 1
				fallos = 0; nivel=3; serie=1; aciertos = 0; palabrasAcertadas = 0;
				gestorArchivo.vaciarArchivo();
				gestorArchivo.leerPalabrasJugador();
			}
			if(nivel == 3 && serie == 2 && palabrasAcertadas == 12 || palabrasAcertadas == 16 && fallos <= 6) {	//nivel 4, serie 1
				fallos = 0; nivel=4; serie=1; aciertos = 0; palabrasAcertadas = 0;
				gestorArchivo.vaciarArchivo();
				gestorArchivo.leerPalabrasJugador();
			}
			if(nivel == 4 && serie == 2 && palabrasAcertadas == 15 || palabrasAcertadas == 20 && fallos <= 7) {	//nivel 5, serie 1
				fallos = 0; nivel=5; serie=1; aciertos = 0; palabrasAcertadas = 0;
				gestorArchivo.vaciarArchivo();
				gestorArchivo.leerPalabrasJugador();
			}
			determinarJuego();								//ganar
	}
	
	public boolean condicionContinuar() {
		if(comparacion == 8 && nivel == 1) {
			return true;
		}
		if(comparacion == 12 && nivel == 2) {
			return true;
		}
		if(comparacion == 16 && nivel == 3) {
			return true;
		}
		if(comparacion == 20 && nivel == 4) {
			return true;
		}
		if(comparacion == 24 && nivel == 5) {
			return true;
		}
		return false;
	}
	
	public Integer indiceElemento(ArrayList<String> list, String element) {
		return list.indexOf(element);
	}
	
	public void progreso() {
			palabrasAcertadas+=1;
			aciertos += 1;
			comparacion+=1;
			pasarSerie();
	}
	
	public void fallos() {
		fallos += 1;
		perderNivel();
	}
	
	public void perderNivel() {
		if(nivel == 1 && fallos == 4) {
			fallos=0; serie=1; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		if(nivel == 2 && fallos == 5) {
			fallos=0; serie=1; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		if(nivel == 3 && fallos == 7) {
			fallos=0; serie=1; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		if(nivel == 4 && fallos == 8) {
			fallos=0; serie=1; aciertos = 0;
			gestorArchivo.vaciarArchivo();
			gestorArchivo.leerPalabrasJugador();
		}
		determinarJuego(); //perder
	}
	
	public void determinarJuego() {
		if(nivel == 5 && serie == 2 && palabrasAcertadas == 18 || palabrasAcertadas == 24 && fallos <= 9)
			estado = 0; //ganar el juego
		else {
			if(fallos == 10) {
				estado = 1; // perder el juego
			}		
		}
	}

	public GestorDeArchivosJuegoDePalabras getGestorArchivo() {
		return gestorArchivo;
	}

	public int getFallos() {
		return fallos;
	}
	
	public int getAciertos() {
		return aciertos;
	}

	public int getNivel() {
		return nivel;
	}
	
	public int getSerie() {
		return serie;
	}

	public int getEstado() {
		return estado;
	}

	public int getPalabrasAcertadas() {
		return palabrasAcertadas;
	}
	
	
}
