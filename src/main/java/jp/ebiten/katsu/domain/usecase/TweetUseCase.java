package jp.ebiten.katsu.domain.usecase;

import jp.ebiten.katsu.domain.entity.Tweet;

import java.util.List;
import java.time.LocalDateTime;

public interface TweetUseCase {
	
	List<Tweet> getTweetList();
	void storeTweet(String content,Long user_id, LocalDateTime createdAt); 
	void deleteTweet(Long id);
	void updateTweet(Long id, String content, Long user_id, LocalDateTime createdAt);
}
