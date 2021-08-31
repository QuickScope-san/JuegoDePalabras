package juegoDePalabras;

import java.awt.EventQueue;

public class PrincipalJuegoDePalabras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//ControlJuegoDePalabras consola = new ControlJuegoDePalabras();
				
				GuiJuegoDePalabras miVista = new GuiJuegoDePalabras();			
			}
		});;
	}

}
