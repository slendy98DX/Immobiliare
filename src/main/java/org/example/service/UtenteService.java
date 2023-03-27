package org.example.service;

import java.util.Optional;

import org.example.controllers.dto.ActivateRequestDto;
import org.example.controllers.dto.ActivateResponseDto;
import org.example.controllers.dto.BaseResponse;
import org.example.controllers.dto.RegistrationRequestDto;
import org.example.controllers.dto.RegistrationResponseDto;
import org.example.entity.Utente;
import org.example.exception.InvalidActivationCodeException;
import org.example.exception.UserNotFoundException;
import org.example.repository.RuoloRepository;
import org.example.repository.UtenteRepository;
import org.example.utility.EmailSender;
import org.example.utility.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository userRepository;
	
	@Autowired
	private EmailSender emailSender;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RuoloRepository ruoloRepository;
	
	public RegistrationResponseDto register(RegistrationRequestDto request) {
		Utente utente = userRequestToEntity(request);
		userRepository.save(utente);
		emailSender.sendRegistrationEmail(utente);
		return userEntityToResponse();
	}

	public ActivateResponseDto activate(ActivateRequestDto request) {
		Optional<Utente> oUtente = userRepository.findByEmail(request.getEmail());
		Utente utente = oUtente.orElseThrow(UserNotFoundException::new);
		if(request.getActivationCode().equals(utente.getActivationCode())) {
			utente.setActive(true);
			utente.setActivationCode(null);
			userRepository.save(utente);
			ActivateResponseDto response = new ActivateResponseDto();
			response.setStatus(BaseResponse.Status.OK);
			response.setUsername(utente.getUsername());
			return response;
		} else {
			throw new InvalidActivationCodeException();
		}
	}

	
    private Utente userRequestToEntity(RegistrationRequestDto request) {
    	Utente utente = new Utente();
    	utente.setEmail(request.getEmail());
    	utente.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
    	utente.setUsername(request.getUsername());
    	utente.setActivationCode(StringUtility.generateRandomString(6));
		utente.setActive(false);
		utente.setRuolo(ruoloRepository.findByNomeRuolo("ROLE_UTENTE"));
    	return utente;
    }

    private RegistrationResponseDto userEntityToResponse(){
		RegistrationResponseDto response = new RegistrationResponseDto();
		response.setStatus(BaseResponse.Status.OK);
    	return response;
    }
	
}
