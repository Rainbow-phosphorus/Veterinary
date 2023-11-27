/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.animal;

/**
 *
 * @author student
 */

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
public class Animal {
    
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
     
     Model m = new Model();
     Controler c = new Controler();
     View v = new View();
     v.fg(c.DataForm());
    }
     public void fg() throws IOException,ParserConfigurationException, TransformerException
     {
          Controler c = new Controler();
          SaveXml s = new SaveXml();
          s.SaveFile(c.DataForm());
     }



}
