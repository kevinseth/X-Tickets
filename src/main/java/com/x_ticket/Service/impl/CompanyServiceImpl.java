package com.x_ticket.Service.impl;

import com.x_ticket.Model.Company;
import com.x_ticket.Repository.CompanyRepository;
import com.x_ticket.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(String id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(String id, Company companyDetails) {
        Company company = companyRepository.findById(id).orElseThrow();
        // Update company details
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(String id) {
        companyRepository.deleteById(id);
    }
}
