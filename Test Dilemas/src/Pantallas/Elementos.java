/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import testdilemas.VariablesGlobales;

/**
 *
 * @author LI1
 */
public class Elementos {
public int EncuentraUltimo(){
        // TODO code application logic here
        //String a1 = null,a2 = null,a3 = null,id = null;
       String a="";
       int numEntero=0;
                try {
            File archivo = new File("Dilemas.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            NodeList listaDilemas = document.getElementsByTagName("Dilema");
            for (int temp = 0; temp < listaDilemas.getLength(); temp++) {
                Node nodo = listaDilemas.item(temp);
                    Element element = (Element) nodo;
                    a=element.getAttribute("id");
                    //numEntero++;
            }
            
            numEntero = Integer.parseInt(a);
            numEntero++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numEntero;
    }
public void AnadirCaracteristica(String Arreglo[]) throws org.xml.sax.SAXException, TransformerConfigurationException, TransformerException{
   // File archivo = new File("Dilemas.xml");
    Document document = null;
    try {
        //Obtenemos el document del fichero XML existente
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(new File("Dilemas.xml"));
        document.getDocumentElement().normalize();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    		Element rootElement = document.getDocumentElement();
    //
    Element Dilema = document.createElement("Dilema");
    rootElement.appendChild(Dilema);
    // atributo del elemento Dilema
		Attr attr = document.createAttribute("id");
                int a=EncuentraUltimo();
                String ID=Integer.toString(a);
		attr.setValue(ID);
		Dilema.setAttributeNode(attr);
    //
    Element parte1 = document.createElement("parte1");
    parte1.appendChild(document.createTextNode(Arreglo[0]));
    Dilema.appendChild(parte1);

    //
    Element parte2 = document.createElement("parte2");
    parte2.appendChild(document.createTextNode(Arreglo[1]));
    Dilema.appendChild(parte2);

    
    Element parte3 = document.createElement("parte3");
    parte3.appendChild(document.createTextNode(Arreglo[2]));
        Dilema.appendChild(parte3);
   TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("Dilemas.xml"));

    //Guardamos la nueva estructura la fichero XML
    		transformer.transform(source, result);
 
		System.out.println("File saved!");
}


public void AnadirModificacion(String Arreglo[],int combo) throws org.xml.sax.SAXException, TransformerConfigurationException, TransformerException{
   // File archivo = new File("Dilemas.xml");
    Document document = null;
    try {
        //Obtenemos el document del fichero XML existente
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(new File("Dilemas.xml"));
        document.getDocumentElement().normalize();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    NodeList items = document.getElementsByTagName("Dilema");
    Element Dilema = document.createElement("Dilema");   
    
    Element rootElement = document.getDocumentElement();
    
    
    //
    //Element Dilema = document.createElement("Dilema");
    //rootElement.appendChild(Dilema);
    // atributo del elemento Dilema
    Attr attr = document.createAttribute("id");
    //int a=EncuentraUltimo();
    String ID=Integer.toString(combo);
    //Agregado por el chuy;
    for(int i = 0; i <items.getLength();i++){
        Element element = (Element) items.item(i);
        if(element.getAttribute("id").equals(ID)){
            element.getElementsByTagName("parte1").item(0).setTextContent(Arreglo[0]);
            element.getElementsByTagName("parte2").item(0).setTextContent(Arreglo[1]);
            element.getElementsByTagName("parte3").item(0).setTextContent(Arreglo[2]);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("Dilemas.xml"));

            //Guardamos la nueva estructura la fichero XML
            transformer.transform(source, result);
            System.out.println("File saved!");
            break;
        }
    }
    //
    /*
    attr.setValue(ID);
    Dilema.setAttributeNode(attr);
    //
    Element parte1 = document.createElement("parte1");
    parte1.appendChild(document.createTextNode(Arreglo[0]));
    Dilema.appendChild(parte1);

    //
    Element parte2 = document.createElement("parte2");
    parte2.appendChild(document.createTextNode(Arreglo[1]));
    Dilema.appendChild(parte2);

    
    Element parte3 = document.createElement("parte3");
    parte3.appendChild(document.createTextNode(Arreglo[2]));
    Dilema.appendChild(parte3);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(document);
    StreamResult result = new StreamResult(new File("Dilemas.xml"));

    //Guardamos la nueva estructura la fichero XML
    transformer.transform(source, result);
    System.out.println("File saved!");
    */
    
}
public void EliminarElemento(int idElemE){
    String idElemS = Integer.toString(idElemE);
    boolean bandera=true;
try {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document document = db.parse(new File("Dilemas.xml"));
    document.getDocumentElement().normalize();
    NodeList items = document.getElementsByTagName("Dilema");
    Element Dilema = document.createElement("Dilema");
    for (int i = 0; i < items.getLength(); i++) {
        Element element = (Element) items.item(i);
        if (element.getAttribute("id").equals(idElemS)&&bandera) {
            //System.out.println(element.getAttribute("id"));
            // borrar elemento
            element.getParentNode().removeChild(element);
            //Cada cambio se le hace un guardado a la estrucura xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("Dilemas.xml"));
            //Guardamos la nueva estructura la fichero XML
            transformer.transform(source, result);
            i=0;
            bandera=false;
        }
        // Reacomodo
        Attr attr = document.createAttribute("id");
        String ID;
        ID = Integer.toString(i+1);
        System.out.print(i+1);
        attr.setValue(ID);
	element.setAttributeNode(attr);
    }
    //Cada cambio se le hace un guardado a la estrucura xml
   TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("Dilemas.xml"));

    //Guardamos la nueva estructura la fichero XML
    		transformer.transform(source, result);
 
		System.out.println("File saved!");
           } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void OrdenarDilemas(){
        String idElemS = Integer.toString(1);
        System.out.println("Funcion OrdenarDilemas");
        int z = 1;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("Dilemas.xml"));
            document.getDocumentElement().normalize();
            NodeList items = document.getElementsByTagName("Dilema");
            Element Dilema = document.createElement("Dilema");
            for (int i = 0; i < items.getLength(); i++) {
                Element element = (Element) items.item(i);
                if (element.getAttribute("id").equals(idElemS )) {
                    System.out.println(element.getAttribute("id"));
                    // No modifica nada
                    String z1  = Integer.toString(z);
                    element.setAttribute("id", z1);
                    z = Integer.parseInt(z1);
                    z++;
                    idElemS = Integer.toString(z);
                }else{
                    //attr.setValue(ID);
                    String z1  = Integer.toString(z);
                    element.setAttribute("id", z1);
                    z = Integer.parseInt(z1);
                    z++;
                }                
            }
            //Cada cambio se le hace un guardado a la estrucura xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("Dilemas.xml"));

            //Guardamos la nueva estructura la fichero XML
            transformer.transform(source, result);
 
            System.out.println("File saved!");
        }catch (Exception e) {
                e.printStackTrace();
        }
        
    }
}
