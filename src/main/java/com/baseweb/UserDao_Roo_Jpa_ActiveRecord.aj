// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.baseweb;

import com.baseweb.UserDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect UserDao_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager UserDao.entityManager;
    
    public static final List<String> UserDao.fieldNames4OrderClauseFilter = java.util.Arrays.asList("user_id", "password");
    
    public static final EntityManager UserDao.entityManager() {
        EntityManager em = new UserDao().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long UserDao.countUserDaos() {
        return entityManager().createQuery("SELECT COUNT(o) FROM UserDao o", Long.class).getSingleResult();
    }
    
    public static List<UserDao> UserDao.findAllUserDaos() {
        return entityManager().createQuery("SELECT o FROM UserDao o", UserDao.class).getResultList();
    }
    
    public static List<UserDao> UserDao.findAllUserDaos(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM UserDao o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, UserDao.class).getResultList();
    }
    
    public static UserDao UserDao.findUserDao(Long id) {
        if (id == null) return null;
        return entityManager().find(UserDao.class, id);
    }
    
    public static List<UserDao> UserDao.findUserDaoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM UserDao o", UserDao.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<UserDao> UserDao.findUserDaoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM UserDao o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, UserDao.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void UserDao.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void UserDao.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            UserDao attached = UserDao.findUserDao(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void UserDao.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void UserDao.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public UserDao UserDao.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        UserDao merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
