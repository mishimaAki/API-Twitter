package jp.ebiten.katsu.domain.interacter;

import org.springframework.stereotype.Service;

import jp.ebiten.katsu.domain.entity.User;
import jp.ebiten.katsu.domain.repository.UserRepository;
import jp.ebiten.katsu.domain.usecase.LoginUseCase;

@Service
public class LoginInteracter implements LoginUseCase {
	
	private UserRepository userRepository;
	
	public LoginInteracter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public boolean authenticate(User user) {
		try {
			User exist_user = this.userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new RuntimeException());
			if(user.getPassword().equals(exist_user.getPassword())) {
				
				return true;
			}
		} catch (RuntimeException e) {
			return false;
		}
		
		return false;
	}
}
