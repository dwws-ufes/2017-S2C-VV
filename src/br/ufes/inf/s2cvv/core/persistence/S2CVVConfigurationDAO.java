package br.ufes.inf.s2cvv.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.s2cvv.core.domain.S2CVVConfiguration;

@Local
public interface S2CVVConfigurationDAO extends BaseDAO<S2CVVConfiguration> {
	
	S2CVVConfiguration retrieveCurrentConfiguration() throws PersistentObjectNotFoundException;

}
