package br.com.AgiaPay.PaymentApi.AgiPay.Models;


//"\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
//message = "CPF deve estar no formato XXX.XXX.XXX-XX")

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String username;

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
message = "CPF deve estar no formato XXX.XXX.XXX-XX")
    private String cpf;

    private BigDecimal balance;
}
