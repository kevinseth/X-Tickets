package com.x_ticket.Repository;

import com.x_ticket.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Custom JPQL Query: Find companies by ownerId
    @Query("SELECT c FROM Company c WHERE c.ownerId = :ownerId")
    List<Company> findCompaniesByOwnerId(@Param("ownerId") String ownerId);

    // Custom JPQL Query: Count companies by ownerId
    @Query("SELECT COUNT(c) FROM Company c WHERE c.ownerId = :ownerId")
    Long countCompaniesByOwnerId(@Param("ownerId") String ownerId);
}