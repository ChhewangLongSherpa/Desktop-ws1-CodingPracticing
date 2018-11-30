package org.clongs.java8;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListofListsToHashMap {

	private static void sout( Object x ){
		System.out.println(x);
	}

	private static void ListToMap( List<ArrayList<String>> listOfLists ) {
		HashMap<Integer, String> result = new HashMap<Integer, String>();
		listOfLists.forEach((list) ->
		{
			result.put( Integer.parseInt( list.get(0) ), list.get(1) );
		}
		);
		sout(result);

		/*
		//Alternate solution
		for( int i = 0; i < list.size(); ++i ){
			result.put( Integer.parseInt( list.get(i).get(0) ),
			 list.get(i).get(1) );
		}
		sout(result);
		*/
	}

	public static void main( String[] args ){

		List<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		ArrayList<String> inner1 = new ArrayList<String>();
		inner1.add("1");
		inner1.add("Smith");

		ArrayList<String> inner2 = new ArrayList<String>();
		inner2.add("2");
		inner2.add("Wayne");

		listOfLists.add( inner1 );
		listOfLists.add( inner2 );

		//DEBUG or the CHECKSUM
		listOfLists.forEach((list) ->
		{
			list.forEach((item) -> System.out.println( item ) );
		}
		);

		ListToMap(listOfLists);
		/*
		HashMap<Integer, String> result1 = new HashMap<Integer, String>();
		HashMap<Integer, String> result2 = new HashMap<Integer, String>();

		sout("List of Lists Size: "+listsOfLists.size());
		sout("Standard For Method");
		for( int i = 0; i < listsOfLists.size(); ++i ){
			//sout( "Index: " + i);
			//sout( listsOfLists.get(i) );
			//int key = Integer.parseInt( listsOfLists.get(i).get(0) );
			//String temp = listsOfLists.get(i).get(1);
			//sout(key);
			//sout( listsOfLists.get(i).get(1) );
			//result1.put( key, temp );
			result1.put( Integer.parseInt( listsOfLists.get(i).get(0) ),
			 listsOfLists.get(i).get(1) );

			//result1 = listsOfLists.stream().collect( Collectors.toMap(key, listsOfLists.get(i).get(1)));
		}
		sout("Result1: " + result1 );

		sout("For Each Method");
		listsOfLists.forEach((list) ->
		{
			result2.put( Integer.parseInt( list.get(0) ), list.get(1) );
			int key = Integer.parseInt(list.get(0));
			//sout(key);
			result2.put( Integer.parseInt( list.get(0) ), list.get(1) );
		}
		);
		sout("Result2: " + result2 );
		*/
	}
}
