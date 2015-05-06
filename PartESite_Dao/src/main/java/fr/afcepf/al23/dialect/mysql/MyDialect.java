package fr.afcepf.al23.dialect.mysql;
import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;
public class MyDialect extends MySQLDialect{
	public MyDialect() {  
		registerFunction("date_add_month", new SQLFunctionTemplate(StandardBasicTypes.DATE, " DATE_ADD(?1, INTERVAL +30 DAY) "));
		registerFunction("now()", new SQLFunctionTemplate(StandardBasicTypes.DATE, "NOW()"));
	}
}