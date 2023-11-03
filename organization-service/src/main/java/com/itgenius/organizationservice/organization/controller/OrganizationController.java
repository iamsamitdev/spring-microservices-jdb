package com.itgenius.organizationservice.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itgenius.organizationservice.organization.model.Organization;
import com.itgenius.organizationservice.organization.service.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    // find all organizations
    @GetMapping
    public List<Organization> findAllOrganization() {
        return organizationService.findAllOrganization();
    }

    // find organization by id
    @GetMapping("/{id}")
    public Organization findOrganizationById(@PathVariable Integer id) {
        return organizationService.findOrganizationById(id);
    }

    // add new organization
    @PostMapping
    public Organization addNewOrganization(Organization organization) {
        return organizationService.addNewOrganization(organization);
    }

    // update organization
    @PutMapping("/{id}")
    public Organization updateOrganization(@PathVariable Integer id, Organization updateOrganization) {
        return organizationService.updateOrganization(id, updateOrganization);
    }

    // delete organization
    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Integer id) {
        organizationService.deleteOrganization(id);
    }

}
