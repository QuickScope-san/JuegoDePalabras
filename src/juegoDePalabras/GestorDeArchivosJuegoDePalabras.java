package juegoDePalabras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDeArchivosJuegoDePalabras {
	
	private FileReader fileRead,fileRead2;
	private BufferedReader input,input2;
	private FileWriter fileWriter,vaciar;
	private BufferedWriter output,output2;
	private ArrayList<String> palabras,palabrasUsuario;

	public GestorDeArchivosJuegoDePalabras() {
		palabras = new ArrayList<String>();
		palabrasUsuario = new ArrayList<String>();
		AbrirArchivo(1,1);
		leerPalabrasJugador();
	}
	
	public String AbrirArchivo(Integer numNivel, Integer numSerie) {
		String salida = "";
		
		try {
			fileRead = new FileReader("src/archivos/Nivel"+numNivel+"Serie"+numSerie);
			input = new BufferedReader(fileRead);
			
				String texto = input.readLine();
				palabras.add(texto);
					
				while(texto!=null) {
					salida+=texto;
					salida+="\n";
					texto = input.readLine();
					if(texto != null && !texto.equals("\n")) {
						palabras.add(texto);
					}
				}
				
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return salida;
	}
	
	public String leerPalabrasJugador() {
		String salida = "";
		
		try {
			fileRead2 = new FileReader("src/archivos/palabrasUsuario");
			input2 = new BufferedReader(fileRead2);
			
			String texto = input2.readLine();
			palabrasUsuario.add(texto);
			
			while(texto!=null) {
				salida+=texto;
				salida+="\n";
				texto = input2.readLine();
				if(texto != null && !texto.equals("\n")) {
					palabrasUsuario.add(texto);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return salida;
		
	}
	
	public void escribirArchivo(String linea, Integer numJugador) {
		
		try {
			fileWriter = new FileWriter("src/archivos/palabrasUsuario",true);
			output = new BufferedWriter(fileWriter);
			output.write(linea);
			output.newLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void vaciarArchivo() {
		try {
			vaciar = new FileWriter("src/archivos/palabrasUsuario",false);
			output2 = new BufferedWriter(vaciar);
			output2.write("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				output2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> getPalabras() {
		return palabras;
	}

	public ArrayList<String> getPalabrasUsuario() {
		return palabrasUsuario;
	}
	
	
}
