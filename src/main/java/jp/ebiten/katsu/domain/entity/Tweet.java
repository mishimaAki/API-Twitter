package jp.ebiten.katsu.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tweets")
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {
	
	@Id
	@Getter
	@Setter
	@Column(name = "tweet_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "content", nullable = false)
	private String content;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Getter
	@Setter
	@Column(name = "createdAt", nullable = false)
	private LocalDateTime createdAt;
}
