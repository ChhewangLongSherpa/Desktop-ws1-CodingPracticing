package com.org.sherpa;

public static void main ( String arg[] ){

	// LINKED HASH MAP
	LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
	
	//WeakHashMap
	Map weakHashMap = new WeakHashMap();
	
	TreeMap tm = new TreeMap();
	TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
	
	TreeSet<Integer> treeSet = new TreeSet<>();
	
	//PRIORITYQUEUE 
	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	queue.addAll ( Arrays.asList( 9,2,3,1,3,8));

	//BLOCKING QUEUE
	BlockingQueue<String> bQueue1 = new ArrayBlockingQueue<>(2);
	BlockingQueue<String> bQueue2 = new LinkedBlockingQueue<>(2);
	BlockingQueue<String> bQueue3 = new PriorityBlockingQueue<>(2);
	
	//LINKEDLIST AS A FIFO QUEUE
	Queue<String> que = new LinkedList<String>();
	
	que.offer( "First Element") //Add this to the queue
	que.poll() // Call to remove the item from the list
	
	//Deque
	Deque deque = new LinkedList();
	
	
	Set set = lhm.entrySet();
	Iterator i  = set.iterator();
	
	while (i.hasNext()) {
		Map.Entry me = (Map.Entry) i.next();
		System.out.println( me.getKey() + " : " + me.getValue());
	}
	
	System.out.println( "Key: " + lhm.containsKey("Shiva");
	System.out.println( "Value: " + lhm.get("Asha");
	
	//	COMPOSING MAP <X,Y> AND MAP<Y,Z> TO GET MAP<X,Z>
	Map<String, Integer> map1 = new HashMap<String, Integer>();
	map1.put("key1", 1);
	map1.put("key2", 2);
	map1.put("key3", 3);
	
	Map<Integer, Double> map2 = new HashMap<Integer, Double>();
	map2.put(1, 1.0);
	map2.put(2, 2.0);
	map2.put(3, 3.0);
	
	Map<String, Double> map3 = new new HashMap<String, Double>();
	map1.forEach((key, value) -> map3.put(key, map2.get(value)));
	
	//TYPES OF MAPS
	Map<Integer, String> map1 = new HashMap<Integer, String>();
	Map<Integer, String> map2 = new TreeMap<Integer, String>();
	
	//TYPES OF LISTS
	List<String> list1 = new ArrayList<>();
	List<String> list2 = new LinkedList<String>();
	
	//TYPES OF SETS
	Set<String> set1 = new HashSet<>();
	Set<String> set2 = new LinkedHashSet<> ();
	Set<String> set3 = new TreeSet<> ();
	
	//Convert a List of Integers to a list of Strings
	List<Integer> nums = Arrays.asList(1,2,3);
	List<String> strings = nums.stream()
		.map(Object::toString)
		.collect(Collectors.toList());
		
	//Intialize ArrayList of Integer with size 100
	List<Integer> myList = new ArrayList<Integer>(100);
}