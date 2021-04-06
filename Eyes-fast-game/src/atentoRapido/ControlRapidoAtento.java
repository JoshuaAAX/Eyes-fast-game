/*
 * Programación interactiva
 * Autor: Joshua Sebastian Chicame Muñoz -202074121
 * Mini Proyecto: Juego de Atento y Rapido
 */
package atentoRapido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlRapidoAtento.
 */
public class ControlRapidoAtento 
{
	//atributtes
	private ArrayList<Cuadrado> listaCuadrados;
	private Cuadrado cuadradoCambiado;
	private int vida, aciertos, puntos;
	int posicionArray;
	
	//methods
	
	/**
	 * Instantiates a new control rapido atento.
	 */
	//constructor
	public ControlRapidoAtento() 
	{
		listaCuadrados  = new ArrayList<Cuadrado>();
		
		for(int cualPosicion=0; cualPosicion<3; cualPosicion++)
		{
			listaCuadrados.add(new Cuadrado());
			listaCuadrados.get(cualPosicion).setColorCuadrado(cualPosicion);
		}
		
		cambiarColoresAleatorio();
		
		vida = 3;
		aciertos = 0;
	}
	
	
	/**
	 * Determinar vida.
	 *
	 * @return true, if successful
	 */
	//de acuerdo al estado de la vida retorna un booleano
	public boolean determinarVida() 
	{
		if(vida == 0)
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * Agregar cuadrado.
	 */
	//agregar cuadrado al arrayList pero no más de 8 cuadros al arraylist
	public void agregarCuadrado()
	{
		//listaCuadrados.add(new Cuadrado());
		if(listaCuadrados.size()<8)
		{
		cuadradoCambiado = new Cuadrado();
		listaCuadrados.add(cuadradoCambiado);
		}
		
	}
	
	
	/**
	 * Cambiar color aleatorio.
	 */
	//cambia un color aleatoriamente en una posición aleatoria
	public void cambiarColorAleatorio()
	{
		Random aleatorio = new Random();
		posicionArray = aleatorio.nextInt(listaCuadrados.size());
		cuadradoCambiado = new Cuadrado();
		listaCuadrados.set(posicionArray, cuadradoCambiado);
		
	}
	

	/**
	 * Cambiar colores.
	 * 
	 */
	//cambia aleatoriamente el array de cuadrados, los cuadros se pueden repetir
	public void cambiarColores()
	{
		Iterator<Cuadrado> recorrer = listaCuadrados.iterator();
		while(recorrer.hasNext())
		{
			  ((Cuadrado) recorrer.next()).cambiarCuadrado();
		}
	}
	

	//
	/**
	 * Cambiar colores aleatorio.
	 */
	//cambias aleatoriamente el array de cuadrados, los cuadros no se pueden repetir
	public void cambiarColoresAleatorio()
	{
		
		cambiarColores();
		for(int cual = 0; cual<listaCuadrados.size();cual++)
		{
			int confirmado = 0;
			int posicion = cual;
			
			for(int cualPosicion = 0; cualPosicion<listaCuadrados.size();cualPosicion++)
			{
				if(listaCuadrados.get(posicion).getColorCuadrado() == listaCuadrados.get(cualPosicion).getColorCuadrado())
				{
					if(posicion!=cualPosicion)
					{
						listaCuadrados.get(cualPosicion).cambiarCuadrado();
						confirmado = 1;
						break;
					}
				}
				
			}
			if(confirmado == 1)
			{
				cambiarColoresAleatorio();
				break;
			}
		}
			
	}	
	
	
	/**
	 * Determinar color repetido.
	 *
	 * @return true, if successful
	 */
	//determina si dos figuras son iguales y retorna un true i existen dos iguales
	public boolean determinarColorRepetido()
	{
	    for(int cual = 0; cual<listaCuadrados.size();cual++)
		{
			int posicion = cual;
			
			for(int cualPosicion = 0; cualPosicion<listaCuadrados.size();cualPosicion++)
			{
				if(listaCuadrados.get(posicion).getColorCuadrado() == listaCuadrados.get(cualPosicion).getColorCuadrado() && posicion!=cualPosicion)
				{
					return  true;
				}	
			}	
		}
		return false;	
	}	
	

	/**
	 * Colores iguales.
	 * si el boton esta presionado
	 */
	//es la funcion que controla el juego, agrega cuadros, puntos y resta vidas.
	public void coloresIgualesBoton()
	{
		if(determinarColorRepetido())
		{
			this.agregarCuadrado();
			this.cambiarColoresAleatorio();
			puntos = puntos +5;
			aciertos++;
		}else
		{
			vida--;
			this.cambiarColoresAleatorio();
		}
		
	}


	/**
	 * Gets the puntos.
	 *
	 * @return the puntos
	 */
	public int getPuntos() 
	{
		return puntos;
	}


	/**
	 * Gets the vida.
	 *
	 * @return the vida
	 */
	public int getVida() 
	{
		return vida;
	}
	
	/**
	 * Sets the vida.
	 *
	 * @param vida the new vida
	 */
	public void setVida(int vida) 
	{
		this.vida = vida;
	}


	/**
	 * Gets the aciertos.
	 *
	 * @return the aciertos
	 */
	public int getAciertos() 
	{
		return aciertos;
	}


	
	/**
	 * Gets the cuadrado cambiado.
	 *
	 * @return the cuadrado cambiado
	 */
	public Cuadrado getCuadradoCambiado() 
	{
		return cuadradoCambiado;
	}
	
	
	/**
	 * Gets the pos cuadrados.
	 *
	 * @param i the i
	 * @return the pos cuadrados
	 */
	public Cuadrado getPosCuadrados(int i) 
	{
		return listaCuadrados.get(i);
	}
	
	/**
	 * Gets the posicion array.
	 *
	 *
	 * @return the posicion array
	 */
	public int getPosicionArray() 
	{
		return posicionArray;
	}
	
	/**
	 * Lista cuadrados size.
	 * Retorna el tamaño del arraylist
	 * @return the int
	 */
	public int listaCuadradosSize()
	{
		return listaCuadrados.size();
	}	
}