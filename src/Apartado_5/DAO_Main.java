package Apartado_5;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import Apartado_2.ListaPaises;
import Apartado_2.Pais;

public class DAO_Main {

    public static void main(String[] args) throws Exception {
        XStream xstream = new XStream();
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypesByWildcard(new String[] {"Apartado_2.*"});
        ListaPaises listaPaises = (ListaPaises) xstream.fromXML(new File("ListaPaises.xml"));

        try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:paises", "sa", "")) {
            DAO paisDAO = new DAO(connection);

            for (Pais pais : listaPaises.getPaises()) {
                paisDAO.insertar(pais);
            }

            List<Pais> paisesBD = paisDAO.buscarTodos();
            for (Pais pais : paisesBD) {
                System.out.println(pais.toString());
            }
            connection.commit();
            connection.close();
        }
    }
}
