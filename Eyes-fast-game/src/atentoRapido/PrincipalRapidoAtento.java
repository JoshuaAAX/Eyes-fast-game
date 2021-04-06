/*
 * Programación interactiva
 * Autor: Joshua Sebastian Chicame Muñoz -202074121
 * Mini Proyecto: Juego de Atento y Rapido
 */
package atentoRapido;

import java.awt.EventQueue;


// TODO: Auto-generated Javadoc
/**
 * The Class PrincipalRapidoAtento.
 */
public class PrincipalRapidoAtento 
{
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) 
	{
	// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				VistaGUI myVista = new VistaGUI();
			}
		});	
	}
}