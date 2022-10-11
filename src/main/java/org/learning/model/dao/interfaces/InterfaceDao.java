package org.learning.model.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDao<T, Id extends Serializable> {

  void persist(T entity);

  T findById(Id id);

  void remove(T entity);

  List<T> findAll();

}