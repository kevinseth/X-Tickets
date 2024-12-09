package com.x_ticket.Repository;

import com.x_ticket.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
