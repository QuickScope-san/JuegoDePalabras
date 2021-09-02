package juegoDePalabras;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class PrincipalJuegoDePalabras {

	public static void main(String[] args) {
		
		try {
			
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error en la maquina virtual, debes re-instalar el IDE");
			
		}
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				GuiJuegoDePalabras interfazDeJuego = new GuiJuegoDePalabras();
				
			}
			
			
		});
		

	}

}
