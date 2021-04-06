/*
 * Programación interactiva
 * Autor: Joshua Sebastian Chicame Muñoz -202074121
 * Mini Proyecto: Juego de Atento y Rapido
 */
package atentoRapido;

import java.util.Random;

import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class Cuadrado.
 */
public class Cuadrado 
{
	
	private int colorCuadrado;

	
	//métodos
	
	/**
	 * Instantiates a new cuadrado.
	 * Lo instancia con un número aleatorio del 0 al 15
	 */
	public Cuadrado()
	{
		Random aleatorio = new Random();
		colorCuadrado = aleatorio.nextInt(15);
	}
		
	
	/**
	 * Cambiar cuadrado.
	 */
	//cambia el color
	public void cambiarCuadrado() 
	{
		Random aleatorio = new Random();
		int nuevoColor = aleatorio.nextInt(15);
		
		while(colorCuadrado == nuevoColor)
		{
			aleatorio = new Random();
			nuevoColor = aleatorio.nextInt(15);
		}
		
		colorCuadrado = nuevoColor;
	}
	
	
	/**
	 * Gets the color cuadrado.
	 *
	 * @return the color cuadrado
	 */
	//retorna color
	public int getColorCuadrado() {
		return colorCuadrado;
	}


	/**
	 * Sets the color cuadrado.
	 *
	 * @param colorCuadrado the new color cuadrado
	 */
	//cambia color
	public void setColorCuadrado(int colorCuadrado) {
		this.colorCuadrado = colorCuadrado;
	}


}
