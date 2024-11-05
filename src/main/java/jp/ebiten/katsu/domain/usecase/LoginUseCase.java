package jp.ebiten.katsu.domain.usecase;

import jp.ebiten.katsu.domain.entity.User;

public interface LoginUseCase {

	boolean authenticate(User user);
}
