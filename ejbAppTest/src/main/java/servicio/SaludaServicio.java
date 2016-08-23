/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 * Servicio para saludar a una persona.
 * 
 * @author fernando.ochoa
 */
@Stateless
@LocalBean
public class SaludaServicio {

	/**
	 * Servicio para saludar a una persona por el nombre.
	 * 
	 * @param nombre
	 *            nombre de la persona a saludar
	 * @return Cadena de saludo
	 */
	public String saludaPersonaNombre(String nombre) {
		return "Hola " + nombre;
	}

}
