package com.shina.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shina.springdemo.dao.OrganizationDao;
import com.shina.springdemo.domain.Organization;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;
	
	public List<Organization> getOrganization(){
		List<Organization> orgList = organizationDao.getAllOrganizations();
		return orgList;
	}
}
