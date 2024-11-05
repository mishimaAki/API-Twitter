package jp.ebiten.katsu.interf.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TweetResponseDTO {
	
	private Long id;

	private String content;
	
	private LocalDateTime createdAt;
	
	public TweetResponseDTO(Long id, String content, LocalDateTime createdAt) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
	}
	
}
