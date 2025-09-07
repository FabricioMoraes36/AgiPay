package br.com.AgiaPay.PaymentApi.AgiPay.Models;

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
@Table(name = "Companies")

public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID companyId;

    private String companyName;

    @NotBlank
    @Pattern(regexp ="\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}",
            message = "O CNPJ tem que seguir o formato: XX.XXX.XXX/XXXX-XX"
    )
    private String companyCnpj;

    private BigDecimal companyBalance;
}
