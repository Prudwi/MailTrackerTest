package Helper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Simple Java Program to connect MYSQL database by using Oracle JDBC thin
 * driver Make sure you have Oracle JDBC thin driver in your classpath before
 * running this program
 * 
 * @author
 */
public class DBUtil {

	private static ResultSet result = null;
	private static Connection connection = null;
	private static PreparedStatement preStatement = null;
	private static DBUtil myObj;

	final static Logger logger = Logger.getLogger(DBUtil.class);

	private DBUtil() {

	}

	/* Static 'instance' method */
	public static DBUtil getDbInstance() {
		if (myObj == null) {
			myObj = new DBUtil();
		}

		return myObj;
	}

	/***
	 * This function us used to query DB for fetching Data Points
	 * 
	 * @return
	 * @throws SQLException
	 * @author V531146
	 */
	public Connection connectDelphiQeDb() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			logger.debug("The DB URL is " + FileReader.getPropValuesFromFile("DB_URL"));
			logger.info("DB URL is " + FileReader.getPropValuesFromFile("DB_URL"));
			connection = DriverManager.getConnection(FileReader.getPropValuesFromFile("DB_URL"),
					FileReader.getPropValuesFromFile("DB_USER_ID"),
					(FileReader.getPropValuesFromFile("DB_PASSWORD")));
//					PasswordEncrypt.decrypt(FileReader.getPropValuesFromFile("DB_PASSWORD")));

			// creating connection to Oracle database using JDBC

			// If connection is success run the Sql
			if (connection != null) {
				logger.info("Connecting to MYSQL Successful");

			} else {
				logger.error("Failed to make mysql connection!");

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("Where is your JDBC Driver?");

		} catch (Exception e) {
			logger.error("Connection Failed! Check output console");

		}

		return connection;

	}
	
	
	
	/***
	 * This function is used to query DB for connecting Engineering DB
	 * 
	 * @return
	 * @throws SQLException
	 * @author V531146
	 */
	public Connection connectEngineeringQeDb() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			logger.debug("Connecting to Engineering DB is " + FileReader.getPropValuesFromFile("ENGINEERING_DB_URL"));
			logger.info("DB URL is " + FileReader.getPropValuesFromFile("ENGINEERING_DB_URL"));
			connection = DriverManager.getConnection(FileReader.getPropValuesFromFile("ENGINEERING_DB_URL"),
					FileReader.getPropValuesFromFile("ENGINEERING_DB_USER_ID"),
					(FileReader.getPropValuesFromFile("ENGINEERING_DB_PASSWORD_ID")));
//					PasswordEncrypt.decrypt(FileReader.getPropValuesFromFile("ENGINEERING_DB_PASSWORD_ID")));

			// creating connection to Oracle database using JDBC

			// If connection is success run the Sql
			if (connection != null) {
				logger.info("Connecting to MYSQL Successful");

			} else {
				logger.error("Failed to make mysql connection!");

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("Where is your JDBC Driver?");

		} catch (Exception e) {
			logger.error("Connection Failed! Check output console");

		}

		return connection;

	}
	
	
	
	
	
	public ResultSet cvTransactions(String appId) throws SQLException {

		try {
			connection = getDbInstance().connectDelphiQeDb();
			logger.info("Entering cvTransactions");

			// creating connection to Oracle database using JDBC

			// If connection is success run the Sql
			if (connection != null) {
				logger.info("Checking for Test Cases to Run...");
				String sql = "select jiraTcId,testCaseName,env,testPickedUp,transactionId,module,userId,password,artifactLocation,jenkinsBuildNo,jenkinsJobName from delphi.cv_transactions WHERE testPickedUp is null and appId=? ORDER BY testPriority DESC ,env limit 1 for Update ";
				// creating PreparedStatement object to execute query
				preStatement = connection.prepareStatement(sql);
				preStatement.setString(1,appId);
				result = preStatement.executeQuery();
				return result;
			} else {
				logger.error("Failed to make mysql connection!");

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Not Able to get any Test Cases - cvTransactions for app "+appId);

		}

		return result;
	}
	
	
	
	

	
	}
