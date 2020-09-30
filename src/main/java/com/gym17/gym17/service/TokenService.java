package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.Token;
import src.main.java.com.gym17.gym17.repositories.TokenRepository;

@Service
public class TokenService {
	private TokenRepository TokenRepository;

	@Autowired
	public TokenService(TokenRepository TokenRepository) {
		this.TokenRepository = TokenRepository;
	}
	public Iterable<Token> list() {
		Iterable<Token> TokenCollection = TokenRepository.findAll();
		return TokenCollection;
	}

	public Optional<Token> findById(int parseInt) {
		return TokenRepository.findById(parseInt);
	}
	
	public Token saveToken(Token data) {
		return TokenRepository.save(data);
	}
	public void delete(Token Token) {
		TokenRepository.delete(Token);				
	}
	public Optional<Token> findBylicence(String licenceName) {
		return TokenRepository.findByLicence(licenceName);

	}

}