package model;

public class CommentEvent {
	
	private String type;
	private String content;
	private String uuid;
	private String parent_uuid;
	private int votes;
	private String timestamp;
	private String username;
	
	public CommentEvent(String type, String content, String uuid, String parent_uuid, int votes, String timestamp, String username) {
		this.type = type;
		this.content = content;
		this.uuid = uuid;
		this.parent_uuid = parent_uuid;
		this.votes = votes;
		this.timestamp = timestamp;
		this.username = username;
	}
	
	public String getType() {
		return type;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getUUID() {
		return uuid;
	}
	
	public String getParentUUID() {
		return parent_uuid;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public String getUsername() {
		return username;
	}
	
}
