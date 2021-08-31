package juegoDePalabras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorDeArchivosJuegoDePalabras {
	
	private FileReader fileRead;
	private BufferedReader input;
	private FileWriter fileWriter;
	private BufferedWriter output;
	
	public String AbrirArchivo(Integer numArchivo) {
		String salida = "";
		
		try {
			fileRead = new FileReader("src/resources/diccionario"+numArchivo+"");
			input = new BufferedReader(fileRead);
			
				String texto = input.readLine();
			
				while(texto!=null) {
					salida+=texto;
					salida+="\n";
					texto = input.readLine();
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
	
	public void escribirArchivo(String linea) {
		
		try {
			fileWriter = new FileWriter("src/resources/diccionario2",true);
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
}
