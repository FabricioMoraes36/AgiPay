package br.com.AgiaPay.PaymentApi.AgiPay.Services;

import br.com.AgiaPay.PaymentApi.AgiPay.Models.CompanyModel;
import br.com.AgiaPay.PaymentApi.AgiPay.Repositories.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    //Metodos

    public CompanyModel saveCompany(CompanyModel companyModel) {
        return companyRepository.save(companyModel);
    }

    public List<CompanyModel> getAllCompanies() {
        return companyRepository.findAll();
    }

    public CompanyModel findCompanyById(UUID id) {
        CompanyModel companyModel = companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada! verifique o id"));
        return  companyModel;
    }

    public CompanyModel updateCompany(CompanyModel companyModel,UUID id) {
        CompanyModel company = companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrda,verifique o id"));
        if (companyModel.getCompanyName() != null) company.setCompanyName(companyModel.getCompanyName());
        return companyRepository.save(company);
    }
    public void deleteCompanyById(UUID id) {
        CompanyModel companyModel = companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada!! verifique o id"));
        companyRepository.delete(companyModel);
    }

}
