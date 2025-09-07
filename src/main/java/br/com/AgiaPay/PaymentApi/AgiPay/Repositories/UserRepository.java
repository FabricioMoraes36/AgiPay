package br.com.AgiaPay.PaymentApi.AgiPay.Repositories;

import br.com.AgiaPay.PaymentApi.AgiPay.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
