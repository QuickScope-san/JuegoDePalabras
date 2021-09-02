package juegoDePalabras;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiJuegoDePalabras extends JFrame {
	
	//Icono oersonalizado de login (ruta).
	private final String CHITANDAICON = "src/imagenes/ChitandaPequena.png";
	private ImageIcon iLogeo;
	
	//Imagen de fondo del juego (ruta).
	private final String PYSCHOPASSFONDO = "/imagenes/Psycho-Pass Fondo.jpg"; 
	
	//Declaracion de atributos.
	private String respuestaLogin;
	private JLabel lPalabraAMostrar, lAciertos, lFallos, lSerie1, lSerie2, lPalabrasAcertadas;
	private JButton bTerminarSerie, bReiniciar, bEstadisticas, bSalir;
	private JTextField tfEscrituraParaUsuario;
	private JTextArea taPalabrasRecordadas;
	
	//Declaracion del gestor de diseño del JFrame.
	private Container contenedorJFrame;
	
	//Declaracion de objeto de la clase GestorDeArchivosJuegoDePalabras.
	private GestorDeArchivosJuegoDePalabras archivosJuegoDePalabras;
	
	//Declaracion de objeto de la clase ControlJuegoDePalabras.
	private ControlJuegoDePalabras logicaJuegoDePalabras;
	
	//Declaracion de objeto de la clase privada fondoJuego.
	private FondoJuego fondoGame;
	
	public GuiJuegoDePalabras(){
		
		//Inicilizacion de la variable que se encarga de recibir la respuesta en el login de usuario.
		this.respuestaLogin = "";
		
		//Creacion de icono de logeo.
		this.iLogeo = new ImageIcon(CHITANDAICON);
		
		//Pantalla de login.
		loginUsuario();
		
		//Configuracion de la ventana.
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(new Dimension(1024, 720));
		this.setTitle("J U E G O   D E   P A L A B R A S");
		this.setLocationRelativeTo(null);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Crea e inicializa GUI y sus componentes.
		initJuegoDePalabras();
		
	}

	public void initJuegoDePalabras() {

		//Creacion de Label's.
		this.lPalabraAMostrar = new JLabel();
		this.lAciertos = new JLabel();
		this.lFallos = new JLabel();
		this.lSerie1 = new JLabel();
		this.lSerie2 = new JLabel();
		this.lPalabrasAcertadas = new JLabel();

		//Creacion de Buttons.
		this.bTerminarSerie = new JButton();
		this.bReiniciar = new JButton();
		this.bEstadisticas = new JButton();
		this.bSalir = new JButton();

		//Creacion de TextField's.
		this.tfEscrituraParaUsuario = new JTextField();

		//Creacion de TextArea's.
		this.taPalabrasRecordadas = new JTextArea();
		
		//Creacion del gestor de diseño del JFrame.
		contenedorJFrame = getContentPane();
		
		//Creacion del objeto encargado de comunicarse con los archivos de la clase.
		archivosJuegoDePalabras = new GestorDeArchivosJuegoDePalabras();
		
		//Creacion del objeto encargado de comunicarse con la logica de la clase.
		logicaJuegoDePalabras = new ControlJuegoDePalabras();
		
		//Creacion del objeto encargado de modificar el fondo por defecto de la interfaz grafica.
		fondoGame = new FondoJuego();
		
		//Modificaciones de los layouts de los distintos componentes que hay en la interfaz grafica.
		contenedorJFrame.setLayout(new BorderLayout());
		fondoGame.setLayout(new BorderLayout());
		
		//Agregacion del panel de juego al contenedor principical del JFrame.
		contenedorJFrame.add(fondoGame, BorderLayout.CENTER);
		
	}
	
	private void loginUsuario() {
		
		//Respuesta del usuario.
		respuestaLogin = (String)JOptionPane.showInputDialog(null, "Digite su usuario", "L O G I N", 
													JOptionPane.INFORMATION_MESSAGE, 
													iLogeo,
													null, "");
		
		
		
	}
	
	private class FondoJuego extends JPanel{
		
		//Declaracion de variable tipo Image del panel.
		private Image fondo;
		
		@Override
		public void paint(Graphics g) {
			
			//Obtengo la imagen que deseo usar como fondo.
			fondo = new ImageIcon(getClass().getResource(PYSCHOPASSFONDO)).getImage();
			
			//Dibujo y re-escalo la imagen en el panel
			g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			
			//Instruccion necesaria para cambiar el fondo "por defecto" del panel en cuestion.
			this.setOpaque(false);
			
			//Finalmente pinto la imagen con el objeto g de Graphics.
			super.paint(g);
			
		}
		
	}

}
