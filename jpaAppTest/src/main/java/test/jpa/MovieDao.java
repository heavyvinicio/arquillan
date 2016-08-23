package test.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import test.dao.impl.DaoImpl;
import test.model.Movie;

@Stateless
@LocalBean
public class MovieDao extends DaoImpl<Movie> {

	public List<Movie> listAllMovies() {
		return listObjectByNamedQuery(Movie.SQL_LIST_ALL_MOVIES, null);
	}
}
