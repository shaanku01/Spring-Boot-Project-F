package com.zemoso.springboot.thymeleafdemo;

public class Calculator {
    public int doSum(int a,int b,int c){
        return a+b+c;
    }

    public int doproduct(int a,int b,int c){
        return a*b*c;
    }

    public Boolean compareTwoNums(int a, int b){
        return a==b;
    }
}
