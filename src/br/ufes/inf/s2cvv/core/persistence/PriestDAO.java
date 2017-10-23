package br.ufes.inf.s2cvv.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
//import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
//import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.s2cvv.core.domain.Priest;

@Local
public interface PriestDAO extends BaseDAO<Priest> {
	/**
	 * TODO: document this method.
	 * 
	 * @param name
	 * @return
	 * @throws PersistentObjectNotFoundException
	 * @throws MultiplePersistentObjectsFoundException
	 */
//	Priest retrieveByName(String name) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;

}
