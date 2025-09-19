package br.com.grupo05.AgiPay.repository;

import br.com.grupo05.AgiPay.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyModel, UUID> {
}
