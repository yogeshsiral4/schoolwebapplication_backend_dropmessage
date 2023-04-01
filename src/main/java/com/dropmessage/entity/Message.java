package com.dropmessage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Message_Box")
public class Message {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="messageId", columnDefinition = "INT(15) UNIQUE KEY auto_increment")
    private int messageId;
	
	@Id
	private String email;
	
	@Column(name = "message")
	private String message;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
