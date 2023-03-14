package api.share.training.model.dto;

public class ErrorResponse {
	private String type;
	private String title;
	private String status;
	private String detail;
	private String instance;
	
	
	public ErrorResponse(String title, String status, String detail, String instance) {
		super();
		this.type = "https://tools.ietf.org/html/rfc7231#section-6.6.4";
		this.title = title;
		this.status = status;
		this.detail = detail;
		this.instance = instance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	@Override
	public String toString() {
		return "{\"type\":\"" + type + "\", \"title\":\"" + title + "\", \"status\":\"" + status + "\", \"detail\":\"" + detail
				+ "\", \"instance\":\"" + instance + "\"}";
	}
	
	
}
