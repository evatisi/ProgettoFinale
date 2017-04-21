package it.overnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import it.overnet.models.Contact;
import it.overnet.utilities.DBUtilityConnection;

public class Crud {

	public static final Logger logger = Logger.getLogger(Logger.class.getName());

	public static boolean createTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resulSet = null;

		boolean check = false;
		String createTableSQL = "CREATE TABLE CONTACT "
				+ "(ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY NOT NULL , " + " NOME VARCHAR(255), "
				+ " COGNOME VARCHAR(255), " + " TEL VARCHAR(255), " +

				" MAIL VARCHAR(255), " + " CONSTRAINT CONTACT_PK PRIMARY KEY ( ID ))";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();

			// System.out.println(createTableSQL);

			statement.execute(createTableSQL);

			resulSet = statement.executeQuery(createTableSQL);

			if (resulSet.next()) {
				check = true;
			}

			logger.info("Tabella CONTACT creata con successo");

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

	public static boolean insertRecordIntoTable(Contact contatto) throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO CONTACT" + "(ID, nome, cognome, tel, mail) VALUES" + "(default,?,?,?,?)";

		boolean check = false;

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, contatto.getNome());
			preparedStatement.setString(2, contatto.getCognome());
			preparedStatement.setString(3, contatto.getTel());
			preparedStatement.setString(4, contatto.getMail());

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			check = true;

			logger.info("Record inserito nella tabella CONTACT!");

		} catch (SQLException e) {

			logger.warning("Errore nella query insert");

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

	public static boolean selectRecordIntoTable(Contact contatto) throws Exception {

		Connection dbConnection = null;
		Statement statement = null;
		String selectTableSQL = "SELECT nome, cognome FROM CONTACT WHERE nome= '" + contatto.getNome() + "' AND cognome ='" 
		+ contatto.getCognome() + "' AND tel ='" + contatto.getTel() + "' AND mail ='" + contatto.getMail()+ "'";
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

			logger.warning("Errore nella select");

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

	public static boolean deleteRecordIntoTable(Contact contatto) throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "DELETE FROM CONTACT " + " WHERE ID = ?" ;
		boolean check = false;

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, contatto.getId());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			check = true;

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
		return check;
	}

	public static boolean updateRecordIntoTable(Contact contatto) throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		boolean check = false;

		String insertTableSQL = "UPDATE CONTACT SET" + " NOME = ?, COGNOME = ?" + " WHERE ID = ?";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, contatto.getNome());
			preparedStatement.setString(2, contatto.getCognome());
			preparedStatement.setInt(3, contatto.getId());

			preparedStatement.setInt(2, 1);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			check = true;

			logger.info("Record aggiornato nella tabella CONTACT!");

		} catch (SQLException e) {

			logger.warning("Record non aggiornato nella tabella CONTACT");

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
}
