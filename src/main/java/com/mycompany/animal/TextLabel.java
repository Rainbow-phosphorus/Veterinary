/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

/**
 *
 * @author student
 */
public class TextLabel {
     public static String getText(int n)
    {
        String Label = "";
        switch(n)
        {
            case 0: Label = "Ветклиника";
            break;
            case 1: Label = "Имя";
            break;
            case 2: Label = "Семейство";
            break;
            case 3: Label = "Порода";
            break;
            case 4: Label = "Пол";
            break;
            case 5: Label = "ID";
            break;
            case 6: Label = "Возраст";
            break;
            case 7: Label = "Имя Семейство Порода Пол ID Возраст";
            break;
            case 8: Label = "Загрузка";
            break;
            case 9: Label = "Сохранить в файл";
            break;
            case 10: Label = "Загрузка XML";
            break;
            case 11: Label = "Файл txt";
            break;
            case 12: Label = "Файл xml";
            break;
            case 13: Label = "Добавление в лист";
            break;
            
        }
          
        return Label;
    }
}
