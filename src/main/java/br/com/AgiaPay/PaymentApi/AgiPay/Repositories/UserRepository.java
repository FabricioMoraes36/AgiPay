package br.com.AgiaPay.PaymentApi.AgiPay.Repositories;

import br.com.AgiaPay.PaymentApi.AgiPay.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    //Metodo para encontrar o usuario com base no login
    UserDetails findByEmail(String email);
}
