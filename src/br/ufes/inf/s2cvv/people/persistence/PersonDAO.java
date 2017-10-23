package br.ufes.inf.s2cvv.people.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.s2cvv.people.domain.Person;

@Local
public interface PersonDAO extends BaseDAO<Person> {
	
	Person retrieveByName(String name) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;
	
	Person retrieveByEmail(String email) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;

}
