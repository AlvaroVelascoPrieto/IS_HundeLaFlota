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
	private JPanel panelTamañoBarco;
	private JPanel panelDireccionBarco;
	private JRadioButton botonTamaño1;
	private JRadioButton botonTamaño2;
	private JRadioButton botonTamaño3;
	private JRadioButton botonTamaño4;
	private JRadioButton botonHorizantal;
	private JRadioButton botonVertical;
	ButtonGroup grupoTamaño = new ButtonGroup();
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
		setSize(755, 755);
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
		
		this.panelTamañoBarco = new JPanel();
		panelColocacionBarco.add(panelTamañoBarco);
		panelTamañoBarco.setLayout(new GridLayout(5,1,0,0));
		panelTamañoBarco.add(new JLabel("TAMAÑO"));
		panelTamañoBarco.add(getbotonTamaño1());
		panelTamañoBarco.add(getbotonTamaño2());
		panelTamañoBarco.add(getbotonTamaño3());
		panelTamañoBarco.add(getbotonTamaño4());
		grupoTamaño.add(botonTamaño1);
		grupoTamaño.add(botonTamaño2);
		grupoTamaño.add(botonTamaño3);
		grupoTamaño.add(botonTamaño4);
		
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
	
	private JRadioButton getbotonTamaño1() {
		if (botonTamaño1 == null) {
			botonTamaño1 = new JRadioButton("1");
		}
		return botonTamaño1;
	}
	
	private JRadioButton getbotonTamaño2() {
		if (botonTamaño2 == null) {
			botonTamaño2 = new JRadioButton("2");
		}
		return botonTamaño2;
	}
	
	private JRadioButton getbotonTamaño3() {
		if (botonTamaño3 == null) {
			botonTamaño3 = new JRadioButton("3");
		}
		return botonTamaño3;
	}
	
	private JRadioButton getbotonTamaño4() {
		if (botonTamaño4 == null) {
			botonTamaño4 = new JRadioButton("4");
		}
		return botonTamaño4;
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
