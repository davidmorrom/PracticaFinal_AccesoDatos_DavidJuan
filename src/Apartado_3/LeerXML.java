package Apartado_3;

import java.io.File;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import Apartado_2.ListaPaises;
import Apartado_2.Pais;

public class LeerXML {
	public static void main(String[] args) {
		XStream xstream = new XStream();
		xstream.addPermission(NoTypePermission.NONE);
		xstream.addPermission(NullPermission.NULL);
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		xstream.allowTypesByWildcard(new String[] {"Apartado_2.*"});
		
		File xmlFile = new File("ListaPaises.xml");

		ListaPaises listaPaises = (ListaPaises) xstream.fromXML(xmlFile);

		for (int i = 0; i < listaPaises.size(); i++) {
			Pais pais = listaPaises.get(i);
			System.out.println("Nombre: " + pais.getNombre());
			System.out.println("Presidente: " + pais.getPresidente());
			System.out.println("PIB: " + pais.getPib());
			System.out.println("Gini: " + pais.getGini());
			System.out.println("-------------------");
		}
	}
}