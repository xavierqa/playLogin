package models;

public class Communication {

	private String twitter;
	
	private String facebook;
	
	private String email;
	
	private String phone;
	
	private String twilio_phone;
	
	private String chatID;
	
	private Boolean contactedByemail;
	
	private Boolean contactedBytwitter;
	
	private Boolean contactedByVoice;
	
	private Boolean contactedBySMS;
	
	private Boolean contactedByChat;

	public Communication() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTwilio_phone() {
		return twilio_phone;
	}

	public void setTwilio_phone(String twilio_phone) {
		this.twilio_phone = twilio_phone;
	}

	public String getChatID() {
		return chatID;
	}

	public void setChatID(String chatID) {
		this.chatID = chatID;
	}

	public Boolean getContactedByemail() {
		return contactedByemail;
	}

	public void setContactedByemail(Boolean contactedByemail) {
		this.contactedByemail = contactedByemail;
	}

	public Boolean getContactedBytwitter() {
		return contactedBytwitter;
	}

	public void setContactedBytwitter(Boolean contactedBytwitter) {
		this.contactedBytwitter = contactedBytwitter;
	}

	public Boolean getContactedByVoice() {
		return contactedByVoice;
	}

	public void setContactedByVoice(Boolean contactedByVoice) {
		this.contactedByVoice = contactedByVoice;
	}

	public Boolean getContactedBySMS() {
		return contactedBySMS;
	}

	public void setContactedBySMS(Boolean contactedBySMS) {
		this.contactedBySMS = contactedBySMS;
	}

	public Boolean getContactedByChat() {
		return contactedByChat;
	}

	public void setContactedByChat(Boolean contactedByChat) {
		this.contactedByChat = contactedByChat;
	}
	
	
	
}
