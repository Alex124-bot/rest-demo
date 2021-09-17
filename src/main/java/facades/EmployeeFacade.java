package facades;

import com.google.gson.Gson;
import entities.Employee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private EmployeeFacade() {}


    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    //1) Create a query to fetch all employees with a salary > 100000 and print out all the salaries
    public List getAllRichEmployee() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Integer> typedquery = em.createQuery("SELECT e FROM Employee e WHERE e.salary > 100000", Integer.class);

            em.getTransaction().commit();

            return typedquery.getResultList();

        } finally {
            em.close();
        }

    }

    //2) Create a query to fetch the employee with the id "klo999" and print out the firstname
    public Employee getEmployeeById(String id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select e FROM Employee e WHERE e.id = :id");
            query.setParameter("id", id);
            Employee result2 = (Employee)query.getSingleResult();
            em.getTransaction().commit();

            return result2;

        } finally {
            em.close();
        }
    }

    //3) Create a query to fetch the highest salary and print the value
    public int higestSalery() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Integer> typedquery = em.createQuery("select max(e.salary) from Employee e", Integer.class);
            int result3 = typedquery.getSingleResult();
            em.getTransaction().commit();
            return result3;

        } finally {
            em.close();
        }
    }

    //4) Create a query to fetch the firstName of all Employees and print the names

    public List<String> getAllFirstNames() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("Select e.firstName FROM Employee e");
            List<String> result4 = query.getResultList();
            em.getTransaction().commit();
            return result4;

        } finally {
            em.close();
        }
    }

    //5 Create a query to calculate the number of employees and print the number

    public Long howManyEmployees()
    {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT count(e) From Employee e");

            Long count = (Long) query.getSingleResult();

            em.getTransaction().commit();

            return count;

        } finally {
            em.close();
        }
    }

    //6 Create a query to fetch the Employee with the higest salary and print all his details

    public Employee detailsOnHigestSalery()
    {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Employee> typedquery = em.createQuery("select e from Employee e where e.salary = (select max(e.salary) from Employee e)", Employee.class);
            Employee result5 = typedquery.getSingleResult();
            em.getTransaction().commit();
            return result5;

        } finally {
            em.close();
        }
    }


    public void getTestData() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Employee("xa12tt", "Kurt", "Wonnegut", 335567));
            em.persist(new Employee("hyu654", "Hanne", "Olsen",435867));
            em.persist(new Employee("uio876", "Jan", "Olsen", 411567));
            em.persist(new Employee("klo999", "Irene", "Petersen", 33567));
            em.persist(new Employee("jik666", "Tian", "Wonnegut", 56567));
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
//
        try {
            EmployeeFacade test = new EmployeeFacade();
//            test.getTestData();
//            Gson gson = new Gson();
//
//            System.out.println(test.getAllRichEmployee());
//
//            System.out.println(test.getEmployeeById("klo999"));
//
//            System.out.println(test.higestSalery());
//
//            System.out.println(test.getAllFirstNames());
//
//            System.out.println(test.howManyEmployees());
//
//            System.out.println(test.detailsOnHigestSalery());
//
//
        } catch (Exception e) {
            e.printStackTrace();
        }
//
    }
}
