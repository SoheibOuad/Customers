/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import fr.grin.tpcustomerapplicationouadfel.entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sol
 * Gère la persistance des Customers.
 */
   
@Stateless
@LocalBean 
public class CustomerManager {
    
    @PersistenceContext(unitName = "customerPU")  
    private EntityManager em;
 
    public void persist(Customer  customer) {  
      em.persist(customer);  
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }
    
    public Customer update(Customer customer) {
         return em.merge(customer);
    }   

    public Customer getCustomer(int idCustomer) {  
      return em.find(Customer.class, idCustomer);  
    }
}
