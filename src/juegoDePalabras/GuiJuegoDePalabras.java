package juegoDePalabras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	private Titulos lPalabraAMostrar, lAciertos, lFallos, lSerie, lNivel;
	private JButton bTerminarSerie, bReiniciar, bEstadisticas, bSalir;
	private JTextField tfEscrituraParaUsuario, tfAciertos, tfFallos, tfSerie, tfNivel;
	private JTextArea taPalabrasRecordadas;
	
	//Deslizable para el area de texto.
	private JScrollPane spDeslizable;
	
	//Declaracion de paneles de ventana.
	private JPanel pInfoPartida, pTextArea, pInfoGame, pInteraccionUsuario;
	
	//Declaracion de paneles auxiliares.
	private JPanel pAuxInfoPartida;
	private JPanel pAuxInfoPartidaAciertosTf;
	private JPanel pAuxInfoPartidaFallosTf;
	private JPanel pPalabraAcertada;
	private JPanel pAuxInfoGame;
	private JPanel pAuxInfoGameSerieTf;
	private JPanel pAuxInfoGameNivelTf;
	private JPanel pTextFieldButtons;
	
	//Declaracion de objeto de la clase privada fondoJuego.
	private FondoJuego fondoGame;
	
	//Deckaracion de objeto encargado de recibir los eventos producidos en los distintos componentes.
	private Escuchas escuchas;
	
	//Declaracion del gestor de diseño del JFrame.
	private Container contenedorJFrame;
	
	//Declaracion de objeto de la clase GestorDeArchivosJuegoDePalabras.
	private GestorDeArchivosJuegoDePalabras archivosJuegoDePalabras;
	
	//Declaracion de objeto de la clase ControlJuegoDePalabras.
	private ControlJuegoDePalabras logicaJuegoDePalabras;
	
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Crea e inicializa GUI y sus componentes.
		initJuegoDePalabras();
		
	}

	public void initJuegoDePalabras() {

		//Creacion de Label's.
		this.lPalabraAMostrar = new Titulos("INICIANDO", 35, new Color(255, 255, 255), 
				new ImageIcon(getClass().getResource("/imagenes/WingsOfFreedoom.png")), true, true);
		lPalabraAMostrar.setPreferredSize(new Dimension(400, 200));
		
		this.lAciertos = new Titulos("Aciertos:", 25, new Color(0, 0, 0));
		lAciertos.setPreferredSize(new Dimension(135, 50));
		
		this.lFallos = new Titulos("Fallos:", 25, new Color(0, 0, 0));
		lFallos.setPreferredSize(new Dimension(135, 50));
		
		this.lSerie = new Titulos("Serie:", 30, new Color(255, 255, 255));
		lSerie.setPreferredSize(new Dimension(120, 50));
		
		this.lNivel = new Titulos("Nivel:", 30, new Color(255, 255, 255));
		lNivel.setPreferredSize(new Dimension(120, 50));
		
		//Creacion de Buttons.
		this.bTerminarSerie = new JButton();
		this.bReiniciar = new JButton();
		this.bEstadisticas = new JButton();
		this.bSalir = new JButton();

		//Creacion de TextField's.
		this.tfEscrituraParaUsuario = new JTextField();
		this.tfAciertos = new JTextField();
		this.tfFallos = new JTextField();
		this.tfSerie = new JTextField();
		this.tfNivel = new JTextField();

		//Creacion de TextArea's.
		this.taPalabrasRecordadas = new JTextArea();
		
		//Creacion de ScrollPane.
		this.spDeslizable = new JScrollPane(taPalabrasRecordadas);
		
		//Creacion de paneles del JFrame.
		this.pInfoPartida = new JPanel();
		this.pTextArea = new JPanel();
		this.pInfoGame = new JPanel();
		this.pInteraccionUsuario = new JPanel();
		
		//Creacion de paneles auxiliares.
		this.pAuxInfoPartida = new JPanel();
		this.pAuxInfoPartidaAciertosTf = new JPanel();
		this.pAuxInfoPartidaFallosTf = new JPanel();
		this.pPalabraAcertada = new JPanel();
		this.pAuxInfoGame = new JPanel();
		this.pAuxInfoGameSerieTf = new JPanel();
		this.pAuxInfoGameNivelTf = new JPanel();
		this.pTextFieldButtons = new JPanel();
		
		//Creacion del objeto encargado de modificar el fondo por defecto de la interfaz grafica.
		fondoGame = new FondoJuego();
		
		//Agregacion de escuchas.
		tfEscrituraParaUsuario.addKeyListener(escuchas);
		bTerminarSerie.addActionListener(escuchas);
		bReiniciar.addActionListener(escuchas);
		bEstadisticas.addActionListener(escuchas);
		bSalir.addActionListener(escuchas);
		
		//Creacion del gestor de diseño del JFrame.
		contenedorJFrame = getContentPane();
		
		//Creacion del objeto encargado de comunicarse con los archivos de la clase.
		archivosJuegoDePalabras = new GestorDeArchivosJuegoDePalabras();
		
		//Creacion del objeto encargado de comunicarse con la logica de la clase.
		logicaJuegoDePalabras = new ControlJuegoDePalabras();
		
		//Modificaciones de los layouts de los distintos componentes que hay en la interfaz grafica.
		contenedorJFrame.setLayout(new BorderLayout());
		
		fondoGame.setLayout(new BorderLayout());
		
		pInfoPartida.setLayout(new FlowLayout());
		pTextArea.setLayout(new FlowLayout());
		pInfoGame.setLayout(new BorderLayout());
		pInteraccionUsuario.setLayout(new FlowLayout());
		
		pAuxInfoPartida.setLayout(new BorderLayout());
		pAuxInfoPartidaAciertosTf.setLayout(new FlowLayout());
		pAuxInfoPartidaFallosTf.setLayout(new FlowLayout());
		pPalabraAcertada.setLayout(new FlowLayout());
		pAuxInfoGame.setLayout(new FlowLayout());
		pAuxInfoGameSerieTf.setLayout(new FlowLayout());
		pAuxInfoGameNivelTf.setLayout(new FlowLayout());
		pTextFieldButtons.setLayout(new FlowLayout());
		
		//Agregacion del panel de juego al contenedor principical del JFrame.
		contenedorJFrame.add(fondoGame, BorderLayout.CENTER);
		
		//Agregacion de componentes a paneles.
		
		tfAciertos.setPreferredSize(new Dimension(30, 30));
		tfAciertos.setBackground(new Color(0, 0, 0, 250));
		tfAciertos.setForeground(new Color(255, 255, 255));
		tfAciertos.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 20));
		tfFallos.setPreferredSize(new Dimension(30, 30));
		tfFallos.setBackground(new Color(0, 0, 0, 250));
		tfFallos.setForeground(new Color(255, 255, 255));
		tfFallos.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 20));
		
		tfSerie.setPreferredSize(new Dimension(30, 30));
		tfSerie.setBackground(new Color(255, 255, 255, 250));
		tfSerie.setForeground(new Color(0, 0, 0));
		tfSerie.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 20));
		tfNivel.setPreferredSize(new Dimension(30, 30));
		tfNivel.setBackground(new Color(255, 255, 255, 250));
		tfNivel.setForeground(new Color(0, 0, 0));
		tfNivel.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 20));
		
		pAuxInfoPartida.setBackground(new Color(255, 255, 255, 150));
		pAuxInfoPartidaAciertosTf.setPreferredSize(new Dimension(100, 50));
		pAuxInfoPartidaAciertosTf.add(lAciertos); pAuxInfoPartidaAciertosTf.add(tfAciertos);
		pAuxInfoPartidaAciertosTf.setOpaque(false);
		pAuxInfoPartidaFallosTf.setPreferredSize(new Dimension(100, 50));
		pAuxInfoPartidaFallosTf.add(lFallos); pAuxInfoPartidaFallosTf.add(tfFallos);
		pAuxInfoPartidaFallosTf.setOpaque(false);
		pAuxInfoPartida.add(pAuxInfoPartidaAciertosTf, BorderLayout.SOUTH); pAuxInfoPartida.add(pAuxInfoPartidaFallosTf, BorderLayout.CENTER);
		pAuxInfoPartida.setPreferredSize(new Dimension(200, 100));
		
		pInfoPartida.add(lPalabraAMostrar);
		pInfoPartida.add(pAuxInfoPartida);
		pInfoPartida.setBackground(new Color(0, 0, 0, 220));
		pInfoPartida.setPreferredSize(new Dimension(715, 220));
		pPalabraAcertada.add(pInfoPartida);
		pPalabraAcertada.setOpaque(false);
		fondoGame.add(pPalabraAcertada, BorderLayout.NORTH);
		
		taPalabrasRecordadas.setPreferredSize(new Dimension(500, 500));
		taPalabrasRecordadas.setBackground(new Color(0, 0, 0, 150));
		taPalabrasRecordadas.setForeground(new Color(255, 255, 255));
		spDeslizable.setBackground(new Color(0, 0, 0, 150));
		spDeslizable.setForeground(new Color(255, 255, 255));
		pTextArea.add(spDeslizable);
		pTextArea.setOpaque(false);
		fondoGame.add(pTextArea, BorderLayout.CENTER);
		
		pAuxInfoGameSerieTf.setOpaque(false);
		pAuxInfoGameSerieTf.setPreferredSize(new Dimension(200, 50));
		pAuxInfoGameSerieTf.add(lSerie); pAuxInfoGameSerieTf.add(tfSerie);
		pAuxInfoGameNivelTf.setOpaque(false);
		pAuxInfoGameNivelTf.setPreferredSize(new Dimension(200, 50));
		pAuxInfoGameNivelTf.add(lNivel); pAuxInfoGameNivelTf.add(tfNivel);
		pInfoGame.add(pAuxInfoGameSerieTf, BorderLayout.NORTH); pInfoGame.add(pAuxInfoGameNivelTf, BorderLayout.CENTER);
		pInfoGame.setPreferredSize(new Dimension(200, 120));
		pInfoGame.setBackground(new Color(0, 0, 0, 250));
		pAuxInfoGame.add(pInfoGame);
		pAuxInfoGame.setOpaque(false);
		fondoGame.add(pAuxInfoGame, BorderLayout.EAST);
		
		tfEscrituraParaUsuario.setPreferredSize(new Dimension(240, 70));
		tfEscrituraParaUsuario.setBackground(new Color(0, 0, 0, 250));
		tfEscrituraParaUsuario.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 25));
		tfEscrituraParaUsuario.setForeground(new Color(255, 255, 255));
		bTerminarSerie.setIcon(new ImageIcon(getClass().getResource("/imagenes/tiempoParcial.png")));
		bTerminarSerie.setText("Terminar Serie");
		bTerminarSerie.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 22));
		bTerminarSerie.setBackground(new Color(88, 247, 205));
		bTerminarSerie.setForeground(new Color(0, 0, 0));
		bTerminarSerie.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		bTerminarSerie.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bTerminarSerie.setPreferredSize(new Dimension(220, 70));
		bReiniciar.setIcon(new ImageIcon(getClass().getResource("/imagenes/reiniciar.png")));
		bReiniciar.setText("Reiniciar");
		bReiniciar.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 22));
		bReiniciar.setBackground(new Color(88, 247, 205));
		bReiniciar.setForeground(new Color(0, 0, 0));
		bReiniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		bReiniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bReiniciar.setPreferredSize(new Dimension(160, 70));
		bEstadisticas.setIcon(new ImageIcon(getClass().getResource("/imagenes/estadisticas.png")));
		bEstadisticas.setText("Estadisticas");
		bEstadisticas.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 22));
		bEstadisticas.setBackground(new Color(88, 247, 205));
		bEstadisticas.setForeground(new Color(0, 0, 0));
		bEstadisticas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		bEstadisticas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bEstadisticas.setPreferredSize(new Dimension(200, 70));
		bSalir.setIcon(new ImageIcon(getClass().getResource("/imagenes/salir.png")));
		bSalir.setText("Salir");
		bSalir.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 22));
		bSalir.setBackground(new Color(88, 247, 205));
		bSalir.setForeground(new Color(0, 0, 0));
		bSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		bSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bSalir.setPreferredSize(new Dimension(100, 70));
		pInteraccionUsuario.add(tfEscrituraParaUsuario); pInteraccionUsuario.add(bTerminarSerie);
		pInteraccionUsuario.add(bReiniciar); pInteraccionUsuario.add(bEstadisticas); 
		pInteraccionUsuario.add(bSalir);
		pInteraccionUsuario.setPreferredSize(new Dimension(1020, 100));
		pInteraccionUsuario.setOpaque(false);
		pTextFieldButtons.add(pInteraccionUsuario);
		pTextFieldButtons.setOpaque(false);
		fondoGame.add(pTextFieldButtons, BorderLayout.SOUTH);
		
		
	}
	
	private void loginUsuario() {
		
		leerInformacionUsuario();
		
		//Respuesta del usuario.
		respuestaLogin = (String)JOptionPane.showInputDialog(null, "Digite su usuario", "L O G I N", 
													JOptionPane.INFORMATION_MESSAGE, 
													iLogeo,
													null, "");
		
		
		
		
		
	}
	
	private void leerInformacionUsuario() {
		
		
		
	}
	
	private void escribirInformacionUsuario() {
		
		
		
	}
	
	private void vaciarAreaDeTexto() {
		
		
		
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
	
	private class Escuchas extends KeyAdapter implements ActionListener{
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
		}
		
		
		
	}

}
