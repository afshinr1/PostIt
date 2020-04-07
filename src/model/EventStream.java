package model;

import java.util.ArrayList;

public class EventStream {
	public static ArrayList<Event> events = new ArrayList<Event>();
	public static int timestamp = 0;
	
	static void addEvent(Event event) {
		events.add(event);
		
	}

}
