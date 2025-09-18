package br.com.grupo05.AgiPay.Repositories;

import br.com.grupo05.AgiPay.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    //Metodo personalizado para achar o usuario por email
    UserModel findUserByEmail(String email);

    //Metodo personalizado para achar o usuario por cpf
    UserModel findUserByCpf(String cpf);
}
