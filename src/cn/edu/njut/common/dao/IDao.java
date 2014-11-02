package cn.edu.njut.common.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao {
	public <T> boolean save(T model);
	public <T> boolean update(T model);
	public <T> boolean delete(T model);
	public <T,PK extends Serializable> Object get(Class<T> entityClass,PK id);
	public Object getOne(String hql);
	public List getByHql(String hql);
}
