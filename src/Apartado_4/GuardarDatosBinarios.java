package Apartado_4;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import Apartado_2.ListaPaises;

public class GuardarDatosBinarios {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypesByWildcard(new String[] {"Apartado_2.*"});
        
        File xmlFile = new File("ListaPaises.xml");

        ListaPaises listaPaises = (ListaPaises) xstream.fromXML(xmlFile);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Paises.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(listaPaises.getPaises());
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

