package ir.kuroshfarsimadan.demo07.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ir.kuroshfarsimadan.demo07.bean.Person;

public class PersonDAO {

	public List<Person> retrieveAll() {

		ArrayList<Person> persons = new ArrayList<Person>();

		Connection yhteys = null;

		try {
			// Opening the connection and conducting the search
			// Driver load
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
			// Opening the connection
			yhteys = DriverManager.getConnection(DBConnectionProperties.getInstance().getProperty("url"),
					DBConnectionProperties.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance().getProperty("password"));

			// Conducting the search
			String sql = "select id, etunimi, sukunimi from henkilo";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);

			// Go through the search results
			while (tulokset.next()) {
				int id = tulokset.getInt("id");
				String etunimi = tulokset.getString("etunimi");
				String sukunimi = tulokset.getString("sukunimi");

				// Adding the person to a list
				Person h = new Person(id, etunimi, sukunimi);
				persons.add(h);
			}
		} catch (IOException e) {
			System.out.println("Database connection config retrieval caused an error.");
			e.printStackTrace();
		} catch (Exception e) {
			// A database error has occured
			System.out.println("Database search resulted in an error.");
			e.printStackTrace();
		} finally {
			// Always close the database connection
			try {
				if (yhteys != null && !yhteys.isClosed())
					yhteys.close();
			} catch (Exception e) {
				System.out.println("Database connection refuses to close.");
				e.printStackTrace();
			}
		}

		System.out.println("Retrieved the person such as: " + persons.toString());
		return persons;
	}

}
