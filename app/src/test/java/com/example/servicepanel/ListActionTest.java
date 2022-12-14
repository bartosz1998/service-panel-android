package com.example.servicepanel;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ListActionTest {
//    ListAction listAction = new ListAction();
//    String[] names = {"OCZEKUJE NA REALIZACJE","ZAKOŃCZONO","BĘDZIE KONTYNUOWANE","W TRAKCIE"};
//    String name;

    @Test
    public void add() {

//        System.out.println("to");
//        String str1 = "to";
       //name = names[(int) (Math.random()* names.length)];
       //assertTrue(listAction.statusEventValue(name));
        ListAction listAction = new ListAction();
        assertEquals(4,listAction.add(2,2));

    }
}