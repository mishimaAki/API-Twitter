package jp.ebiten.katsu.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ebiten.katsu.domain.entity.User;
import jp.ebiten.katsu.domain.repository.UserRepository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository{

}
