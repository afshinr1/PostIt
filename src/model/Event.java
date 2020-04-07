package model;

public class Event {
public String commentUUID;
public String username;
public String parentUUID;
public String commentInfo;
public String timeStamp;
	public Event(String randomUUIDString, String username, String parentUUID, String commentInfo) {
		commentUUID = randomUUIDString;
		this.username = username;
		this.parentUUID = parentUUID;
		this.commentInfo = commentInfo;
	}
}
