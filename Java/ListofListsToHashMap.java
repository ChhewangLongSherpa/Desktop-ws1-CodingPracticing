package org.clongs.java8;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HashMapBuiltMain {
	public static void main( String[] args ){
		List<ArrayList<String>> listsOfLists = new ArrayList<ArrayList<String>>();
		ArrayList<String> inner1 = new ArrayList<String>();
		inner1.add("1");
		inner1.add("Smith");
		
		ArrayList<String> inner2 = new ArrayList<String>();
		inner1.add("2");
		inner1.add("Wayne");
		
		listOfLists.add( inner1 );
		listOfLists.add( inner2 );
		  
		HashMap<Integer, String> result1 = new HashMap<Integer, String>();
		HashMap<Integer, String> result2 = new HashMap<Integer, String>();
		
		for( int i = 0; i < listsOfLists.size(); ++i ){
			int key = Integer.parseInt(listsOfLists.get(i)[0]);
			result1 = listsOfLists.stream().collect( Collectors.toMap(key, listsOfLists.get(i)[1]));
		}
		System.out.println("Result1: " + result1 );
		
		//Pretty sure the below does not work
		listsOfLists.forEach((list) ->
		{
			int key = Integer.parseInt(list.get(0));
			result2.put(key, list.get(1));
		}	
		);
		System.out.println("Result1: " + result2 );
	}
}