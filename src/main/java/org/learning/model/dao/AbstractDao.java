package org.learning.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.learning.model.util.HibernateSessionFactoryUtil;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public abstract class AbstractDao<T, Id extends Serializable> {

  protected Session currentSession;
  protected Transaction currentTransaction;
  private Class<T> typeClass;

  public final void setClasses(final Class<T> typeClass) {
    this.typeClass = typeClass;
  }

  public T merge(T entity) {
    T obj = null;
    try {
      obj = openCurrentSessionWithTransaction().merge(entity);
    } finally {
      this.closeCurrentSessionWithTransaction();
    }
    return obj;
  }

  public T findById(Id id) {
    T obj = null;
    try {
      obj = openCurrentSession().get(typeClass, id);
    } finally {
      this.closeCurrentSession();
    }
    return obj;
  }

  public void remove(T entity) {
    try {
      openCurrentSessionWithTransaction().remove(entity);
    } finally {
      this.closeCurrentSessionWithTransaction();
    }
  }

  public List<T> findAll() {
    List<T> objs = Collections.emptyList();
    try {
      objs = openCurrentSession()
          .createQuery("from " + typeClass.getName(), typeClass)
          .list();
    } finally {
      this.closeCurrentSession();
    }
    return objs;
  }

  protected Session openCurrentSession() {
    currentSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    return currentSession;
  }

  protected Session openCurrentSessionWithTransaction() {
    this.openCurrentSession();
    currentTransaction = currentSession.beginTransaction();
    return currentSession;
  }

  protected void closeCurrentSession() {
    currentSession.close();
  }

  protected void closeCurrentSessionWithTransaction() {
    currentTransaction.commit();
    this.closeCurrentSession();
  }
}
