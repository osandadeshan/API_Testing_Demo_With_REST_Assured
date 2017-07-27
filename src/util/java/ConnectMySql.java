import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.testng.Assert;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Osanda on 7/18/2017.
 */


public class ConnectMySql {
    
    Boolean EXPECTED_RESULT = Boolean.TRUE;
    Boolean ACTUAL_RESULT;

    public Statement loadDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("MySQL driver has been loaded successfully");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
        System.out.println("MySQL database has been connected successfully");
        Statement statement = connection.createStatement();
        return statement;
    }
    
    public void compareListValues(ArrayList<String> list1, ArrayList<String> list2){
        int i;
        System.out.println(" | " + "FirstName" + " | " + "LastName" + " | ");
        Gauge.writeMessage(" | " + "FirstName" + " | " + "LastName" + " | ");
        System.out.println(" |-----------" + "|" + "----------" + "|");
        Gauge.writeMessage(" |-----------" + "|" + "----------" + "|");
        for (i=0; i< list1.size(); i++){
            System.out.println(" | " + list1.get(i) + "\t |\t" + list2.get(i) + "  | ");
            Gauge.writeMessage(" | " + list1.get(i) + "\t |\t" + list2.get(i) + "  | ");
            ACTUAL_RESULT = (list1.get(i).equals(list2.get(i)));
            Assert.assertTrue(EXPECTED_RESULT == ACTUAL_RESULT);
        }
    }
    
    public static boolean compareList(List list1, List list2){
        return list1.toString().contentEquals(list2.toString())?true:false;
    }
    
    public void executeStatements(Table table) throws SQLException, ClassNotFoundException {
        ArrayList<String> listForValuesInDatabase = new ArrayList<String>();
        ArrayList<String> listForValuesInSpecFile = new ArrayList<String>();
        Statement statement = loadDatabase();
        ResultSet resultSet = statement.executeQuery("select * from userinfo");
            System.out.println("Results retrieved from the database for the executed query: \n");
            Gauge.writeMessage("Results retrieved from the database for the executed query: \n");
            System.out.println(" | " + "FirstName" + " | " + "LastName" + " | ");
            Gauge.writeMessage(" | " + "FirstName" + " | " + "LastName" + " | ");
                while (resultSet.next()) {
                    listForValuesInDatabase.add(resultSet.getString("FirstName"));
                    listForValuesInDatabase.add(resultSet.getString("LastName"));
                    System.out.println(" | " + resultSet.getString("FirstName") + " | " + resultSet.getString("LastName") + " | ");
                    Gauge.writeMessage(" | " + resultSet.getString("FirstName") + " | " + resultSet.getString("LastName") + " | ");
                }
                    System.out.println("\n\nResults expected for the executed query: \n");
                    Gauge.writeMessage("\n\nResults expected for the executed query: \n");
                    System.out.println(" | " + "FirstName" + " | " + "LastName" + " | ");
                    Gauge.writeMessage(" | " + "FirstName" + " | " + "LastName" + " | ");
                        for (TableRow row : table.getTableRows()) {
                            listForValuesInSpecFile.add(row.getCell("FirstName"));
                            listForValuesInSpecFile.add(row.getCell("LastName"));
                            System.out.println(" | " + row.getCell("FirstName") + " | " + row.getCell("LastName") + " | ");
                            Gauge.writeMessage(" | " + row.getCell("FirstName") + " | " + row.getCell("LastName") + " | ");
                        }
                            //System.out.println("Output2 :: "+compareList(listForValuesInDatabase, listForValuesInSpecFile));
                            Assert.assertTrue(EXPECTED_RESULT == compareList(listForValuesInDatabase, listForValuesInSpecFile), "Results retrieved from the database for the executed query and the expected results are different.\n");
    }
    

}
