package clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

	private Connection connection;
	
	private static final String DB_NAME = "Departamente.db";
	private static final String C_ID_DEPARTAMENT = "idDepartament";
	private static final String T_DEPARTAMENTE = "Departamente";
	private static final String C_DENUMIRE_DEPARTAMENT = "denumireDepartament";
	private static final String C_NUMAR_ANGAJATI = "numarAngajati";

	private static final String T_ANGAJATI = "Angajati";
	private static final String C_ID_ANGAJAT = "idAngajat";
	private static final String C_NUME_ANGAJAT = "numeAngajat";
	private static final String C_PRENUME_ANGAJAT = "prenumeAngajat";
	private static final String C_SALARIU_ANGAJAT = "salariuAngajat";
	private static final String C_CNP_ANGAJAT = "cnpAngajat";
	private static final String C_FUNCTIE_ANGAJAT = "functieAngajat";

	private static final String CREATE_TABLE_DEPARTAMENTE = "CREATE TABLE " + T_DEPARTAMENTE + "( " + C_ID_DEPARTAMENT
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + C_DENUMIRE_DEPARTAMENT + " TEXT NOT NULL, " + C_NUMAR_ANGAJATI
			+ " INTEGER NOT NULL " + ");";

	private static final String DELETE_TABLE_DEPARTAMENTE = "DROP TABLE " + T_DEPARTAMENTE + ";";
	private static final String INSERT_DEPARTAMENT = "INSERT INTO " + T_DEPARTAMENTE + "(" + C_DENUMIRE_DEPARTAMENT
			+ "," + C_NUMAR_ANGAJATI + ")" + "values (?,?);";

	private static final String UPDATE_DEPARTAMENT = "UPDATE " + T_DEPARTAMENTE + " SET " + C_DENUMIRE_DEPARTAMENT
			+ "= ? " + "," + C_NUMAR_ANGAJATI + " = ? " + " WHERE " + C_ID_DEPARTAMENT + " = ? " + ";";

	private static final String DELETE_DEPARTAMENT = "DELETE FROM " + T_DEPARTAMENTE + " WHERE " + C_ID_DEPARTAMENT
			+ "= ?;";

	
	
	
	
	private static final String CREATE_TABLE_ANGAJATI = "CREATE TABLE " + T_ANGAJATI + "(" + C_ID_ANGAJAT
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + C_NUME_ANGAJAT + " TEXT NOT NULL, " + C_PRENUME_ANGAJAT
			+ " TEXT NOT NULL, " + C_SALARIU_ANGAJAT + " REAL NOT NULL, " + C_CNP_ANGAJAT + " TEXT NOT NULL, "
			+ C_FUNCTIE_ANGAJAT + " TEXT NOT NULL," + C_ID_DEPARTAMENT + " INTEGER NOT NULL, " + " FOREIGN KEY " + "("
			+ C_ID_DEPARTAMENT + ")" + " REFERENCES " + T_DEPARTAMENTE + "(" + C_ID_DEPARTAMENT + ")" + ");";

	private static final String DELETE_TABLE_ANGAJATI = "DROP TABLE " + T_ANGAJATI + ";";
	private static final String INSERT_ANGAJAT = "INSERT INTO " + T_ANGAJATI + "(" + C_NUME_ANGAJAT + ","
			+ C_PRENUME_ANGAJAT + "," + C_SALARIU_ANGAJAT + "," + C_CNP_ANGAJAT + "," + C_FUNCTIE_ANGAJAT + ","
			+ C_ID_DEPARTAMENT + ")" + " values (?,?,?,?,?,?);";
	private static final String DELETE_ANGAJAT = "DELETE FROM " + T_ANGAJATI + " WHERE " + C_NUME_ANGAJAT + "=?" + ";"; // delete
																														// where
																														// CNP
																														// si
																														// la
																														// update
																														// nu
																														// modifici
																														// cnp
	private static final String UPDATE_ANGAJAT = "UPDATE " + T_ANGAJATI + " SET " + C_NUME_ANGAJAT + "= ? " + ","
			+ C_PRENUME_ANGAJAT + "= ? " + "," + C_SALARIU_ANGAJAT + "= ? " + "," + C_FUNCTIE_ANGAJAT + "=?" + " WHERE "
			+ C_CNP_ANGAJAT + "= ?;";
	private static final String GET_DEPARTAMENTE = "SELECT * FROM " + T_DEPARTAMENTE + ";";
	private static final String GET_ANGAJATI = "SELECT * FROM " + T_ANGAJATI + " WHERE " + C_ID_DEPARTAMENT + "= ?"
			+ ";";
	private static final String DELETE_DEPARTAMENT_ANGAJATI = "DELETE FROM " + T_ANGAJATI + " WHERE " + C_ID_DEPARTAMENT
			+ " = ?" + ";";

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public DatabaseHelper(Connection connection) throws ClassNotFoundException, SQLException {
		super();
		this.connection = connection;
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("JDBC:sqlite:" + DB_NAME);
	}

	public DatabaseHelper() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager.getConnection("JDBC:sqlite:" + DB_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createDatabase() throws SQLException {
		System.out.println(CREATE_TABLE_ANGAJATI);
		System.out.println(CREATE_TABLE_DEPARTAMENTE);
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_DEPARTAMENTE);
		preparedStatement.executeUpdate();
		preparedStatement = connection.prepareStatement(CREATE_TABLE_ANGAJATI);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public void deleteDatabase() throws SQLException {
		System.out.println(DELETE_TABLE_ANGAJATI);
		System.out.println(DELETE_TABLE_DEPARTAMENTE);
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TABLE_ANGAJATI);
		preparedStatement.executeUpdate();
		preparedStatement = connection.prepareStatement(DELETE_TABLE_DEPARTAMENTE);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public void insertDepartament(Departament d) throws SQLException {
		System.out.println(INSERT_DEPARTAMENT);
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEPARTAMENT);
		preparedStatement.setString(1, d.getDenumireDepartament());
		preparedStatement.setInt(2, d.getNumarAngajati());
		preparedStatement.execute();
		preparedStatement.close();
	}

	public void deleteDepartament(int idDepartament) throws SQLException {
		System.out.println(DELETE_DEPARTAMENT_ANGAJATI);
		System.out.println(DELETE_DEPARTAMENT);
		PreparedStatement deleteAngajatiDepartament = connection.prepareStatement(DELETE_DEPARTAMENT_ANGAJATI);
		PreparedStatement deleteDepartamet = connection.prepareStatement(DELETE_DEPARTAMENT);
		deleteAngajatiDepartament.setInt(1, idDepartament);
		deleteAngajatiDepartament.execute();
		deleteAngajatiDepartament.close();
		deleteDepartamet.setInt(1, idDepartament);
		deleteDepartamet.execute();
		deleteDepartamet.close();
	}

	public void updateDepartament(int idDepartament, String numeDepartamentNou, int numarAngajatiNou)
			throws SQLException {
		System.out.println(UPDATE_DEPARTAMENT);
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTAMENT);
		preparedStatement.setString(1, numeDepartamentNou);
		preparedStatement.setInt(2, numarAngajatiNou);
		preparedStatement.setInt(3, idDepartament);
		preparedStatement.execute();
		preparedStatement.close();
	}

	public void insertAngajat(int idDepartament, Angajat a) throws SQLException {
		System.out.println(INSERT_ANGAJAT);
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ANGAJAT);
		preparedStatement.setString(1, a.getNumeAngajat());
		preparedStatement.setString(2, a.getPrenumeAngajat());
		preparedStatement.setFloat(3, (float) a.getSalariuAngajat());
		preparedStatement.setString(4, a.getCnpAngajat());
		preparedStatement.setString(5, a.getFunctieAngajat());
		preparedStatement.setInt(6, idDepartament);
		preparedStatement.execute();
		preparedStatement.close();
	}

	public void updateAngajat(String cnpAngajat, String numeNou, String prenumeNou, double salariuNou,
			String functieNou) throws SQLException {
		System.out.println(UPDATE_ANGAJAT);
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ANGAJAT);
		preparedStatement.setString(1, numeNou);
		preparedStatement.setString(2, prenumeNou);
		preparedStatement.setFloat(3, (float) salariuNou);
		preparedStatement.setString(4, functieNou);
		preparedStatement.setString(5, cnpAngajat);
		preparedStatement.execute();
		preparedStatement.close();
	}

	public void deleteAngajat(String numeAngajat) throws SQLException {
		System.out.println(DELETE_ANGAJAT);
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ANGAJAT);
		preparedStatement.setString(1, numeAngajat);
		preparedStatement.execute();
		preparedStatement.close();
	}

	public List<Departament> getDepartamente() throws SQLException {
		System.out.println(GET_DEPARTAMENTE);
		List<Departament> listaDepartamente = new ArrayList<Departament>();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_DEPARTAMENTE);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Departament temp = new Departament();
			int idDepartament = resultSet.getInt(1);
			String denumireDepartament = resultSet.getString(2);
			int numarAngajati = resultSet.getInt(3);
			;
			temp.setDenumireDepartament(denumireDepartament);
			temp.setIdDepartament(idDepartament);
			temp.setNumarAngajati(numarAngajati);
			listaDepartamente.add(temp);
		}
		resultSet.close();
		preparedStatement.close();
		return listaDepartamente;
	}

	public List<Angajat> getAngajati(int idDepartament) throws SQLException {
		System.out.println(GET_ANGAJATI);
		List<Angajat> listaAngajati = new ArrayList<Angajat>();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_ANGAJATI);
		preparedStatement.setInt(1, idDepartament);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Angajat temp = new Angajat();
			String numeAngajat = resultSet.getString(2);
			String prenumeAngajat = resultSet.getString(3);
			double salariuAngajat = (double) resultSet.getFloat(4);
			String cnpAngajat = resultSet.getString(5);
			String functieAngajat = resultSet.getString(6);
			int idDep = resultSet.getInt(7);
			temp.setNumeAngajat(numeAngajat);
			temp.setPrenumeAngajat(prenumeAngajat);
			temp.setSalariuAngajat(salariuAngajat);
			temp.setCnpAngajat(cnpAngajat);
			temp.setFunctieAngajat(functieAngajat);
			temp.setIdDepartament(idDep);
			listaAngajati.add(temp);
		}
		resultSet.close();
		preparedStatement.close();
		return listaAngajati;
	}
}