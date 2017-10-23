package br.ufes.inf.s2cvv.event.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.s2cvv.event.domain.Event;

@Local
public interface EventDAO extends BaseDAO<Event>{

}
