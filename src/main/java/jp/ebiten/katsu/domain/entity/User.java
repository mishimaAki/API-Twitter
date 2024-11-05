package jp.ebiten.katsu.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@Getter
	@Setter
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	
	@Getter
	@Setter
	@Column(name = "password", nullable = false, unique = false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Tweet> tweets ;

}
