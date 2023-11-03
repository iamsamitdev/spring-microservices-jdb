package com.itgenius.organizationservice.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itgenius.organizationservice.organization.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    
}
