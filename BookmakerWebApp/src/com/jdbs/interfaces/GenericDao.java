package com.jdbs.interfaces;

import java.util.List;

public interface GenericDao<Type, PK> {
	public boolean insert(Type object);
	public void update(Type object);
	public void delete(Type object);

	public List<Type> getAll();	
	public Type getByKey(PK object);
}
