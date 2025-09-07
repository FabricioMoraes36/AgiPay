package br.com.AgiaPay.PaymentApi.AgiPay.Repositories;

import br.com.AgiaPay.PaymentApi.AgiPay.Models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyModel, UUID> {
}
