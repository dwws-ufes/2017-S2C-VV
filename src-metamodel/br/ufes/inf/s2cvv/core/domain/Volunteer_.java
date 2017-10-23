package br.ufes.inf.s2cvv.core.domain;

import br.ufes.inf.s2cvv.people.domain.Group;
import br.ufes.inf.s2cvv.people.domain.Person_;
import br.ufes.inf.s2cvv.people.domain.VolunteerFormation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-23T09:34:54.352-0200")
@StaticMetamodel(Volunteer.class)
public class Volunteer_ extends Person_ {
	public static volatile SingularAttribute<Volunteer, VolunteerFormation> formation;
	public static volatile SetAttribute<Volunteer, Group> participatesIn;
}
