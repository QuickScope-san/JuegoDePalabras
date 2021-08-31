package juegoDePalabras;

public class ControlJuegoDePalabras {
	private GestorDeArchivosJuegoDePalabras gestorArchivo;
	private int fallos, serie, estado, nivel, palabrasAcertadas;
	private boolean ganar;
	
	public ControlJuegoDePalabras() {
		gestorArchivo = new GestorDeArchivosJuegoDePalabras();
		ganar=false;
		nivelInicial();
	}
	
	public void nivelInicial() {
		fallos = 0;
		serie = 1;
		nivel = 1;
		palabrasAcertadas=0;
		gestorArchivo.AbrirArchivo(nivel, serie);
	}
	
	public void pasarNivel() {
		if(ganar) {
			if(nivel == 1) {
				fallos = 0;
				serie = 2;
				gestorArchivo.AbrirArchivo(nivel, serie);
			}
			if(nivel == 2) {
				fallos=0;
				serie=1;
				gestorArchivo.AbrirArchivo(nivel, serie);
			}
		}
		else {
			fallos = 0;
			nivel =+ nivel;
			serie = 1;
			gestorArchivo.AbrirArchivo(nivel, serie);
		}
	}
	
	public void compararPalabras() {
		// ? 
	}
	
	
	public void progreso() {
		palabrasAcertadas+=1;
		fallos+=1;
	}
	
	/*public void perderNivel() {
		progreso();
		if(nivel == 1 && fallos==3) {
			fallos=0;
			serie=1;
			gestorArchivo.AbrirArchivo(nivel, serie);
		}
	}*/
	
	public void determinarJuego() {
		estado = 1; //perder
	}

	public GestorDeArchivosJuegoDePalabras getGestorArchivo() {
		return gestorArchivo;
	}

	public int getFallos() {
		return fallos;
	}

	public int getSerie() {
		return serie;
	}

	public int getEstado() {
		return estado;
	}

	public int getNivel() {
		return nivel;
	}

	public int getPalabrasAcertadas() {
		return palabrasAcertadas;
	}

	public boolean isGanar() {
		return ganar;
	}
	
	
}
