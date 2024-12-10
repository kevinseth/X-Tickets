package com.x_ticket.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.x_ticket.Model.Company;
import com.x_ticket.Repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public List<Company> getCompaniesByOwnerId(String ownerId) {
        return companyRepository.findCompaniesByOwnerId(ownerId);
    }

    public Long countCompaniesByOwnerId(String ownerId) {
        return companyRepository.countCompaniesByOwnerId(ownerId);
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, Company companyDetails) {
        Company company = companyRepository.findById(id).orElseThrow();
        // Update company details
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}