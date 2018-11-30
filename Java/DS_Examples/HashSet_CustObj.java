//Source: https://java2blog.com/how-hashset-works-in-java/

package org.clongs.java8;

import java.util.HashSet;

public class Country {
  String name;
  long population;
  public String getName() {
    return name;
  }
  public void setName( String name ){
    this.name = name;
  }
  public long getPopulation(){
    return population;
  }
  public void setPopulation( long population ){
    this.population = population;
  }
  public String toString(){
    return name;
  }

  @Override
  public boolean equals( Object obj ){
    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass() )
      return false;
    Country other = (Country) obj;
    if ( name == null ){
      if ( other.name != null )
        return false;
    } else if ( !name.equals( other.name ))
      return false;
    return true;
  }

  //HashCodeMethod
  @Override
  public int hashCode(){
    final int prime = 31;
    int result = 1;
    result = prime * result + (( name == null )) ? 0 : name.hashCode() );
    return result;
  }
}

public class HashSetCountryMain {

  public static void main( String[] args ){
    HashSet countrySet = new HashSet();
    Country india1 = new Country();
    india1.setName( "India" );
    Country india2 = new Country();
    india2.setName( "India" );

    countrySet.add( india1 );
    countrySet.add( india2 );

    System.out.println( "Size of nameSet=" + countrySet.size() );
    System.out.println( countrySet );

  }
}

/*
From the JavaAPI:
HashSet uses HashMap for checking duplicate elements.As we know that in HashMap,
key should be unique. So HashSet uses this concept, When element is added to
HashSet, it is added to internal HashMap as Key.This HashMap required some value
so a dummy Object(PRESENT) is used as value in this HashMap.
PRESENT is dummy value which is used value for internal map.

So here there will be two cases
map.put(e,PRESENT) will return null, if element not present in that map. So
  map.put(e, PRESENT) == null will return true ,hence add method will return
  true and element will be added in HashSet.
map.put(e,PRESENT) will return old value ,if element is already present in that
  map. So  map.put(e, PRESENT) == null will return false, hence add method will
  return false and element will not be added in HashSet.
