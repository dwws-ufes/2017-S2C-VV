package br.ufes.inf.s2cvv.people.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.s2cvv.people.domain.Person;
import br.ufes.inf.s2cvv.people.domain.Person_;

@Stateless
public class PersonJPADAO extends BaseJPADAO<Person> implements PersonDAO {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	private static final Logger logger = Logger.getLogger(PersonJPADAO.class.getCanonicalName());

	@Override
	public Person retrieveByName(String name)
			throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the person whose name is \"{0}\"...", name);
		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		Root<Person> root = cq.from(Person.class);
		
		// Filters the query with the email.
		cq.where(cb.equal(root.get(Person_.name), name));
		Person result = executeSingleResultQuery(cq, name);
		logger.log(Level.INFO, "Retrieve person by the name \"{0}\" returned \"{1}\"", new Object[] { name, result });
		return result;
	}

	@Override
	public Person retrieveByEmail(String email)
			throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the person whose email is \"{0}\"...", email);
		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		Root<Person> root = cq.from(Person.class);
		
		// Filters the query with the email.
		cq.where(cb.equal(root.get(Person_.email), email));
		Person result = executeSingleResultQuery(cq, email);
		logger.log(Level.INFO, "Retrieve person by the email \"{0}\" returned \"{1}\"", new Object[] { email, result });
		return result;
	}

}
