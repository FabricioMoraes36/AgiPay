package br.com.grupo05.AgiPay.dto;

import lombok.Data;

@Data
public class UserRequestDTO {

    private String cpf;
    private String email;
    private String username;
}
