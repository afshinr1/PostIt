package model;

public class Command {

	public void createEvent(String randomUUIDString, String username, String parentUUID, String commentInfo) {
		Event newEvent = new Event(randomUUIDString, username, parentUUID, commentInfo);
		EventStream.addEvent(newEvent);
		
		//Add event to database??
	}

}
