package br.ufes.inf.s2cvv.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import br.ufes.inf.s2cvv.core.domain.Priest;
import br.ufes.inf.s2cvv.core.domain.S2CVVConfiguration;
import br.ufes.inf.s2cvv.core.exceptions.SystemInstallFailedException;

@Local
public interface InstallSystemService extends Serializable {
	
	void installSystem(S2CVVConfiguration config, Priest admin) throws SystemInstallFailedException;

}
