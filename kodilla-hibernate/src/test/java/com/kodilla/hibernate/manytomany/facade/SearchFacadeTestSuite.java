package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SearchFacadeTestSuite {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private SearchFacade searchFacade;

    @Test
    void TestSearchFacadeEmployee(){
        //GIVEN
        Employee employee1 = new Employee("Adam", "Kowalski");
        Employee employee2 = new Employee("Bartosz", "Nowak");
        Employee employee3 = new Employee("Cezary", "Rowalski");
        //WHEN
        employeeDao.save(employee1);
        int id1= employee1.getId();
        employeeDao.save(employee2);
        int id2= employee2.getId();
        employeeDao.save(employee3);
        int id3= employee3.getId();
        //THEN
        try {
            List<Employee> list = searchFacade.SearchEmployee("%walski%");
            assertEquals(2 , list.size() );
        } catch (SearchEmployeeFacadeException e) {

        }
        //CLEAN UP
        employeeDao.deleteById(id1);
        employeeDao.deleteById(id2);
        employeeDao.deleteById(id3);
    }

    @Test
    void TestSearchFacadeCompany(){
        //GIVEN
        Company company1 = new Company("MicroTV");
        Company company2 = new Company("MacroTV");
        Company company3 = new Company("BigTV");
        //WHEN
        companyDao.save(company1);
        int id1 = company1.getId();
        companyDao.save(company2);
        int id2 = company2.getId();
        companyDao.save(company3);
        int id3 = company3.getId();
        //THEN
        try{
            List<Company> list = searchFacade.SearchCompany("%TV%");
            assertEquals(3 , list.size() );
        } catch (SearchCompanyFacadeException e) {

        }
        //CLEAN UP
        companyDao.deleteById(id1);
        companyDao.deleteById(id2);
        companyDao.deleteById(id3);
    }
}
