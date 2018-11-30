/* Storing Custom objects as Key:
You can store custom objects as Key in HashMap but you should implement hashcode
and equals method, otherwise it may not work as expected.  You may go through
hashcode and equal method to understand it better.
Source: https://java2blog.com/hashmap-in-java-with-examples/
*/
package org.clongs.java8;

import java.util.HashMap;

public class Country {
  String name;
  long population;

  public Country( String name, long population ) {
    super();
    this.name = name;
    this.population = population;
  }
  public String getName(){
    return name;
  }
  public void setName( String name ) {
    this.name = name;
  }
  public long getPopulation() {
    return population;
  }
  public void setPopulation( long population ) {
    this.population = population;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (( name == null )) ? 0 : name.hashCode() );
    result = prime * result + (int) (population ^ (population >>> 32 ));
    return result;
  }
  @Override
  public boolean equals( Object obj ){
    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass())
      return false;
    Country other = (Country) obj;
    if ( name == null ) {
      if ( other.name != null )
        return false;
    } else if ( !name.equals(other.name) )
      return false;
    return true;
  }
}

public class HashMapMain {

  public static void main( String args[] ){
    //HashMap with Country name as key and capital as value
    //HashMap stores elements in key value pairs
    HashMap<String, String> countryCapitalMap = new HashMap<String, String>();
    countryCapitalMap.put( "India","Delhi" );
    countryCapitalMap.put( "Japan","Tokyo" );
    countryCapitalMap.put( "France","Paris" );
    countryCapitalMap.put( "Russia","Moscow" );

    System.out.println( " ----- ---- ---- ---- ---- --- " );
    //Iterating HashMap Using keySet() adn for each loop
    System.out.println( "Iterating HashMap using keySet() and for each loop" );
    for ( String countryKey:countryCapitalMap.keySet()){
      System.out.println( "Country: " + countryKey + " and capital: " + countryCapitalMap.get(countryKey));
    }
    System.out.println( " ----- ---- ---- ---- ---- --- " );
  }
}
