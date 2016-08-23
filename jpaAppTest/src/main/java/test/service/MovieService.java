package test.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import test.jpa.MovieDao;
import test.model.Movie;

@Stateless
@LocalBean
public class MovieService {

	@EJB
	private MovieDao movieDao;

	public List<Movie> listMoviesforActorName(final String nameOfActor) {
		if (nameOfActor == null || nameOfActor.trim().isEmpty()) {
			return new ArrayList<>();
		}
		List<Movie> movies = movieDao.listAllMovies();
		List<Movie> listMoviesByActorName = new ArrayList<>();
		for (Movie movie : movies) {
			if (movie.getActors().contains(nameOfActor)) {
				listMoviesByActorName.add(movie);
			}
		}
		return listMoviesByActorName;
	}
}
