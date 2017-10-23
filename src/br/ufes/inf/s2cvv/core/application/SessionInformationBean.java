package br.ufes.inf.s2cvv.core.application;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

import br.ufes.inf.s2cvv.core.exceptions.LoginFailedException;
import br.ufes.inf.s2cvv.people.domain.Person;
import br.ufes.inf.s2cvv.people.persistence.PersonDAO;

@SessionScoped
@Stateful
public class SessionInformationBean implements SessionInformation {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(SessionInformationBean.class.getCanonicalName());
	
	@EJB
	PersonDAO personDAO;
	
	@EJB
	Person currentUser;

	@Override
	public Person getCurrentUser() {
		// TODO Auto-generated method stub
		return currentUser;
	}

	@Override
	public void login(String username, String password) throws LoginFailedException {
		// TODO Auto-generated method stub
		
	}

}
