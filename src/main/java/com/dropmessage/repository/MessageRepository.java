package com.dropmessage.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dropmessage.entity.Message;

public interface MessageRepository extends  JpaRepository<Message, String> {
	List<Message> findByEmail(String email);
	List<Message> findByMessageId(int messageId);

}
