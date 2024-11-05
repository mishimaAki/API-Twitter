package jp.ebiten.katsu.domain.interacter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.ebiten.katsu.domain.entity.Tweet;
import jp.ebiten.katsu.domain.repository.TweetRepository;
import jp.ebiten.katsu.domain.repository.UserRepository;
import jp.ebiten.katsu.domain.usecase.TweetUseCase;

@Service
public class TweetInteracter implements TweetUseCase {
	
	private final TweetRepository tweetRepository;
	
	private final UserRepository userRepository;
	
	public TweetInteracter(TweetRepository tweetRepository, UserRepository userRepository) {
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
	}
	
	@Override
	public List<Tweet> getTweetList() {
		return this.tweetRepository.findAll();
	}
	
	@Override
	public void storeTweet(String content,Long user_id, LocalDateTime createdAt) {
		Tweet tweet = new Tweet(null,
								content,
								this.userRepository.findById(user_id).orElseThrow(() -> new RuntimeException()),
								createdAt);
		this.tweetRepository.save(tweet);
	}
	
	@Override
	public void deleteTweet(Long id) {
		this.tweetRepository.deleteById(id);
	};
	
	@Override
	public void updateTweet(Long tweet_id, String content, Long user_id, LocalDateTime createdAt) {
		Tweet tweet = new Tweet(tweet_id,
								content,
								this.userRepository.findById(user_id).orElseThrow(() -> new RuntimeException()),
								createdAt);
		this.tweetRepository.save(tweet);
	};

}
