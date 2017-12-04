package com.rpm.demo.designpattern.adapter;

import org.omg.PortableServer.AdapterActivator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Book{
    private Vector<String> books;
    public Book(){
        books = new Vector<String>();
    }
    public void add(String book){
        books.add(book);
    }
    public Enumeration<String> getEnum(){
        return books.elements();
    }



    public static void main(String args[]){
//        Book books = new Book();
//        books.add("think in java");
//        books.add("c++ primer");
//        books.add("伊索寓言");
//
//
//        Enumeration<String> em = books.getEnum();
//        while(em.hasMoreElements()){
//            System.out.println(em.nextElement());
//        }


        BookAdapter books = new BookAdapter();
        books.add("think in java");
        books.add("c++ primer");
        books.add("伊索寓言");
        Iterator<String> iterator = books.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}