package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {
    private List<Company> generateDate()
    {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        List<Company> theListCompanies = new ArrayList<>();
        theListCompanies.add(softwareMachine);
        theListCompanies.add(dataMaesters);
        theListCompanies.add(greyMatter);
        return theListCompanies;
    }
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {

        //Given
        List<Company> listCompanies = generateDate();

        //When
        companyDao.save(listCompanies.get(0));
        int softwareMachineId = listCompanies.get(0).getId();
        companyDao.save(listCompanies.get(1));
        int dataMaestersId = listCompanies.get(1).getId();
        companyDao.save(listCompanies.get(2));
        int greyMatterId = listCompanies.get(2).getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            System.out.println("NIE KASUJE");
        }
    }
    @Test
    void testfindAnEmployee(){

            //Given
        List<Company> listCompanies = generateDate();

            //When
        companyDao.save(listCompanies.get(0));
        int softwareMachineId = listCompanies.get(0).getId();
        companyDao.save(listCompanies.get(1));
        int dataMaestersId = listCompanies.get(1).getId();
        companyDao.save(listCompanies.get(2));
        int greyMatterId = listCompanies.get(2).getId();

        List<Employee> findAnEmployee = employeeDao.findAnEmployee("Smith");
        System.out.println("ilość rekordów findAnEmployee=  "+findAnEmployee.size());

             //Then
        assertEquals(1, findAnEmployee.size());

            //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(greyMatterId);
            companyDao.deleteById(dataMaestersId);

        } catch (Exception e){
            System.out.println("Nie kasuje");
        }

    }
    @Test
    void testFindACompany(){

            //Given
        List<Company> listCompanies = generateDate();

            //When
        companyDao.save(listCompanies.get(0));
        int softwareMachineId = listCompanies.get(0).getId();
        companyDao.save(listCompanies.get(1));
        int dataMaestersId = listCompanies.get(1).getId();
        companyDao.save(listCompanies.get(2));
        int greyMatterId = listCompanies.get(2).getId();

        List<Company> findACompany = companyDao.findACompany("Sof%");
        System.out.println("FindACompany size = "+findACompany.size());

            //Then
        assertEquals(1, findACompany.size());

            //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        }catch (Exception e) {
            System.out.println("Nie kasuje");
        }
    }
}

