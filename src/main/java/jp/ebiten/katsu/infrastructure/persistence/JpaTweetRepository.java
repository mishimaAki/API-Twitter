package jp.ebiten.katsu.infrastructure.persistence;

import jp.ebiten.katsu.domain.entity.Tweet;
import jp.ebiten.katsu.domain.repository.TweetRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface JpaTweetRepository extends JpaRepository<Tweet, Long>, TweetRepository {
	
	@Override
	Optional<Tweet> findById(Long id);
}
