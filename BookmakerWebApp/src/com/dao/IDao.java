package com.dao;

import java.sql.Connection;
import java.util.List;

public interface IDao<Type> {
	public void insert(Type name, Connection conn) throws Exception;
	public Type find(int id, Connection conn) throws Exception;
	public List<Type> select(Connection conn) throws Exception;
}
