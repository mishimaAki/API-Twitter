package jp.ebiten.katsu.interf.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TweetRequestDTO {

	private Long id;

	private String content;
	
	private Long user_id;

	private LocalDateTime createdAt;
	
	public TweetRequestDTO(Long id, String content, Long user_id, LocalDateTime createdAt) {
		this.id = id;
		this.content = content;
		this.user_id = user_id;
		this.createdAt = createdAt;
	}
}
