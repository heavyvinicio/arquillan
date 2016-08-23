/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iess;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class SaludaServicio {

	public String saludaPersonaNOmbre(String nombre) {
		return "Hola " + nombre;
	}

}
