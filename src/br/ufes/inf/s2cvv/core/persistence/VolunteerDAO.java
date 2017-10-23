package br.ufes.inf.s2cvv.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.s2cvv.core.domain.Volunteer;

/**
 * TODO: document this type.
 *
 * @author Vítor E. Silva Souza (vitorsouza@gmail.com)
 * @version 1.0
 */
@Local
public interface VolunteerDAO extends BaseDAO<Volunteer> {
	/**
	 * TODO: document this method.
	 * 
	 * @param name
	 * @return
	 * @throws PersistentObjectNotFoundException
	 * @throws MultiplePersistentObjectsFoundException
	 */

}
