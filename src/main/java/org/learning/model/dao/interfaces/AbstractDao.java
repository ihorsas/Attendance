package org.learning.model.dao.interfaces;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.learning.model.util.HibernateSessionFactoryUtil;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, Id extends Serializable> implements InterfaceDao<T, Id> {
  private Class<T> typeClass;

  protected Session currentSession;
  protected Transaction currentTransaction;

  public final void setClasses(final Class<T> typeClass) {
    this.typeClass = typeClass;
  }

  public void persist(T entity) {
    openCurrentSessionWithTransaction().save(entity);
    this.closeCurrentSessionWithTransaction();
  }

  public T findById(Id id) {
    T obj = openCurrentSession().get(typeClass, id);
    this.closeCurrentSession();
    return obj;
  }

  public void remove(T entity) {
    openCurrentSessionWithTransaction().remove(entity);
    this.closeCurrentSessionWithTransaction();
  }

  public List<T> findAll() {
    List<T> objs = openCurrentSession()
        .createQuery("from " + typeClass.getName(), typeClass)
        .list();
    this.closeCurrentSession();
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
