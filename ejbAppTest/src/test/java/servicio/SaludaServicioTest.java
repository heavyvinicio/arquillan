package servicio;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author fernando.ochoa
 *
 */
@RunWith(Arquillian.class)
public class SaludaServicioTest {

	@Inject
	private SaludaServicio saludaServicio;

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(SaludaServicio.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public final void testSaludaPersonaNOmbre() {
		String nombre = "PEDRO";
		String resultado = saludaServicio.saludaPersonaNOmbre(nombre);
		System.out.println("Resultado: " + resultado);
		assertEquals("Hola " + nombre, resultado);
	}

}
