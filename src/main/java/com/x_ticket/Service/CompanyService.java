package com.x_ticket.Service;

import com.x_ticket.Model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(String id);
    Company createCompany(Company company);
    Company updateCompany(String id, Company companyDetails);
    void deleteCompany(String id);
}
