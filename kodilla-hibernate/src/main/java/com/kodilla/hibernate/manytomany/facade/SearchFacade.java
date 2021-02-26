package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private final CompanyDao companyDao;

    private final EmployeeDao employeeDao;

    @Autowired
    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao){
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }
    public List<Company> SearchCompany(String name ) throws SearchCompanyFacadeException{
        List<Company> listCompany = companyDao.findACompany(name);
        if (listCompany.size() == 0) {
            return listCompany;
        }else{ throw new SearchCompanyFacadeException();}
    }
    public List<Employee>  SearchEmployee(String name) throws SearchEmployeeFacadeException{
        List<Employee> employeeList = employeeDao.findEmployeeByName(name);
        if (employeeList.size() == 0) {
            return employeeList;
        } else { throw new SearchEmployeeFacadeException();}
    }
}
