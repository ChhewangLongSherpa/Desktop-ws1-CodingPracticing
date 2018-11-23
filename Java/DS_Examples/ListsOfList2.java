package com.clongs.java8;
//Source: https://www.mkyong.com/java8/java-8-convert-list-to-map/

public class Hosting(){
  private int Id;
  private String name;
  private long websites;

  public Hosting(int id, String name, long websites){
    this.Id = id;
    this.name = name;
    this.websites = websites;
  }
  //Getters, Setters and ToString()
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stream.Collectors;

public class TestListMap{
  public static void main( String [] args ) {
    List<Hosting> list = new ArrayList<>();
    list.add( new Hosting (1, "liquidweb.com", 80000) );
    list.add( new Hosting (2, "linode.com", 90000) );
    list.add( new Hosting (3, "digitialocean.com", 12000) );
    list.add( new Hosting (4, "aws.amazon.com", 220000) );
    list.add( new Hosting (5, "mykong.com", 1) );

    //Key = id,value - websites
    Map<Integer, String> result1 = list.stream().collect(
      Collectors.toMap( Hosting::getId, Hosting::getName ) );

    System.out.println( "Result 1: " + result1 );

    //Key = name,value - websites
    Map<String, Long> result2 = list.stream().collect(
      Collectors.toMap(Hosting::getName, Hosting::getWebsites) );

    System.out.println( "Result 2: " + result2 );

    // Same with result1, just different syntax
    // Key = id, value = name
    Map<Integer, String> result3 = list.stream().collect(
      Collectors.toMap( x -> x.getId(), x -> x.getName() ) );

    System.out.println( "Result 3 : " + result3 );
  }
}




  }

}
