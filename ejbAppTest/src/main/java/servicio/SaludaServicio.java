/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author fernando.ochoa
 */
@Stateless
@LocalBean
public class SaludaServicio {

	public String saludaPersonaNOmbre(String nombre) {
		return "Hola " + nombre;
	}

}
