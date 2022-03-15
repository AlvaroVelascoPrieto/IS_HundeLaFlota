package packVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import packModelo.GestorJuego;

public class InterfazJuego extends JFrame implements Observer{

	private JPanel contentPanel;
	private JPanel panelTableros;
	private JPanel panelMiTableroTit;
	private JPanel panelMiTablero;
	private JPanel panelTableroContTit;
	private JPanel panelTableroCont;
	private JPanel panelAcciones;
	private JPanel panelColocacionBarco;
	private JPanel panelTamanoBarco;
	private JPanel panelDireccionBarco;
	private JRadioButton botonTamano1;
	private JRadioButton botonTamano2;
	private JRadioButton botonTamano3;
	private JRadioButton botonTamano4;
	private JRadioButton botonHorizantal;
	private JRadioButton botonVertical;
	ButtonGroup grupoTamano = new ButtonGroup();
	ButtonGroup grupoDireccion = new ButtonGroup();
	private JPanel panelTienda;
	

	
	
	public InterfazJuego() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicializar();
		setVisible(true);
		GestorJuego.getGestorJuego().addObserver(this);
	}

	
	//Inicializa los componentes de la ventana
	private void inicializar() {
		setSize(1080,1080);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		setTitle("Hundir la flota");
		contentPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		//Panel tableros NORTH
		this.panelTableros = new JPanel();
		contentPanel.add(panelTableros);
		panelTableros.setLayout(new GridLayout(1,2,5,0));
		
		
		panelMiTableroTit = new JPanel();
		panelTableros.add(panelMiTableroTit);
		panelMiTableroTit.setLayout(new BorderLayout(0, 0));
		panelMiTableroTit.add(new JLabel("Mis barcos"),BorderLayout.NORTH);
		panelMiTablero = new JPanel();
		panelMiTableroTit.add(panelMiTablero, BorderLayout.CENTER);
		panelMiTablero.setLayout(new GridLayout(10,10,0,0));
		
		panelTableroContTit = new JPanel();
		panelTableros.add(panelTableroContTit);
		panelTableroContTit.setLayout(new BorderLayout(0, 0));
		panelTableroContTit.add(new JLabel("Barcos del contrincante"),BorderLayout.NORTH);
		panelTableroCont = new JPanel();
		panelTableroContTit.add(panelTableroCont, BorderLayout.CENTER);
		panelTableroCont.setLayout(new GridLayout(10,10,0,0));
		
		crearTableros();
		
		//Panel acciones ABAJO
		this.panelAcciones = new JPanel();
		contentPanel.add(panelAcciones);
		panelAcciones.setLayout(new GridLayout(2,2,0,0));
		
		this.panelColocacionBarco= new JPanel();
		panelAcciones.add(panelColocacionBarco);
		panelColocacionBarco.setLayout(new GridLayout(1,2,0,0));
		
		this.panelTamanoBarco = new JPanel();
		panelColocacionBarco.add(panelTamanoBarco);
		panelTamanoBarco.setLayout(new GridLayout(5,1,0,0));
		panelTamanoBarco.add(new JLabel("TAMAnO"));
		panelTamanoBarco.add(getbotonTamano1());
		panelTamanoBarco.add(getbotonTamano2());
		panelTamanoBarco.add(getbotonTamano3());
		panelTamanoBarco.add(getbotonTamano4());
		grupoTamano.add(botonTamano1);
		grupoTamano.add(botonTamano2);
		grupoTamano.add(botonTamano3);
		grupoTamano.add(botonTamano4);
		
		this.panelDireccionBarco = new JPanel();
		panelColocacionBarco.add(panelDireccionBarco);
		panelDireccionBarco.setLayout(new GridLayout(3,1,0,0));
		panelDireccionBarco.add(new JLabel("DIRECCION"));
		panelDireccionBarco.add(getbotonHorizantal());
		panelDireccionBarco.add(getbotonVertical());
		grupoDireccion.add(botonHorizantal);
		grupoDireccion.add(botonVertical);
		
		
		this.panelTienda = new JPanel();
		panelAcciones.add(panelTienda);
		panelAcciones.add(new JButton("Hola"));
		
		
		//int i= Integer.parseInt(botonTamano3.getText());
		
		
		
		
	}	
	
	private void crearTableros() {
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10;j++) {
			JTextPane agua = new JTextPane();
			agua.setBackground(Color.BLUE);
			agua.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			panelMiTablero.add(agua);
			JTextPane agua2 = new JTextPane();
			agua2.setBackground(Color.BLUE);
			agua2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			panelTableroCont.add(agua2);
			}
		}
	}
	
	private JButton cbt() { //par�metros de entrada
		JButton btnNewButton = new JButton(); //texto del bot�n
		return btnNewButton;
	}
	
	

	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Boolean>> cTocadasIA = GestorJuego.getGestorJuego().getCasillasTocadasIA();
		ArrayList<ArrayList<Boolean>> barcosIA = GestorJuego.getGestorJuego().getBarcosIA();
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				if(cTocadasIA.get(i).get(j)) {
					if (barcosIA.get(i).get(j)) {
						//Pintar barco tocado
					}else {
						//Pintar bomba al agua
					}
				}
			}
		}
	}
	
	private JRadioButton getbotonTamano1() {
		if (botonTamano1 == null) {
			botonTamano1 = new JRadioButton("1");
		}
		return botonTamano1;
	}
	
	private JRadioButton getbotonTamano2() {
		if (botonTamano2 == null) {
			botonTamano2 = new JRadioButton("2");
		}
		return botonTamano2;
	}
	
	private JRadioButton getbotonTamano3() {
		if (botonTamano3 == null) {
			botonTamano3 = new JRadioButton("3");
		}
		return botonTamano3;
	}
	
	private JRadioButton getbotonTamano4() {
		if (botonTamano4 == null) {
			botonTamano4 = new JRadioButton("4");
		}
		return botonTamano4;
	}
	
	private JRadioButton getbotonHorizantal() {
		if (botonHorizantal == null) {
			botonHorizantal = new JRadioButton("HORIZONTAL");
		}
		return botonHorizantal;
	}
	
	private JRadioButton getbotonVertical() {
		if (botonVertical == null) {
			botonVertical = new JRadioButton("VERTICAL");
		}
		return botonVertical;
	}
	

	
	
	
	
}
