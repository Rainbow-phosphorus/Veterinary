/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

/**
 *
 * @author student
 */
public class Model {
    private String name;
    private String hozain;
    private String poroda;
    private String pol;
    private String id;
    private int age;
    private int count;    
    //set
    public void setName(String name)
    {
        this.name = name;
    }
    public void setHozain(String hozain)
    {
        this.hozain = hozain;
    }
    public void setPoroda(String poroda)
    {
        this.poroda = poroda;
    }
     public void setPol(String pol)
    {
        this.pol = pol;
    }
      public void setId(String id)
    {
        this.id = id;
    }
       public void setAge(int age)
    {
        this.age = age;
    }
       public void setCount(String count)
    {
        this.count = Integer.parseInt(count);
    }
   
    //get
    public int getCount()
    {
        this.count = 6;
        return this.count;
    }
    public String getName()
    {
        return name;
    }
    public String getHozain()
    {
        return hozain;
    }
    public String getPoroda()
    {
        return poroda;
    }
    public String getPol()
    {
        return pol;
    }
    public String getId()
    {
        return id;
    }
    public int getAge()
    {
        return age;
    }
    
}
