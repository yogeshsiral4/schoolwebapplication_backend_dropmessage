package com.dropmessage.config;

import com.dropmessage.entity.Message;
import com.dropmessage.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageDetailsService implements UserDetailsService {

    @Autowired
    private MessageRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Message> user = repository.findById(email);
        try {
        	return user.map(MessageDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
    }
}