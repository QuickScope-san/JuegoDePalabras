package juegoDePalabras;

public class ControlJuegoDePalabras {
	private GestorDeArchivosJuegoDePalabras gestorArchivo;
	private int fallos, serie, estado;
	private boolean ganar, perder;
	
	public ControlJuegoDePalabras() {
		gestorArchivo = new GestorDeArchivosJuegoDePalabras();
		fallos = 0;
		serie = 1;
	}
	
	public void pasarNivel() {
		if(ganar) {
			
		}
	}
}
