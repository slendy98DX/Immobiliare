package org.example;

import java.util.Arrays;
import java.util.Optional;

import org.example.entity.Utente;
import org.example.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.pasqualecavallo.studentsmaterial.authorization_framework.dao.UserDao;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private UtenteRepository userRepository;
	
	@Override
	public UserDetails getUserByUsername(String username) {
		Optional<Utente> oUtente = userRepository.findById(username);
		if(oUtente.isPresent()) {
			UserDetails userDetails = new UserDetails();
			Utente utente = oUtente.get();
			userDetails.setUsername(utente.getUsername());
			userDetails.setPassword(utente.getPassword());
			userDetails.setRoles(Arrays.asList("ROLE_USER"));
			return userDetails;
		} else {
			return null;
		}
		
	}


	
}
