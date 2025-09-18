package br.com.grupo05.AgiPay.repository;

import br.com.grupo05.AgiPay.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
