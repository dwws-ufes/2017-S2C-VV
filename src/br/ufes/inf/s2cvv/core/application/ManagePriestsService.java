package br.ufes.inf.s2cvv.core.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.s2cvv.core.domain.Priest;

@Local
public interface ManagePriestsService extends CrudService<Priest> {

}
