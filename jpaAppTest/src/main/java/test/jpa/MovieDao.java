package test.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import test.dao.impl.DaoImpl;
import test.model.Movie;

/**
 * Dao for {@link Movie} entity.
 * 
 * @author fernando.ochoa
 *
 */
@Stateless
@LocalBean
public class MovieDao extends DaoImpl<Movie> {

	/**
	 * Service for list all Movies.
	 * 
	 * @return all {@link Movie}
	 */
	public List<Movie> listAllMovies() {
		return listObjectByNamedQuery(Movie.SQL_LIST_ALL_MOVIES, null);
	}
}
