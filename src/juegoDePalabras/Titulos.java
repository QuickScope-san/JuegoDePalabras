package juegoDePalabras;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Titulos extends JLabel {
	
	public Titulos(String texto, int tamanoTexto, Color colorLetra,
			Icon iconoLabel, boolean alineacionVertical, 
			boolean alineacionHorizontal) {
		
		this.setText(texto);
		Font fuenteLetra = new Font(Font.DIALOG_INPUT, Font.BOLD+Font.ITALIC, tamanoTexto);
		this.setFont(fuenteLetra);
		this.setForeground(colorLetra);
		this.setIcon(iconoLabel);
		
		if(alineacionVertical) {
			
			this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
			
		}
		
		if(alineacionHorizontal) {
			
			this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			
		}
		
	}
	
	public Titulos(String texto, int tamanoTexto, Color colorLetra) {
		
		this.setText(texto);
		Font fuenteLetra = new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, tamanoTexto);
		this.setFont(fuenteLetra);
		this.setForeground(colorLetra);
		
	}
	
	
}
