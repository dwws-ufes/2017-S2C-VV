package br.ufes.inf.s2cvv.people.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-12-26T11:18:00.227-0200")
@StaticMetamodel(Person.class)
public class Person_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, Date> birthDate;
	public static volatile SingularAttribute<Person, String> telephone;
	public static volatile SingularAttribute<Person, String> email;
	public static volatile SingularAttribute<Person, String> password;
	public static volatile SingularAttribute<Person, Date> creationDate;
	public static volatile SingularAttribute<Person, Date> loginDate;
	public static volatile SingularAttribute<Person, Date> updateDate;
}
