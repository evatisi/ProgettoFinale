package it.overnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import it.overnet.models.Contact;
import it.overnet.models.User;
import it.overnet.utilities.DBUtilityConnection;

public class UserDao {
	
	public static final Logger logger = Logger.getLogger(Logger.class.getName());
	
	public static boolean createTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;
		

		boolean check = false;
		String createTableSQL = "CREATE  TABLE USERTABLE" +"(ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY NOT NULL , "+
				"USERNAME VARCHAR(255) UNIQUE,"+ "PASSWORD VARCHAR(255), "+ "CONSTRAINT REGISTRATION_PK PRIMARY KEY ( id ))";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();


			statement.execute(createTableSQL);
			
			check = true;
			
			logger.info("Tabella USERTABLE creata con successo!");

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return check;
	}

	public static boolean insertRecordIntoTable(User utente) throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO USERTABLE" + "(ID, USERNAME, PASSWORD) VALUES" + "(default,?,?)";
		
		boolean check = false;
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			
			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getPassword());

			// execute insert SQL statement
			preparedStatement.executeUpdate();
			
			check = true;
			

			System.out.println("Record inserito nella tabella USERTABLE!");

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return check;
	}
	
	public static User findUserByUsernameAndPassword(User user) throws Exception {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectTableSQL = "SELECT * FROM USERTABLE WHERE USERNAME= ? AND PASSWORD = ?";
		ResultSet resulSet = null;		
		try {

			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			
			resulSet = preparedStatement.executeQuery();

			while (resulSet.next()) {

				user.setId(resulSet.getInt("ID"));
				user.setUsername(resulSet.getString("USERNAME"));
				user.setPassword(resulSet.getString("PASSWORD"));
				logger.info(user.toString());

			}

		} catch (SQLException e) {

			logger.warning("Errore nella select");
			e.printStackTrace();

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}

		return user;

	}
	
	public static boolean isUserExist(User utente) throws Exception {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectTableSQL = "SELECT * FROM USERTABLE WHERE USERNAME= ? AND PASSWORD= ?";
		boolean check = false;

		ResultSet resulSet = null;

		try {

			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL);
			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getPassword());
			
			resulSet = preparedStatement.executeQuery();

			while (resulSet.next()) {

				String username = resulSet.getString("USERNAME");
				String password = resulSet.getString("PASSWORD");
				
				if(utente.getUsername().equals(username) && utente.getPassword().equals(password)){
					check = true;
					
				}else {
					check = false;
				}
			}

		} catch (SQLException e) {

			logger.warning("Errore nella select");

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
		return check;
	}

	public static boolean selectRecordIntoTable(String username, String password) throws Exception {
		Connection dbConnection = null;
		Statement statement = null;
		String selectTableSQL = "SELECT USERNAME, PASSWORD FROM REGISTRATION WHERE USERNAME= '" + username
				+ "' AND PASSWORD ='" + password + "'";
		System.out.println(selectTableSQL);
		ResultSet resulSet = null;

		boolean check = false;

		try {

			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.prepareStatement(selectTableSQL);

			resulSet = statement.executeQuery(selectTableSQL);
			if (resulSet.next()) {
				check = true;
			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return check;

	}
	
	public static boolean isTableExist(String tableName){
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectTableSQL = "select table_name from user_tables where table_name=?";

		ResultSet resultSet = null;
		
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL);
			preparedStatement.setString(1, tableName);
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()){
				return false;
			} else {
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		

		
	}
}
