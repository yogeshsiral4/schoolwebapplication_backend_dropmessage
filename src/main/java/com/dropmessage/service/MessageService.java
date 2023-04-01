package com.dropmessage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dropmessage.entity.Message;
import com.dropmessage.repository.MessageRepository;



@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public List<Message> showByEmail(String email){
		return messageRepository.findByEmail(email);
	}
	
	public List<Message> showByMessageId(int messageId){
		return messageRepository.findByMessageId(messageId);
	}
	
	public ResponseEntity<Message> sendMessage(Message message) {
		return new ResponseEntity<Message>(messageRepository.save(message),HttpStatus.CREATED);
	}
	
	public List<Message> getAllMessages(){
		return messageRepository.findAll();
	}
	
}
