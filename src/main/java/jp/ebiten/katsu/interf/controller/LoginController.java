package jp.ebiten.katsu.interf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.ebiten.katsu.domain.entity.User;
import jp.ebiten.katsu.domain.usecase.LoginUseCase;
import jp.ebiten.katsu.interf.dto.LoginRequestDTO;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	private final LoginUseCase loginUseCase;
	
	public LoginController(LoginUseCase loginUseCase) {
		this.loginUseCase = loginUseCase;
	}
	
	@PostMapping
	public ResponseEntity<Void> login(@RequestBody LoginRequestDTO loginRequestDTO) {
		if(this.loginUseCase.authenticate(new User(null,
												loginRequestDTO.getUsername(),
												loginRequestDTO.getPassword(),
												null)
											))
		{
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}
