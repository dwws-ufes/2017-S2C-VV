package br.ufes.inf.s2cvv.core.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import br.ufes.inf.s2cvv.event.domain.Event;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-12-29T11:48:20.500-0200")
@StaticMetamodel(Community.class)
public class Community_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Community, String> name;
	public static volatile SingularAttribute<Community, String> telephone;
	public static volatile SingularAttribute<Community, String> address;
	public static volatile SingularAttribute<Community, String> city;
	public static volatile SingularAttribute<Community, String> state;
	public static volatile SingularAttribute<Community, String> wiki;
	public static volatile SingularAttribute<Community, String> map;
	public static volatile SingularAttribute<Community, Date> creationDate;
	public static volatile SingularAttribute<Community, Date> loginDate;
	public static volatile SingularAttribute<Community, Date> updateDate;
	public static volatile SetAttribute<Community, Event> communityEvents;
}
