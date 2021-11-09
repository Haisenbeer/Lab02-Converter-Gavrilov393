package com.example.lab02_convertergavrilov;

public class Unit
{
    public String name;
    public double coef;

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
