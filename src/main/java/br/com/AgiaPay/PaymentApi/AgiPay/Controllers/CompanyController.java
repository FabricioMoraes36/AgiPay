package br.com.AgiaPay.PaymentApi.AgiPay.Controllers;

import br.com.AgiaPay.PaymentApi.AgiPay.Models.CompanyModel;
import br.com.AgiaPay.PaymentApi.AgiPay.Services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyModel> addCompany(@RequestBody CompanyModel companyModel) {
        CompanyModel company = companyService.saveCompany(companyModel);
        return ResponseEntity.ok().body(company);
    }
    @GetMapping
    public ResponseEntity<List<CompanyModel>> getCompanies() {
        return ResponseEntity.ok().body(companyService.getAllCompanies());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyModel> getCompany(@PathVariable UUID id) {
        CompanyModel company = companyService.findCompanyById(id);
        return ResponseEntity.ok().body(company);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompanyModel> updateCompany(@PathVariable UUID id, @RequestBody CompanyModel companyModel) {
       CompanyModel company = companyService.updateCompany(companyModel, id);
        return ResponseEntity.ok().body(company);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyModel> deleteCompany(@PathVariable UUID id) {
        companyService.deleteCompanyById(id);
        return ResponseEntity.noContent().build();
    }
}
