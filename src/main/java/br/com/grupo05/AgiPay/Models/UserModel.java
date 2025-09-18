package br.com.grupo05.AgiPay.Models;

import jakarta.persistence.*;
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
@Table(name = "users")
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "cpf",unique = true,nullable = false)
    @Pattern(regexp = "\\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{3}-\\\\d{2}",message = "o CPF deve estar no formato XXX.XXX.XXX-XX")
    private String cpf;
    @Column(name = "email", unique = true,nullable = false)
    private String email;
    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;
}
