package practice.springRest.exception;

public class StudentErrorResponse {
	
	private String errorMessage;
	private Integer statusCode;
	private Long timeStamp;
	
	public StudentErrorResponse(String errorMessage, Integer statusCode, Long timeStamp) {
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
