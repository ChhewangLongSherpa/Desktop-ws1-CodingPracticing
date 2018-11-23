/*
HashSet implements Set interface which does not allow duplicate value.It is not
synchronized and is not thread safe.
Definition of duplicate can be quite tricky sometimes.
Lets consider two cases here.
In case of primitive types(such as interger, String)
Source:: https://java2blog.com/how-hashset-works-in-java/
*/

package org.clongs.java8;

import java.util.HashSet;

public class HashSetMain {
  public static void main( String[] args ){
    HashSet nameSet = new HashSet();
    nameSet.add( "Arpit" );
    nameSet.add( "Arpit" ); // This dupe will be cleared out by the HashSet
    nameSet.add( "john" );
    System.out.println( "Size of NameSet = " + nameSet.size() );
    System.out.println(nameSet);
  }
}
/*
size of nameSet=2
[Arpit, john]
*/
