package juegoDePalabras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorDeArchivosJuegoDePalabras {
	
	private FileReader fileRead,fileRead2;
	private BufferedReader input,input2;
	private FileWriter fileWriter,vaciar;
	private BufferedWriter output,output2;
	private ArrayList<String> palabras,palabrasUsuario;
	
	private FileInputStream fileInputStream;
	private ObjectInputStream inputStream;
	private FileOutputStream fileOutputStream;
	private ObjectOutputStream outputStream;

	public GestorDeArchivosJuegoDePalabras() {
		palabras = new ArrayList<String>();
		palabrasUsuario = new ArrayList<String>();
		AbrirArchivo(1,1);
		leerUsuario("palabrasUsuario");
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
	
	
	public String leerUsuario(String archivo) {
		String salida = "";
		
		try {
			fileRead2 = new FileReader("src/archivos/"+archivo);
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
		return salida.toLowerCase();
		
	}
	
	public void escribirArchivo(String linea, String archivo) {
		
		try {
			fileWriter = new FileWriter("src/archivos/"+archivo,true);
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
	
	public void serializarObjeto(Integer nivel, String archivo) {
		
		try {
			fileOutputStream = new FileOutputStream("src/archivos/"+archivo);
			outputStream = new ObjectOutputStream(fileOutputStream);
			
			outputStream.writeObject(nivel);
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
	
	public Integer deserializarObjeto(String archivo) {
		Integer nivel = null;
		
		try {
			fileInputStream = new FileInputStream("src/archivos/"+archivo);
			inputStream = new ObjectInputStream(fileInputStream);
			
			nivel = (Integer)inputStream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nivel;
	}
	
	

	public ArrayList<String> getPalabras() {
		return palabras;
	}

	public ArrayList<String> getPalabrasUsuario() {
		return palabrasUsuario;
	}
	
	
}
