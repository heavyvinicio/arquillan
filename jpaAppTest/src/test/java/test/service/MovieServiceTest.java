package test.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.dao.impl.DaoImpl;
import test.jpa.MovieDao;
import test.model.Movie;

@RunWith(Arquillian.class)
public class MovieServiceTest {

	@Inject
	private MovieService movieService;

	/**
	 * Genera el componente para enviar a deployar en el servidor de prueba.
	 * 
	 * @return {@link Archive}
	 */
	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(Movie.class).addClass(Movie.class).addClass(DaoImpl.class)
				.addClass(MovieDao.class).addClass(MovieService.class).addAsResource("META-INF/persistence.xml")
				.addAsResource("META-INF/create.sql").addAsResource("META-INF/drop.sql")
				.addAsResource("META-INF/load.sql").addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public final void testListMoviesforActorName() {
		List<Movie> movies1 = movieService.listMoviesforActorName("Shelley Duvall");
		List<Movie> movies2 = movieService.listMoviesforActorName("Jack Nicholson");
		List<Movie> movies3 = movieService.listMoviesforActorName("desire");
		List<Movie> movies4 = movieService.listMoviesforActorName("");
		assertEquals(2, movies1.size());
		assertEquals(2, movies2.size());
		assertTrue(movies3.isEmpty());
		assertTrue(movies4.isEmpty());
		System.out.println("Result for test: ");
		System.out.println("list1: " + movies1);
		System.out.println("list2: " + movies2);
		System.out.println("list3: " + movies3);
		System.out.println("list4: " + movies4);

	}

}
