package it.overnet.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilityConnection {
	public static Connection getDBConnection() throws Exception {

		Connection dbConnection = null;

		try {

			Class.forName(Constant.DB_DRIVER);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		try {

			dbConnection = DriverManager.getConnection(Constant.DB_CONNECTION, Constant.DB_USERNAME,
					Constant.DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
