import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaClient {

	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(  
                //Option 1, retrieve the connection parameters from the hdbuserstore
                //The below URL gets the host, port and credentials from the hdbuserstore.
                "jdbc:sap://dummy_host:0/?KEY=USER1UserKey&encrypt=true&validateCertificate=false");

                

	}
	
	public List<String> track(String mail, String password, String id) throws SQLException {
		List<String> array = new ArrayList<String>();
		Connection connection = connect();
		if(checkMail(mail,getMail(connection))) {
			if(checkPassword(connection,mail,password)) {
				if(checkId(connection,mail,id)) {
					Statement stmt = connection.createStatement();
			        ResultSet resultSet = stmt.executeQuery("SELECT NAME from CB3FA97FDD7445319F8B2104883F46BC.APP_LETSTRACK_HISTORY JOIN CB3FA97FDD7445319F8B2104883F46BC.APP_LETSTRACK_CITY ON CB3FA97FDD7445319F8B2104883F46BC.APP_LETSTRACK_HISTORY.CITY = CB3FA97FDD7445319F8B2104883F46BC.APP_LETSTRACK_CITY.ID  WHERE ORDER_="+ id +";");
			        while (resultSet.next()) {
			            array.add(resultSet.getString("Name"));
			        }
				}
			}
		}
		return array;	
	}
	
	public boolean checkId(Connection connection, String mail, String id) throws SQLException {
		String result="";
		Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT CUSTOMER from CB3FA97FDD7445319F8B2104883F46BC.APP_LETSTRACK_ORDERS WHERE ID=" + id + ";");
        while (resultSet.next()) {
            result = resultSet.getString("Customer");
        }
        if(mail.equals(result)) {
        	return true;
        }
        return false;
	}
	
	public boolean checkPassword(Connection connection, String mail, String password) throws SQLException {
		String result="";
		Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT PASSWORD from CB3FA97FDD7445319F8B2104883F46BC.APP_LETSTRACK_CUSTOMER WHERE MAIL='" + mail + "';");
        while (resultSet.next()) {
            result = resultSet.getString("Password");
        }
        if(password.equals(result)) {
        	return true;
        }
        return false;
	}
	
	public boolean checkMail(String mail, List<String> array) {
		if(array.contains(mail)) return true;
		return false;
	}
	
	public List<String> getMail(Connection connection) throws SQLException {
		List<String> array = new ArrayList<String>();
		Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT MAIL from CB3FA97FDD7445319F8B2104883F46BC.APP_LETSTRACK_CUSTOMER;");
        while (resultSet.next()) {
            array.add(resultSet.getString("Mail"));
        }
        return array;
	}
	
}
