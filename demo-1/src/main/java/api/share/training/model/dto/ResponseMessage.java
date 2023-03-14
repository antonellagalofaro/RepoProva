package api.share.training.model.dto;

public class ResponseMessage {

	private String message;
	private String id;

	public ResponseMessage() { super(); }
	
	public ResponseMessage(String message, String id) {
		super();
		this.message = message;
		this.id=id;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	@Override
	public String toString() {
		return "{\"message\":\"" + message + "\", \"id\":\"" + id +"\"}";
	}
	
	
}
