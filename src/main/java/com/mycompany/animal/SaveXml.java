/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

/**
 *
 * @author student
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class SaveXml {
    
    public void SaveFile(Model [] DataForm) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, IOException
    {
         DocumentBuilderFactory docXml = DocumentBuilderFactory.newInstance();
         docXml.setNamespaceAware(true);
         Document doc = (Document) docXml.newDocumentBuilder().newDocument();
         System.out.println("документ создан xml");
         
         
         Element root = doc.createElement("group");
         root.setAttribute("nameCat","kot");
         doc.appendChild(root);
         
         Element ID = doc.createElement("ID");
         root.appendChild(ID);
         System.out.println("работает: " +DataForm.length);
         
         for(int i=0; i<DataForm.length; i++)
         {   
             System.out.println("работает: " +DataForm.length);
             String textName = DataForm[i].getName();
             String textHozain = DataForm[i].getHozain();
             String textPoroda = DataForm[i].getPoroda();
             String textPol = DataForm[i].getPol();
             String textAge = ""+DataForm[i].getAge();
             
             Element cat = doc.createElement("cat");
             root.appendChild(cat);
             cat.setAttribute("ID","1");
             
             Element name = doc.createElement("name");
             Element hozain = doc.createElement("semeistvo");
             Element poroda = doc.createElement("poroda");
             Element pol = doc.createElement("pol");
             Element age = doc.createElement("age");
             
             name.setTextContent(textName);
             hozain.setTextContent(textHozain);
             poroda.setTextContent(textPoroda);
             pol.setTextContent(textPol);
             age.setTextContent(textAge);
             
             cat.appendChild(ID);
             cat.appendChild(name);
             cat.appendChild(hozain);
             cat.appendChild(poroda);
             cat.appendChild(pol);
             cat.appendChild(age);
         }
         File file = new File("test.xml");
         Transformer tr = TransformerFactory.newInstance().newTransformer();
         tr.setOutputProperty(OutputKeys.INDENT, "yes");
         tr.transform(new DOMSource(doc), new StreamResult(file));
    }
}
