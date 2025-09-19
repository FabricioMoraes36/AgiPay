package br.com.grupo05.AgiPay.service;

import br.com.grupo05.AgiPay.dto.CompanyRequestDto;
import br.com.grupo05.AgiPay.dto.CompanyResponseDto;
import br.com.grupo05.AgiPay.model.CompanyModel;
import br.com.grupo05.AgiPay.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    //find all
    public List<CompanyResponseDto> findAll(){
        return companyRepository.findAll().stream().map(this::toResponseDto).collect(Collectors.toList());
    }
    //metodo para transformar em dto
    public CompanyResponseDto toResponseDto(CompanyModel companyModel){
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setCnpj(companyModel.getCnpj());
        companyResponseDto.setUsername(companyModel.getUsername());
        companyResponseDto.setEmail(companyModel.getEmail());
        return companyResponseDto;
    }
    //find by id
    public CompanyResponseDto findById(UUID id){
        CompanyModel company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        return toResponseDto(company);
    }
    //save company
    public CompanyResponseDto save(CompanyRequestDto companyRequestDTO){
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCnpj(companyRequestDTO.getCnpj());
        companyModel.setUsername(companyRequestDTO.getUsername());
        companyModel.setEmail(companyRequestDTO.getEmail());
        var a =  companyRepository.save(companyModel);
        return toResponseDto(a);
    }

    //alter company
    public CompanyResponseDto update(UUID id, CompanyRequestDto companyRequestDTO){
        CompanyModel company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        toResponseDto(company);
        CompanyResponseDto cp = save(companyRequestDTO);
        return cp;
    }
}
