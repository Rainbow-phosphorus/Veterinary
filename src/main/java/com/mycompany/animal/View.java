/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

/**
 *
 * @author student
 */
import java.awt.Color;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View {
    private JButton [] button = new JButton [4];
    private JMenu [] menu = new JMenu [2];
    private JMenuItem [] itemTxt = new JMenuItem [2];
    private JMenuItem [] itemXml = new JMenuItem [2];
    private JTextField [] textF = new JTextField[6];
 
    public TextLabel t = new TextLabel();
    public Controler c = new Controler();
    public SaveXml s = new SaveXml();
    public Animal a = new Animal();
    public  DefaultListModel<String> listn = new DefaultListModel<>();

    public void fg(Model [] DataForm) throws IOException, ParserConfigurationException, TransformerException
    {
        JFrame fram = new JFrame(TextLabel.getText(0));
        fram.setSize(904,570);
        
        
        JMenuBar menbar = new JMenuBar();
        int h = 0;
        for (int i = 0; i<menu.length; i++)
        {
             JMenu m = new JMenu(TextLabel.getText(i+11));
             menu[h] = m;
             h++;
        }
         menbar.add(menu[0]);
         menbar.add(menu[1]);
         int it = 0;
         for (int i = 0; i<itemTxt.length; i++)
         {
             JMenuItem opent = new JMenuItem(TextLabel.getText(i+8));
             
             menu[0].addSeparator();
             menu[0].add(opent);
             
             itemTxt[it] = opent;
             it++;
         }
         int ix = 0;
         for (int i = 0; i<itemXml.length; i++)
         {
             JMenuItem openx = new JMenuItem(TextLabel.getText(i+9));
             
             menu[1].addSeparator();
             menu[1].add(openx);
  
             itemXml[ix] = openx;
             ix++;
         }
         
        fram.setJMenuBar(menbar);
        
        int x = 5;
        int x1 = 70;
        int y = 0;
        int tf = 0;
        for (int i = 0; i<6; i++)
        {
            JLabel l = new JLabel(TextLabel.getText(i+1));
            l.setBounds(x, y, 100, 30);
            fram.add(l);
            
            JTextField text = new JTextField();
            text.setBounds(x1, y, 230, 30);
            fram.add(text);
            y += 20;
            textF[tf] = text;
            tf++;
        }
        
        JButton dobavl = new JButton(TextLabel.getText(13));
        dobavl.setBounds(5, 450, 250, 40);
        dobavl.setBackground(Color.green);
        fram.add(dobavl);
        
        JLabel l2 = new JLabel(TextLabel.getText(7));
        l2.setBounds(305, 0, 300, 20);
        fram.add(l2);
 
        //Кнопки в меню
        
        itemTxt[0].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                listn.clear();
                for (int i = 0; i<DataForm.length; i++)
                {
                    listn.addElement(DataForm[i].getName() +" "+ DataForm[i].getHozain()+ " "+DataForm[i].getPoroda()+ " "+DataForm[i].getPol()+" "+DataForm[i].getId()+" "+DataForm[i].getAge());
                    System.out.println(DataForm[i].getName());
                    textF[0].setText(DataForm[i].getName());
                    textF[1].setText(DataForm[i].getHozain());
                    textF[2].setText(DataForm[i].getPoroda());
                    textF[3].setText(DataForm[i].getPol());
                    textF[4].setText(DataForm[i].getId());
                    textF[5].setText(""+DataForm[i].getAge());
                }
                
                System.out.println("Кнопка меню 1 сработала");
            }
        });
         dobavl.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                listn.addElement(textF[0].getText() + " " + textF[1].getText()+ " " + textF[2].getText()+ " " + textF[3].getText()+ " " + textF[4].getText()+ " " + textF[5].getText());
                
                System.out.println("Кнопка 1 сработала");
            }
        });
        itemTxt[1].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                 c.setAddText("\r"+textF[0].getText() + ";" + textF[1].getText()+ ";" + textF[2].getText()+ ";" + textF[3].getText()+ ";" + textF[4].getText()+ ";" + textF[5].getText());
                 JOptionPane.showMessageDialog(null,"Данные добавились в файл");
                
                 System.out.println("Кнопка меню 2 сработала");
            }
        });
         itemXml[0].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               try {
                    a.fg();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Кнопка меню 3 сработала");
                JOptionPane.showMessageDialog(null,"Данные добавились в файл");
            }
        });
         itemXml[1].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                listn.clear();
                try(FileReader xmlRead = new FileReader("test.xml"))
                {
                    Scanner scanXml = new Scanner(xmlRead);
                    while (scanXml.hasNext())
                    {
                       listn.addElement(scanXml.nextLine()+ "\r");
                    }
                }
                catch(IOException ex)
                {
                    System.out.print(ex.getMessage());
                }
                System.out.println("Кнопка меню 4 сработала");
               
            }
        });

        JList<String> list = new JList< >(listn);
        list.setBounds(305, 17, 580, 470);
        fram.add(list);
        fram.setLayout(null);
        fram.setVisible(true);
    }
}
