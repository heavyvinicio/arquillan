package test.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: MOVIE_CRITERIA
 *
 */
@Entity
@Table(name = "MOVIE_CRITERIA")
@NamedQueries({ @NamedQuery(name = Movie.SQL_LIST_ALL_MOVIES, query = "SELECT o from Movie o") })
public class Movie implements Serializable {

	private static final long serialVersionUID = -3975927986169827744L;
	public static final String SQL_LIST_ALL_MOVIES = "Movie.listAllMovies";
	@Id
	@NotNull
	private Long id;

	@NotNull
	@Size(min = 1, max = 60, message = "Debe ingresar entre 1 y 60 caracteres al menos")
	private String name;

	@NotNull
	@Size(min = 1, max = 200, message = "Debe ingresar entre 1 y 60 caracteres al menos")
	private String actors;

	public Movie() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Movie movie = (Movie) o;

		return id.equals(movie.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return name;
	}
}
