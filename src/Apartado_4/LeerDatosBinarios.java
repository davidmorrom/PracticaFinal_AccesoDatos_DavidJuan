package Apartado_4;
//Esta clase la he realizado unicamente para comprobar que la clase GuardarDatosBinarios funciona correctamente.
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import Apartado_2.Pais;

public class LeerDatosBinarios {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("Paises.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            List<Pais> listaPaises = (List<Pais>) objectInputStream.readObject();

            for (Pais pais : listaPaises) {
                System.out.println("Nombre: " + pais.getNombre());
                System.out.println("Presidente: " + pais.getPresidente());
                System.out.println("PIB: " + pais.getPib());
                System.out.println("Gini: " + pais.getGini());
                System.out.println("-------------------");
            }

            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
