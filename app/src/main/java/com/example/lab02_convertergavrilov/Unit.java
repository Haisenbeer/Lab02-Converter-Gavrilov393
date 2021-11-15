package com.example.lab02_convertergavrilov;

public class Unit
{
    public String name; //Имя еддиницы измерения
    public double coef; //Коэффициент единицы измерения

    //Конструктор класс
    public Unit(String name, double coef)
    {
        this.name = name;
        this.coef = coef;
    }

    public String toString()
    {
        return name;
    }
}
