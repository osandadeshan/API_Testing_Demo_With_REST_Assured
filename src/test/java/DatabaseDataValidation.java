import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import java.sql.SQLException;


/**
 * Created by Osanda on 7/12/2017.
 */


public class DatabaseDataValidation extends ConnectMySql {
	
	@Step("database validation <table>")
	public void responseContainsInAnyOrder(Table table) throws SQLException, ClassNotFoundException {
		executeStatements(table);
	}

	
}
