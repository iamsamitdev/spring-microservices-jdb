package com.itgenius.organizationservice.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itgenius.organizationservice.organization.model.Organization;
import com.itgenius.organizationservice.organization.repository.OrganizationRepository;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    // find all organizations
    public List<Organization> findAllOrganization() {
        return organizationRepository.findAll();
    }

    // find organization by id
    public Organization findOrganizationById(int id) {
        return organizationRepository.findById(id).orElse(null);
    }

    // add new organization
    public Organization addNewOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    // update organization
    public Organization updateOrganization(Integer id, Organization updateOrganization) {
        if(organizationRepository.existsById(id)) {
            updateOrganization.setId(id);
            return organizationRepository.save(updateOrganization);
        } else {
            throw new RuntimeException("Organization not found for id: " + id);
        }
    }

    // delete organization
    public void deleteOrganization(Integer id) {
        if(organizationRepository.existsById(id)) {
            organizationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Organization not found for id: " + id);
        }
    }

}
