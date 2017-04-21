package it.overnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.overnet.utilities.DBUtilityConnection;


public class Crud {
	
	public static boolean createTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resulSet = null;

		boolean check = false;
		String createTableSQL = "CREATE  TABLE CONTACT "
				+ "(ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY NOT NULL , " + " NOME VARCHAR(255), "+ " COGNOME VARCHAR(255), "+ " TEL VARCHAR(255), "+
				
			 " MAIL VARCHAR(255), " + " CONSTRAINT CONTACT_PK PRIMARY KEY ( id ))";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(createTableSQL);

			statement.execute(createTableSQL);
			
			resulSet = statement.executeQuery(createTableSQL);
			if (resulSet.next()) {
				check = true;
			}
			System.out.println("Tabella \"CONTACT\" creata con successo!");

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

	public static boolean insertRecordIntoTable(String nome, String cognome, String tel, String mail) throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO CONTACT" + "(ID, nome, cognome, tel, mail) VALUES" + "(default,?,?,?,?)";
		ResultSet resulSet = null;
		Statement statement = null;
		boolean check = false;
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			statement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			preparedStatement.setString(3, tel);
			preparedStatement.setString(4, mail);
			
			// execute insert SQL statement
			preparedStatement.executeUpdate();
			
			resulSet = statement.executeQuery(insertTableSQL);
			if (resulSet.next()) {
				check = true;
			}

			System.out.println("Record inserito nella tabella CONTACT!");

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

	public static boolean selectRecordIntoTable(String nome, String cognome, String tel, String mail) throws Exception {
		Connection dbConnection = null;
		Statement statement = null;
		String selectTableSQL = "SELECT nome, cognome FROM CONTACT WHERE nome= '" + nome
				+ "' AND cognome ='" + cognome + "' AND tel ='" + tel +"' AND mail ='" + mail +"'";
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
	
	public static void deleteRecordIntoTable() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "DELETE FROM CONTACT " + " WHERE ID = ?";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, 3);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record eliminato nella tabella CONTACT!");

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

	}
	
	public static void updateRecordIntoTable() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "UPDATE CONTACT SET" + " NOME = ?" + " WHERE ID = ?";
		//String insertTableSQL = "UPDATE CONTACT SET" + " ETA= ?" + " WHERE ID = ?";
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, "pippo");
//			preparedStatement.setString(2, "pallino");
//			preparedStatement.setInt(3, 44);

			preparedStatement.setInt(2, 1);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record aggiornato nella tabella CONTACT!");

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

	}
}
