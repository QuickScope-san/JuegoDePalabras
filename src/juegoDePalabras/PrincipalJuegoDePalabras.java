package juegoDePalabras;

import java.awt.EventQueue;

public class PrincipalJuegoDePalabras {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GuiJuegoDePalabras myVista = new GuiJuegoDePalabras();
			}
		});
	}

}