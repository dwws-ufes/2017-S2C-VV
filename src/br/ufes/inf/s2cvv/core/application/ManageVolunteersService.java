package br.ufes.inf.s2cvv.core.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.s2cvv.core.domain.Volunteer;

@Local
public interface ManageVolunteersService extends CrudService<Volunteer> {

}
