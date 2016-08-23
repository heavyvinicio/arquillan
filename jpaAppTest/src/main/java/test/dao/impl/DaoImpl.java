package test.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Generic Class for generic entities.
 * 
 * @author fernado.ochoa
 *
 * @param <T>
 *            generic parameter
 */
public class DaoImpl<T> {
	public static final String DEFAULT_PU = "myPU";

	@PersistenceContext(name = DaoImpl.DEFAULT_PU, unitName = DaoImpl.DEFAULT_PU)
	private EntityManager em;

	/**
	 * @param nameQuery
	 *            name of the nameQuery
	 * @param parameters
	 *            {@link Map} parameters
	 * @return {@link List} of {@link Entity}
	 */
	@SuppressWarnings("unchecked")
	public List<T> listObjectByNamedQuery(final String nameQuery, final Map<String, Object> parameters) {
		Query query = em.createNamedQuery(nameQuery);
		if (parameters == null || parameters.isEmpty()) {
			return query.getResultList();
		}
		for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
			query.setParameter(parameter.getKey(), parameter.getValue());
		}
		return query.getResultList();
	}
}
