package br.ufes.inf.s2cvv.people.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-23T09:34:54.356-0200")
@StaticMetamodel(Group.class)
public class Group_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Group, String> name;
	public static volatile SingularAttribute<Group, Date> date;
}
