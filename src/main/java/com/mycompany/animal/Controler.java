/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

/**
 * 
 * @author student
 */
import java.io.*;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
public class Controler {
    private Model [] data;
    private Model model;
    private View view;
    private int CountFile;
    private int count;
    private String text;
   

   

    public Model [] DataForm() throws IOException
    {
         System.out.println("Загруженно из файла"+ this.getCountFile());
         Model [] Spisok = new Model[this.getCountFile()];
         try(FileReader read = new FileReader("data.txt"))
         {
             Scanner scan = new Scanner(read);
             
             for (int i = 0; i<this.getCountFile(); i++)
             {
                 Model m = new Model();
                
                 String f = scan.nextLine();
                 System.out.println(f);
                 String v[] = f.split(";");
                  m.setName(v[0]);
                  m.setHozain(v[1]);
                  m.setPoroda(v[2]);
                  m.setPol(v[3]);
                  m.setId(v[4]);
                  m.setAge(Integer.parseInt(v[5]));
                  Spisok[i] = m;
                
             }
           
            read.close();
         }
         catch(IOException ex)
         {
             System.out.print(ex.getMessage());
         }
         return Spisok;
    }
    public String TextXML() 
    {
        String tXml = "";
        try(FileReader xmlRead = new FileReader("test.xml"))
        {
            Scanner scanXml = new Scanner(xmlRead);
            while (scanXml.hasNext())
            {
                tXml += (scanXml.nextLine()+ "\r");
                System.out.println(tXml);
            }
        }
        catch(IOException ex)
        {
            System.out.print(ex.getMessage());
        }
        return tXml;
    }
            
    //set
    public void setName(String name)
    {
        model.setName(name);
    }
    public void setHozain(String hozain)
    {
        model.setHozain(hozain);
    }
    public void setPoroda(String poroda)
    {
        model.setPoroda(poroda);
    }
     public void setPol(String pol)
    {
        model.setPol(pol);
    }
      public void setId(String id)
    {
        model.setId(id);
    }
       public void setAge(String age)
    {
        model.setAge(Integer.parseInt(age));
    }
    public void setAddText(String text)
    {
        try(FileWriter writer = new FileWriter("data.txt", true))
                {
                    writer.write(text);
                }
                catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
    }
    
    public void setCountFile() throws FileNotFoundException, IOException
    {
        this.CountFile = 0;
        FileReader r = new FileReader("data.txt");
        Scanner s = new Scanner(r);
        while(s.hasNext())
        {
            s.next();
            this.CountFile++;
            r.close();
        }
        System.out.println("количество строк "+this.CountFile);
    }
    
   
    
    //get
    public String getAddText(){
        return text;
    }
    public int getCountFile() throws IOException
    {
        setCountFile();
        return this.CountFile;
    }
    public String getId(){
        return model.getId();
    }
    public String getName(){
        return model.getName();
    }
    public String getAge(){
        return (""+model.getAge());
    }
   
    public String getPoroda(){
        return model.getPoroda();
    }
    public String getPol(){
        return model.getPol();
    }
    public String getHozain(){
        return model.getHozain();
    }
    public int getCount(){
        return model.getCount();
    }
}
