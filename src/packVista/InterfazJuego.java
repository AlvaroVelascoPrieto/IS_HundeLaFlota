package packVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import packControlador.Controler;
import packControlador.infoControler;
import packModelo.Barco;
import packModelo.Coordenada;
import packModelo.Flota;
import packModelo.GestorJuego;
import packModelo.IA;
import packModelo.Jugador;

public class InterfazJuego extends JFrame implements Observer{
	private ArrayList<JButton> labelsJugador = new ArrayList<JButton>();
	private ArrayList<JButton> labelsIA = new ArrayList<JButton>();
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
	private JPanel panelTienda;
	private JRadioButton botonTamano1;
	private JRadioButton botonTamano2;
	private JRadioButton botonTamano3;
	private JRadioButton botonTamano4;
	private JRadioButton botonHorizontal;
	private JRadioButton botonVertical;
	private ButtonGroup grupoTamano = new ButtonGroup();
	private ButtonGroup grupoDireccion = new ButtonGroup();
	private JPanel panelRadar;
	private JPanel panelArmas;
	private JPanel panelArmasAtaque;
	private JPanel panelArmasDefensa;
	private JRadioButton botonBomba;
	private JRadioButton botonMisil;
	private JRadioButton botonEscudo;
	private JRadioButton botonReparacion;
	private JButton moverRadar;
	private JButton consultarRadar;
	private JButton comprarMisil;
	private JButton comprarEscudo;
	private ButtonGroup grupoArmasAtaque = new ButtonGroup();
	private ButtonGroup grupoArmasDefensa = new ButtonGroup();
	//private JLabel tituloArmas;
	private JFrame popUp = new JFrame();
	
	

	
	
	public InterfazJuego() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicializar();
		setVisible(true);
		GestorJuego.getMiGestorJuego().addObserver(this);
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
		panelTamanoBarco.add(new JLabel("TAMANO"));
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
		panelDireccionBarco.add(getbotonHorizontal());
		panelDireccionBarco.add(getbotonVertical());
		grupoDireccion.add(botonHorizontal);
		grupoDireccion.add(botonVertical);
		
		this.panelArmas = new JPanel();
		panelAcciones.add(panelArmas);
		panelArmas.setLayout(new GridLayout(2,1));
		
		this.panelArmasAtaque = new JPanel();
		panelArmasAtaque.setLayout(new GridLayout(1,3));
		panelArmas.add(panelArmasAtaque);
		panelArmasAtaque.add(new JLabel("Armas de ataque"));
		panelArmasAtaque.add(getbotonBomba());
		panelArmasAtaque.add(getbotonMisil());
		grupoArmasAtaque.add(botonBomba);
		grupoArmasAtaque.add(botonMisil);
		
		
		this.panelArmasDefensa = new JPanel();
		panelArmasDefensa.setLayout(new GridLayout(1,3));
		panelArmas.add(panelArmasDefensa);
		panelArmasDefensa.add(new JLabel("Armas de defensa"));
		panelArmasDefensa.add(getbotonEscudo());
		panelArmasDefensa.add(getbotonReparacion());
		grupoArmasDefensa.add(botonEscudo);
		grupoArmasDefensa.add(botonReparacion);
		
		
		//this.cantBombas = new JLabel("30");
		//this.cantMisiles = new JLabel("30");
		//this.cantEscudos = new JLabel("0");
		//this.cantRadares = new JLabel("0");
		//panelCantidades = new JPanel();
		//panelCantidades.setLayout(new GridLayout(1,4));
		//panelArmas.add(panelCantidades);
		//panelCantidades.add(cantBombas);
		//panelCantidades.add(cantMisiles);
		//panelCantidades.add(cantEscudos);
		//panelCantidades.add(cantRadares);
		
		this.panelRadar = new JPanel();
		panelRadar.setLayout(new GridLayout(3,1));
		panelAcciones.add(panelRadar);
		this.moverRadar = new JButton("Mover Radar");
		this.consultarRadar = new JButton("Consultar Radar");		
		this.moverRadar.addActionListener(Controler.getMiControlador());
		this.consultarRadar.addActionListener(Controler.getMiControlador());
		Controler.getMiControlador().registrarMoverRadar(moverRadar);
		Controler.getMiControlador().registrarConsultarRadar(consultarRadar);
		panelRadar.add(new JLabel("GESTION RADAR"));
		panelRadar.add(moverRadar);
		panelRadar.add(consultarRadar);
		
		this.panelTienda = new JPanel();
		this.panelAcciones.add(panelTienda, 3);
		this.comprarMisil = new JButton("Comprar Misil");
		this.comprarEscudo = new JButton("Comprar Escudo");		
		this.comprarMisil.addActionListener(Controler.getMiControlador());
		this.comprarEscudo.addActionListener(Controler.getMiControlador());
		Controler.getMiControlador().registrarComprarMisil(comprarMisil);
		Controler.getMiControlador().registrarComprarEscudo(comprarEscudo);
	}	
	
	private void crearTableros() {
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10;j++) {
			JButton agua = new JButton();
			agua.setOpaque(true);
			agua.setBackground(Color.BLUE);
			agua.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			agua.addActionListener(Controler.getMiControlador());
			panelMiTablero.add(agua);
			labelsJugador.add(agua);
			Controler.getMiControlador().anadirBotonJugador(agua);
			JButton agua2 = new JButton();
			agua2.setOpaque(true);
			agua2.setBackground(Color.BLUE);
			agua2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			agua2.addActionListener(Controler.getMiControlador());
			panelTableroCont.add(agua2);
			labelsIA.add(agua2);
			Controler.getMiControlador().anadirBotonIA(agua2);
			}
		}
	}
	
	private JButton cbt() { //par�metros de entrada
		JButton btnNewButton = new JButton(); //texto del bot�n
		return btnNewButton;
	}
	
	public void update(Observable o, Object arg) {
		if(arg instanceof ArrayList<?>) {
			ArrayList<Barco> flotaJugador = (ArrayList<Barco>) ((ArrayList) arg).get(0);
			boolean completa = (Boolean) ((ArrayList) arg).get(1);
			ArrayList<Barco> flotaIA = (ArrayList<Barco>) ((ArrayList) arg).get(2);
			boolean jugadorHundida = (Boolean) ((ArrayList) arg).get(3);
			boolean iaHundida = (Boolean) ((ArrayList) arg).get(4);
			boolean radarActivo = (Boolean) ((ArrayList) arg).get(5);
			ArrayList<Coordenada> avistamientos = (ArrayList<Coordenada>) ((ArrayList) arg).get(6);
			int consultasRestantes = (Integer) ((ArrayList) arg).get(7);
			int numMisilesJugador = (Integer) ((ArrayList) arg).get(8);
			int numEscudosJugador = (Integer) ((ArrayList) arg).get(9);
			int numMisilesAlmacen = (Integer) ((ArrayList) arg).get(10);
			int numEscudosAlmacen = (Integer) ((ArrayList) arg).get(11);
			int dineroRestante = (Integer) ((ArrayList) arg).get(12);
			Coordenada posRadar = (Coordenada) ((ArrayList) arg).get(13);
			boolean cambioRadar = (Boolean) ((ArrayList) arg).get(14);
			Coordenada posAntRadar = (Coordenada) ((ArrayList) arg).get(15);
			for (Barco barcoAct : flotaJugador) {
				for (Coordenada coordAct : barcoAct.getCoordenadas()) {
					int index = coordAct.getX() + coordAct.getY()*10;
					labelsJugador.get(index).setBackground(Color.getHSBColor(28, 100, 61)); //Marron
					if (coordAct.getTocado()) {
						labelsJugador.get(index).setBackground(Color.RED);
					}
					else if(barcoAct.getEscudo()) {
						labelsJugador.get(index).setBackground(Color.ORANGE);
						if(barcoAct.getEscudoTocado()) {
							labelsJugador.get(index).setBackground(Color.DARK_GRAY);
						}
					}
				}
			}
			if (completa) {
				this.panelColocacionBarco.setVisible(false);
				this.panelColocacionBarco = new JPanel();
				this.panelColocacionBarco.setLayout(new GridLayout(2,4,0,0));
				this.panelColocacionBarco.add(new JLabel("Misiles"));
				this.panelColocacionBarco.add(new JLabel("Escudos"));
				this.panelColocacionBarco.add(new JLabel("Consultas"));
				this.panelColocacionBarco.add(new JLabel("Dinero"));
				this.panelColocacionBarco.add(new JLabel(Integer.toString(numMisilesJugador)));
				this.panelColocacionBarco.add(new JLabel(Integer.toString(numEscudosJugador)));
				this.panelColocacionBarco.add(new JLabel(Integer.toString(consultasRestantes)));
				this.panelColocacionBarco.add(new JLabel(Integer.toString(dineroRestante)));
				this.panelColocacionBarco.setVisible(true);
				this.panelAcciones.remove(0);
				this.panelAcciones.add(this.panelColocacionBarco, 0);
				
				this.panelTienda = new JPanel();
				this.panelTienda.setVisible(false);
				this.panelTienda.setLayout(new GridLayout(4,2,0,0));
				this.panelTienda.add(new JLabel("Almacen de la TIENDA"));
				this.panelTienda.add(new JLabel(" "));
				this.panelTienda.add(new JLabel("Misiles"));
				this.panelTienda.add(new JLabel("Escudos"));
				this.panelTienda.add(new JLabel(Integer.toString(numMisilesAlmacen)));
				this.panelTienda.add(new JLabel(Integer.toString(numEscudosAlmacen)));
				this.panelTienda.add(this.comprarMisil);
				this.panelTienda.add(this.comprarEscudo);
				this.panelTienda.setVisible(true);
				this.panelAcciones.remove(3);
				this.panelAcciones.add(this.panelTienda, 3);
				infoControler.getMiInfoControler().setCompleta(true);
			}
			if(!radarActivo) {
				int index = posRadar.getX() + posRadar.getY()*10;
				labelsIA.get(index).setBackground(Color.CYAN);
			}
			if(cambioRadar) {
				int index = posRadar.getX() + posRadar.getY()*10;
				labelsIA.get(index).setBackground(Color.CYAN);
				index = posAntRadar.getX() + posAntRadar.getY()*10;
				labelsIA.get(index).setBackground(Color.BLUE);
			}
			for (Barco barcoAct : flotaIA) {
				for (Coordenada coordAct : barcoAct.getCoordenadas()) {
					int index = coordAct.getX() + coordAct.getY()*10;
					if (coordAct.getTocado()) {
						labelsIA.get(index).setBackground(Color.GREEN);
					}
					else if(!coordAct.getTocado()&&coordAct.getEscudoTocado()) {
						labelsIA.get(index).setBackground(Color.DARK_GRAY);
					}else if(!coordAct.getTocado()&&coordAct.esCoordenada(posRadar)) {
						labelsIA.get(index).setBackground(Color.CYAN);
					}else {
						labelsIA.get(index).setBackground(Color.BLUE);
					}
				}
			}
			if(radarActivo) {
				int index = posRadar.getX() + posRadar.getY()*10;
				labelsIA.get(index).setBackground(Color.CYAN);
				for(Coordenada avistamiento : avistamientos) {
					index = avistamiento.getX() + avistamiento.getY()*10;
					labelsIA.get(index).setBackground(Color.RED);
				}
			}
			if (jugadorHundida) {
				JOptionPane.showMessageDialog(popUp, "GANA LA IA!!");
			}
			else if(iaHundida) {
				JOptionPane.showMessageDialog(popUp, "GANA EL JUGADOR!!");
			}
		}
	}
	
	public JRadioButton getbotonTamano1() {
		if (botonTamano1 == null) {
			botonTamano1 = new JRadioButton("1");
			botonTamano1.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonTamano1);
			botonTamano1.setSelected(true);
		}
		return botonTamano1;
	}
	
	public JRadioButton getbotonTamano2() {
		if (botonTamano2 == null) {
			botonTamano2 = new JRadioButton("2");
			botonTamano2.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonTamano2);
		}
		return botonTamano2;
	}
	
	public JRadioButton getbotonTamano3() {
		if (botonTamano3 == null) {
			botonTamano3 = new JRadioButton("3");
			botonTamano3.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonTamano3);
		}
		return botonTamano3;
	}
	
	public JRadioButton getbotonTamano4() {
		if (botonTamano4 == null) {
			botonTamano4 = new JRadioButton("4");
			botonTamano4.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonTamano4);
		}
		return botonTamano4;
	}
	
	public JRadioButton getbotonHorizontal() {
		if (botonHorizontal == null) {
			botonHorizontal = new JRadioButton("HORIZONTAL");
			botonHorizontal.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonHorizontal);
			botonHorizontal.setSelected(true);
		}
		return botonHorizontal;
	}
	
	public JRadioButton getbotonVertical() {
		if (botonVertical == null) {
			botonVertical = new JRadioButton("VERTICAL");
			botonVertical.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonVertical);
		}
		return botonVertical;
	}
	
	public JRadioButton getbotonBomba() {
		if (botonBomba == null) {
			botonBomba = new JRadioButton("Bomba");
			botonBomba.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonBomba);
			botonBomba.setSelected(true);
		}
		return botonBomba;
	}
	
	public JRadioButton getbotonMisil() {
		if (botonMisil == null) {
			botonMisil = new JRadioButton("Misil");
			botonMisil.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonMisil);
		}
		return botonMisil;
	}
	
	public JRadioButton getbotonEscudo() {
		if (botonEscudo == null) {
			botonEscudo = new JRadioButton("Escudo");
			botonEscudo.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonEscudo);
			botonEscudo.setSelected(true);
		}
		return botonEscudo;
	}
	
	public JRadioButton getbotonReparacion() {
		if (botonReparacion == null) {
			botonReparacion = new JRadioButton("Reparacion");
			botonReparacion.addActionListener(infoControler.getMiInfoControler());
			infoControler.getMiInfoControler().addRadiButton(botonReparacion);
		}
		return botonReparacion;
	}
}
