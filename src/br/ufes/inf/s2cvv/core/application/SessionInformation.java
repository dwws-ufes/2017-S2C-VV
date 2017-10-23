package br.ufes.inf.s2cvv.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import br.ufes.inf.s2cvv.core.exceptions.LoginFailedException;
import br.ufes.inf.s2cvv.people.domain.Person;

@Local
public interface SessionInformation extends Serializable {

	Person getCurrentUser();
	
	void login(String username, String password) throws LoginFailedException;
	
}
