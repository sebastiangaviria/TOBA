/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import business.Account;
import business.Transaction;
import java.io.Serializable;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class AccountDB {
    
    public static void insert(Account account){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(account);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public static Account select(int id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a WHERE a.user = :id";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("id", id);
        Account account = null;
        try {
            account = q.getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println(e);
        }
        finally {
            em.close();
        }
        return account;
    }
    
    public static void update(Account account){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.merge(account);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public static List<Transaction> AllTransactions (Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Transaction> q = em.createQuery("SELECT t FROM Transaction t WHERE t.source = :account OR t.dest = :account", Transaction.class);
        q.setParameter("account", account);
        try {
            List<Transaction> transList = q.getResultList();
            if(transList == null || transList.isEmpty()) {
                return null;
            } else {
                return transList;
            }
        } finally {
            em.close();
        }
    }
}
