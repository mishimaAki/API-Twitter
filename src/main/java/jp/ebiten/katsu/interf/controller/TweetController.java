package jp.ebiten.katsu.interf.controller;

import jp.ebiten.katsu.domain.usecase.TweetUseCase;
import jp.ebiten.katsu.interf.dto.TweetRequestDTO;
import jp.ebiten.katsu.interf.dto.TweetResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

	private final TweetUseCase tweetUseCase;

	public TweetController(TweetUseCase tweetUseCase) {
		this.tweetUseCase = tweetUseCase;
	}

	@GetMapping
	public ResponseEntity<List<TweetResponseDTO>> getTweetList() {
		List<TweetResponseDTO> tweetResponseDTOs = tweetUseCase.getTweetList().stream()
				.map(tweet -> new TweetResponseDTO(
					tweet.getId(),
					tweet.getContent(),
					tweet.getCreatedAt()
				))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(tweetResponseDTOs, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> storeTweet(@RequestBody TweetRequestDTO tweetRequestDTO) {
		tweetUseCase.storeTweet(tweetRequestDTO.getContent(), tweetRequestDTO.getUser_id(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	public ResponseEntity<Void> updateTweet(@RequestBody TweetRequestDTO tweetRequestDTO) {
		tweetUseCase.updateTweet(tweetRequestDTO.getId(), tweetRequestDTO.getContent(), tweetRequestDTO.getUser_id(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteTweet(@RequestBody TweetRequestDTO tweetRequestDTO) {
		tweetUseCase.deleteTweet(tweetRequestDTO.getId());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
