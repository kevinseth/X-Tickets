package com.x_ticket.Controller;

import com.x_ticket.Model.Company;
import com.x_ticket.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable String id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable String id, @RequestBody Company companyDetails) {
        return companyService.updateCompany(id, companyDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable String id) {
        companyService.deleteCompany(id);
    }
}
