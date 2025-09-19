package br.com.grupo05.AgiPay.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@Entity
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username",nullable = false)
    private String username;

    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "O CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX")
    @Column(name = "cnpj",nullable = false,unique = true)
    private String cnpj;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

}
