/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;


import business.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import data.DBUtil;
import java.time.LocalDateTime;
import java.util.List;


public class UserDB {
        
    public static void insert(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(user);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public static void update(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.merge(user);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public static List<User> UserByDate (User user, LocalDateTime month) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.registerDate BETWEEN :start AND :end ORDER BY u.registered", User.class);
        q.setParameter("start", LocalDateTime.of(month.getYear(), month.getMonth(), 1, 0, 0));
        q.setParameter("end", LocalDateTime.of(month.getYear(), month.getMonth(), 31, 23, 59, 59, 999));
        try {
            List<User> list = q.getResultList();
            if(list == null || list.isEmpty()) {
                return null;
            } else {
                return list;
            }
        } finally {
            em.close();
        }
    }
    
}
