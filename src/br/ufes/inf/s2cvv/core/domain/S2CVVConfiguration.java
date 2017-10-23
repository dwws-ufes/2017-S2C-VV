package br.ufes.inf.s2cvv.core.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@Entity
public class S2CVVConfiguration extends PersistentObjectSupport {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Basic
	private String parishAcronym;
	
	public S2CVVConfiguration() {}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getParishAcronym() {
		return parishAcronym;
	}

	public void setParishAcronym(String parishAcronym) {
		this.parishAcronym = parishAcronym;
	}
}
