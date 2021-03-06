/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author x15034593
 */
@Stateless
public class TransactionsFacade extends AbstractFacade<Transactions> {
    @PersistenceContext(unitName = "BankGaborPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionsFacade() {
        super(Transactions.class);
    }
    
}
