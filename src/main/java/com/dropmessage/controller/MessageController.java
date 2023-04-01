package com.dropmessage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dropmessage.entity.Message;
import com.dropmessage.service.MessageService;

@RestController
@RequestMapping(path = "/message")
@CrossOrigin(origins = "*")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/show/{email}")
	public List<Message> showByEmail(@PathVariable String email){
		return messageService.showByEmail(email);
	}
	
	@GetMapping("/show/id/{messageId}")
	public List<Message> showByMessageId(@PathVariable int messageId){
		return messageService.showByMessageId(messageId);
	}
	
	@GetMapping("/allmessage")
	public List<Message> getAllMessages(){
		return messageService.getAllMessages();
	}
	
	@PostMapping("/send")
	public ResponseEntity<Message> sendMessgae(@RequestBody Message message) {
		return messageService.sendMessage(message);
	}
	
}
