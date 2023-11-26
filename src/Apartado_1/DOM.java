package Apartado_1;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOM {
	public static void main(String[] args) throws Exception {
		String	[] paises= {"Belice","El Salvador","Guatemala","Hondura","Nicaragua","México","Panamá","Costa Rica"};
		String	[] presidente={"Froyla Tzalam","Nayib Bukele","Alejandro Giammattei","Xiomara Castro","Daniel Ortega","Andrés Manuel López Obrador","Laurentino Cortizo","Rodrigo Chaves"};
		int	[] pib={1987,74818,185473,85625,47770,2890685,128500,129950};
		Double	[] gini={53.3,38.8,48.3,48.2,46.2,45.4,50.9,47.2};

		DocumentBuilderFactory DBC = DocumentBuilderFactory.newInstance();
		DocumentBuilder DB = DBC.newDocumentBuilder();
		Document doc = DB.newDocument();
		Element ele = doc.createElement("paises");
		doc.appendChild(ele);
		
		for (int i = 0; i < paises.length; i++) {
			Element pais = doc.createElement("pais");
			ele.appendChild(pais);
			
			Element nombre = doc.createElement("nombre");
			nombre.setTextContent(paises[i]);
			pais.appendChild(nombre);
			
			Element presiEle = doc.createElement("presidente");
			presiEle.setTextContent(presidente[i]);
			pais.appendChild(presiEle);
			
			Element pibEle = doc.createElement("pib");
			pibEle.setTextContent(String.valueOf(pib[i]));
			pais.appendChild(pibEle);

			Element giniEle = doc.createElement("gini");
			giniEle.setTextContent(String.valueOf(gini[i]));
			pais.appendChild(giniEle);
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("Paises.xml"));
		transformer.transform(source, result);
	}
}
