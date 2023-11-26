package Apartado_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import Apartado_2.Pais;
import Apartado_5.DAO;

public class ModificarDatos {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:paises", "sa", "");

		DAO paisDAO = new DAO(connection);

		List<Pais> paisesBD = paisDAO.buscarTodos();

		for (Pais pais : paisesBD) {
			pais.setPib(pais.getPib() + 10000);

			if (pais.getNombre().equals("El Salvador") || pais.getNombre().equals("Honduras")
					|| pais.getNombre().equals("México")) {
				pais.setGini(pais.getGini() * 2 / 3);
			}

			paisDAO.modificar(pais);
		}

		paisesBD = paisDAO.buscarTodos();
		for (Pais pais : paisesBD) {
			System.out.println(pais.toString());
		}
        connection.commit();
        connection.close();
	}
}
