/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdilemas;

import Pantallas.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author LI1
 */
public class ElementosDilemas {
    public String[] Elementos(int NumDil){
        // TODO code application logic here
        //String a1 = null,a2 = null,a3 = null,id = null;
        String[] arreglo = new String[3];
                try {
            File archivo = new File("Dilemas.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            NodeList listaDilemas = document.getElementsByTagName("Dilema");
            for (int temp = 0; temp < NumDil; temp++) {
                Node nodo = listaDilemas.item(temp);
                    Element element = (Element) nodo;
                    arreglo[0]=element.getElementsByTagName("parte1").item(0).getTextContent();
                    arreglo[1]=element.getElementsByTagName("parte2").item(0).getTextContent();
                    arreglo[2]=element.getElementsByTagName("parte3").item(0).getTextContent();      
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arreglo;
    }

}
