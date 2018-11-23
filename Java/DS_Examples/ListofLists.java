package org.clongs.listoflists;
//Source: https://java2blog.com/java-list-of-lists/ 

import java.util.ArrayList;
import java.util.List;

public class JavaListOfListsMain(){
  public static void main(String[] args){
    //Main List of Lists; no Bounds checking
    List<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();

    ArrayList<String> innerList1 = new ArrayList<String>();
    innerList1.add("Portland");
    innerList1.add("OR");

    ArrayList<String> innerList2 = new ArrayList<String>();
    innerList2.add("Seattle");
    innerList2.add("WA");
    listOfLists.add(innerList1);
    listOfLists.add(innerList2);

    listOfLists.forEach((list) ->{
      list.forEach((city)->System.out.println(city))
    }
  }
}
