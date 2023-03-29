package org.example.service;

import java.util.Arrays;
import java.util.Optional;

import org.example.entity.Utente;
import org.example.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserService;

@Service
public class ImmobiliareUserServiceImpl implements UserService {

	@Autowired
	private UtenteRepository userRepository;
	
	@Override
	public UserDetails checkUserCredentials(String username, String password) {
		Optional<Utente> oUtente = userRepository.findById(username);
		if(oUtente.isPresent()) {
			UserDetails userDetails = new UserDetails();
			Utente utente = oUtente.get();
			if(utente.getActive().booleanValue()) {
				userDetails.setUsername(utente.getUsername());
				userDetails.setPassword(utente.getPassword());
				userDetails.setRoles(Arrays.asList(utente.getRuolo().getNomeRuolo()));
				return userDetails;				
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
