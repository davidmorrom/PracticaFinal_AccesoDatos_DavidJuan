package Apartado_5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import Apartado_2.Pais;

public class DAO {

	private Connection connection;

	public DAO(Connection connection) {
		this.connection = connection;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(
					"CREATE TABLE paises (nombre VARCHAR(15) PRIMARY KEY, presidente VARCHAR(35), pib INT, gini DOUBLE)");
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("La tabla existe");
		}
	}

	public void insertar(Pais pais) throws SQLException {
		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO paises (nombre, presidente, pib, gini) VALUES (?, ?, ?, ?)");
		statement.setString(1, pais.getNombre());
		statement.setString(2, pais.getPresidente());
		statement.setInt(3, pais.getPib());
		statement.setDouble(4, pais.getGini());
		statement.executeUpdate();
	}

	public List<Pais> buscarTodos() throws SQLException {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM paises");
		ResultSet resultSet = statement.executeQuery();
		List<Pais> paises = new ArrayList<>();
		while (resultSet.next()) {
			paises.add(new Pais(resultSet.getString("nombre"), resultSet.getString("presidente"),
					resultSet.getInt("pib"), resultSet.getDouble("gini")));
		}
		return paises;
	}

	public void modificar(Pais pais) throws SQLException {
		PreparedStatement statement = connection
				.prepareStatement("UPDATE paises SET nombre=?, presidente=?, pib=?, gini=? WHERE nombre=?");
		statement.setString(1, pais.getNombre());
		statement.setString(2, pais.getPresidente());
		statement.setInt(3, pais.getPib());
		statement.setDouble(4, pais.getGini());
		statement.setString(5, pais.getNombre());
		statement.executeUpdate();
	}
}
