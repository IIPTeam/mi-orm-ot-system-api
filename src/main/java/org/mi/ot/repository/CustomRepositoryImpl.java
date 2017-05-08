package org.mi.ot.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {
	
	private final EntityManager entityManager;
	
	public CustomRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	public void update(Object... item) {
		if (null != item) {
			for (Object entity : item) {
				entityManager.merge(entity);
			}
		}
		
	}

	public int executeUpdate(String hqlString, Map<String, Object> params) {
		Query query = entityManager.createQuery(hqlString);
		for (String name : params.keySet()) {
			query.setParameter(name, params.get(name));
		}
		return query.executeUpdate();
	}

	public int executeUpdate(String qlString, List<Object> values) {
		Query query = entityManager.createQuery(qlString);
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + 1, values.get(i));
		}
		return query.executeUpdate();
	}
}
