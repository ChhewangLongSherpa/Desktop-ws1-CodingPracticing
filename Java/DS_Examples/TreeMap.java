/*
1. TreeMap implements Map interface and extends HashMap class.
2. TreeMap is implemented using Red black tree based NavigableMap.
3. TreeMap is ordered collection and store its elements in natural ordering of keys.
4. Key which you would like to put in TreeMap must implement Comaparable interface or you can use Comparator for custom sorting
Source: https://java2blog.com/treemap-in-java-with-examples/
*/

package org.clongs.java8;

import java.util.TreeMap;

public class TreeMapMain{

  public static void main( String[] args ){
    // TreeMap with Country as key and capital as value
    // TreeMap stores elements in natural ordering of keys
    TreeMap<String, String> countryCapitalMap = new TreeMap<String,String>();
    countryCapitalMap.put( "India","Delhi" );
    countryCapitalMap.put( "Japan","Tokyo" );
    countryCapitalMap.put( "France","Paris" );
    countryCapitalMap.put( "Russia","Moscow" );

    System.out.println( "------- ------ ------ ------ ------ ------ ----- ");
    //Iterating TreeMap Using keySet() and for each loop
    System.out.println( "Iterating TreeMap Using keySet() and for each loop");
    for ( String countryKey:countryCapitalMap.keySet()){
      System.out.println( "Country: " + countryKey + " and Capital: " + countryCapitalMap.get(countryKey));
    }
    System.out.println( "------- ------ ------ ------ ------ ------ ----- ");
  }
}
