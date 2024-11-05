package jp.ebiten.katsu.domain.repository;

import java.util.Optional;

import jp.ebiten.katsu.domain.entity.User;

public interface UserRepository {

	User save(User user);
	Optional<User> findByUsername(String username);
	Optional<User> findById(Long id);
}
