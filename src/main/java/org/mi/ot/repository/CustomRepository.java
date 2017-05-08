package org.mi.ot.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>{
	/**
	 * Update object
	 * @param item
	 */
	public void update(Object... item);

	/**
	 * Execute HQL statement
	 * @param hqlString base on Standard JPA statement
	 * @param params Key represents the name of the parameter variable in HQL, which means the value of the parameter variable in value
	 * @return Affected number
	 */
	public int executeUpdate(String hqlString, Map<String, Object> params);
	
	/**
	 * Execute HQL statement
	 * @param hqlString base on Standard JPA statement
	 * @param values parameter values
	 * @return Affected number
	 */
	public int executeUpdate(String qlString, List<Object> values);

}
