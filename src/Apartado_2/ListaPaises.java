package Apartado_2;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class ListaPaises {

    private List<Pais> paises= new ArrayList<>();

    public void add(Pais pais) {
        paises.add(pais);
    }

    public Pais get(int index) {
        return paises.get(index);
    }

    public int size() {
        return paises.size();
    }
    
    public List<Pais> getPaises() {
        return paises;
    }
    public static void main(String[] args) throws Exception {
        ListaPaises listaPaises = new ListaPaises();
        listaPaises.add(new Pais("Belice", "Froyla Tzalam", 1987, 53.3));
        listaPaises.add(new Pais("El Salvador", "Nayib Bukele", 74818, 38.8));
        listaPaises.add(new Pais("Guatemala", "Alejandro Giammattei", 185473, 48.3));
        listaPaises.add(new Pais("Honduras", "Xiomara Castro", 85625, 48.2));
        listaPaises.add(new Pais("Nicaragua", "Daniel Ortega", 47770, 46.2));
        listaPaises.add(new Pais("México", "Andrés Manuel López Obrador", 2890685, 45.4));
        listaPaises.add(new Pais("Panamá", "Laurentino Cortizo", 128500, 50.9));
        listaPaises.add(new Pais("Costa Rica", "Rodrigo Chaves", 129950, 47.2));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XStream xstream = new XStream();
        xstream.toXML(listaPaises, byteArrayOutputStream);

        File file = new File("ListaPaises.xml");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.close();
    }
}
