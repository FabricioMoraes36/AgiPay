package br.com.grupo05.AgiPay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDto {

    private String cnpj;
    private String username;
    private String email;
}
