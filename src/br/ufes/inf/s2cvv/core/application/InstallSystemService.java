package br.ufes.inf.s2cvv.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import br.ufes.inf.nemo.marvin.core.exceptions.SystemInstallFailedException;
import br.ufes.inf.s2cvv.core.domain.S2CVVConfiguration;
import br.ufes.inf.s2cvv.people.domain.Person;

@Local
public interface InstallSystemService extends Serializable {
	
	void installSystem(S2CVVConfiguration config, Person admin) throws SystemInstallFailedException;

}
