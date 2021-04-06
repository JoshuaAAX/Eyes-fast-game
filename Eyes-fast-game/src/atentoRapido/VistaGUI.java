/*
 * Programación interactiva
 * Autor: Joshua Sebastian Chicame Muñoz -202074121
 * Mini Proyecto: Juego de Atento y Rapido
 */
package atentoRapido;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import misComponentes.Titulos;



// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUI.
 */
public class VistaGUI extends JFrame
{
	
	private Timer timer;
	private Random random;
	private JPanel zonaJuego, zonaResultados;
	private ArrayList<JLabel> cuadros = new ArrayList<JLabel>();

	private JLabel vida, puntos;
	private JLabel cuadrado;
	private JTextField valorVida, valorPuntos;
	private JButton salir, iguales;
	private ImageIcon imagen;
	private Escucha escucha;
	private Titulos titulo;
	private ControlRapidoAtento controlRapidoAtento;
	private JFrame vistaGridBagLayout;

	
	/**
	 * Instantiates a new vista GUI.
	 */
	//methods
	public VistaGUI() 
	{
	    initGUI();
	
	    this.setUndecorated(true);
	    this.setBackground(new Color(34,34,34));
	    this.setTitle("Juego Craps");
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/**
	 * Inits the GUI.
	 */
	private void initGUI()
	{
		//set up window container - Layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints contraints = new GridBagConstraints();
		
		//create Control, Listener and supports classes
		escucha = new Escucha();
		controlRapidoAtento = new ControlRapidoAtento();
		vistaGridBagLayout=this;
		timer = new Timer(3000,escucha);
		random = new Random();
				
		//set up Graphic Components
		
		//title
		titulo = new Titulos("   Juego de Atento y Rapido", 30, new Color(56,57,59));
		titulo.addMouseListener(escucha);
		titulo.addMouseMotionListener(escucha);
		titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		contraints.gridx=0;
		contraints.gridy=0;	
		contraints.gridwidth=1;
		contraints.fill=GridBagConstraints.HORIZONTAL;
		
		add(titulo,contraints);
		
		//exit
		salir = new JButton();
		imagen = new ImageIcon("src/imagenes/salir.png");
        salir.setIcon(imagen);
        salir.setFocusable(false);
        salir.setBorderPainted(false);
        salir.setBackground(new Color(56,57,59));
		salir.addActionListener(escucha);
		contraints.gridx=1;
		contraints.gridy=0;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.NONE;
		
		add(salir, contraints);
		
		//game zone
		zonaJuego = new JPanel();
		zonaJuego.setBackground(new Color(39,38,36));
		zonaJuego.setPreferredSize(new Dimension(650,421));
		//zonaJuego.setBorder(new TitledBorder(""));
		zonaJuego.setLayout(new FlowLayout(FlowLayout.LEADING));

		for(int cualColor = 0; cualColor<controlRapidoAtento.listaCuadradosSize(); cualColor++)
        {
           
        imagen = new ImageIcon("src/imagenes/"+controlRapidoAtento.getPosCuadrados(cualColor).getColorCuadrado()+".png");
        cuadros.add(new JLabel(imagen));
        zonaJuego.add(cuadros.get(cualColor));
        }
		
		contraints.gridx=0;
		contraints.gridy=1;
		contraints.gridwidth=1;
		contraints.gridheight=2;
		contraints.fill=GridBagConstraints.NONE;
		contraints.anchor=GridBagConstraints.CENTER;
		
		add(zonaJuego, contraints);
		
		//results zone
		zonaResultados = new JPanel();
		zonaResultados.setLayout(new GridLayout(0,1));
		vida = new JLabel("Vida");
		vida.setHorizontalAlignment(JLabel.CENTER);
		puntos = new JLabel("Puntos");
		puntos.setHorizontalAlignment(JLabel.CENTER);
		valorVida = new JTextField();
		valorVida.setHorizontalAlignment(JLabel.CENTER);
		valorVida.setText(String.valueOf(controlRapidoAtento.getVida()));
		valorVida.setEditable(false);
		valorPuntos = new JTextField();
		valorPuntos.setHorizontalAlignment(JLabel.CENTER);
		valorPuntos.setEditable(false);
		valorPuntos.setText(String.valueOf(controlRapidoAtento.getPuntos()));
		zonaResultados.add(vida);
		zonaResultados.add(valorVida);
		zonaResultados.add(puntos);
		zonaResultados.add(valorPuntos);
		contraints.gridx=1;
		contraints.gridy=1;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.NONE;
		contraints.anchor=GridBagConstraints.CENTER;
				
		add(zonaResultados,contraints);
		
		//play button
		iguales = new JButton();
		imagen = new ImageIcon("src/imagenes/iguales.png");
        iguales.setIcon(imagen);
        iguales.setFocusable(false);
        iguales.setBorderPainted(false);
		iguales.addActionListener(escucha);
		iguales.setPreferredSize(new Dimension(67,72));
		contraints.gridx=1;
		contraints.gridy=2;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.NONE;
		
		add(iguales, contraints);
		
		timer.start();
	}
	
	
	/**
	 * Agregar J label.
	 * agreegar al arraylist de jlabels no más de 8 jlabels
	 */
	public void agregarJLabel()
	{
		if(cuadros.size()<8)
		{
			cuadros.add(new JLabel());
			zonaJuego.add(cuadros.get(cuadros.size()-1)); 
		}
	}
	
	/**
	 * Determinar perder.
	 * refresca el arraylist de JLabels y revisa si pierde en tal caso muestra una ventana de resultados
	 */
	public void determinarPerder()
	{
		//refresca el array
		for(int cualColor = 0; cualColor<controlRapidoAtento.listaCuadradosSize(); cualColor++)
		{
			imagen = new ImageIcon("src/imagenes/"+controlRapidoAtento.getPosCuadrados(cualColor).getColorCuadrado()+".png");
			cuadros.get(cualColor).setIcon(imagen);
        }
		
		//ventana emergente de resultados
		if(controlRapidoAtento.determinarVida())
		{
			int opcion = JOptionPane.showConfirmDialog(null, "Aciertos: "+ controlRapidoAtento.getAciertos()+"\n"+
                                                             "Numero de errores: "+3+"\n"+
                                                             "Puntuación: "+controlRapidoAtento.getPuntos()+"\n"+
                                                             "¿Quiere seguir jugando?",
                                                             "Resultados",
                                                             JOptionPane.YES_NO_OPTION, 
                                                             JOptionPane.QUESTION_MESSAGE);
						
		     if(opcion == 0) 
		     {
				System.gc();
				dispose();
				VistaGUI nuevaVista = new VistaGUI();
		     }else 
			 {
				System.exit(0);
			 }	
		     
		}
	}

	
 
	/**
	 * The Class Escucha.
	 */
	//events
	private class Escucha implements ActionListener , MouseListener, MouseMotionListener
	{
		
		/** The y. */
		private int x, y;
		
		/**
		 * Action performed.
		 *
		 * @param eventObject the event object
		 */
		public void actionPerformed(ActionEvent eventObject)
		{
			
			
			
			if(eventObject.getSource() == salir) 
			{
				System.exit(0);
			}
			
			if(eventObject.getSource() == timer)
			{
                //quita el borde azul
				cuadros.get(controlRapidoAtento.getPosicionArray()).setBorder(null);
				
				//si hay color repetido y no presiono el boton se le quita vida
				if(controlRapidoAtento.determinarColorRepetido())
				{
					controlRapidoAtento.setVida(controlRapidoAtento.getVida()-1);
					valorVida.setText(String.valueOf(controlRapidoAtento.getVida()));
					controlRapidoAtento.cambiarColoresAleatorio();
					
					determinarPerder();
				}
				
				
				if(!controlRapidoAtento.determinarVida())
				{
					controlRapidoAtento.cambiarColorAleatorio();
				}
					 
				 
				imagen = new ImageIcon("src/imagenes/"+controlRapidoAtento.getCuadradoCambiado().getColorCuadrado()+".png");
				cuadros.get(controlRapidoAtento.getPosicionArray()).setIcon(imagen);
				
				//agrega el borde azul
				cuadros.get(controlRapidoAtento.getPosicionArray()).setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4));
			}
				
				
				
			if(eventObject.getSource() == iguales) 
			{
				   //compruebas los eventos que hace el juego cuando presiona el boton
				    controlRapidoAtento.coloresIgualesBoton();
				 

					valorVida.setText(String.valueOf(controlRapidoAtento.getVida()));
					valorPuntos.setText(String.valueOf(controlRapidoAtento.getPuntos()));

					if(!controlRapidoAtento.determinarVida())
					{
						agregarJLabel();
					}


					determinarPerder();
					
					
			}	
		}

		/**
		 * Mouse dragged.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseDragged(MouseEvent eventMouseMotion) 
		{
			// TODO Auto-generated method stub
			setLocation(vistaGridBagLayout.getLocation().x+eventMouseMotion.getX()-x,
				        vistaGridBagLayout.getLocation().y+eventMouseMotion.getY()-y);
			
		}
		

		/**
		 * Mouse moved.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseMoved(MouseEvent eventMouseMotion) 
		{
			// TODO Auto-generated method stub
			
		}
		

		/**
		 * Mouse clicked.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseClicked(MouseEvent eventMouse) 
		{
			// TODO Auto-generated method stub
			
		}
		

		/**
		 * Mouse pressed.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mousePressed(MouseEvent eventMouse) 
		{
			// TODO Auto-generated method stub
			x = eventMouse.getX();
			y = eventMouse.getY();
			
		}
		

		/**
		 * Mouse released.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseReleased(MouseEvent eventMouse) 
		{
			// TODO Auto-generated method stub
			
		}
		

		/**
		 * Mouse entered.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseEntered(MouseEvent eventMouse) 
		{
			// TODO Auto-generated method stub
			
		}
		

		/**
		 * Mouse exited.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseExited(MouseEvent eventMouse) 
		{
			// TODO Auto-generated method stub
			
		}
	}

}
