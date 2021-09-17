package facades;

import entities.Employee;
import utils.EMF_Creator;
import entities.RenameMe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class EmployeeFacadeTest {

    private static EntityManagerFactory emf;
    private static EmployeeFacade facade;

    public EmployeeFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = EmployeeFacade.getEmployeeFacade(emf);
        }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

//     Setup the DataBase in a known state BEFORE EACH TEST
//    TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test");
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(new Employee("xa12tt", "Kurt", "Wonnegut",335567));
//            em.persist(new Employee("hyu654", "Hanne", "Olsen", 435867));
//            em.persist(new Employee("uio876", "Jan", "Olsen", 411567));
//            em.persist(new Employee("klo999", "Irene", "Petersen", 33567));
//            em.persist(new Employee("jik666", "Tian", "Wonnegut", 56567));
//            em.persist(new Employee("jkbadl", "Alex", "mich", 20));
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//            emf.close();
//        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

//    // TODO: Delete or change this method
//    @Test
//    public void testAhigestSalery() throws Exception {
//        assertEquals(435867, facade.higestSalery(), "Highest salary should be 435867");
//    }
//
//    @Test
//    public void testAAllFirstNames() throws Exception {
//        List<String> expected = Arrays.asList("Hanne", "Tian", "Irene", "Jan", "Kurt");
//        assertEquals(expected, facade.getAllFirstNames());
//    }
//
//    @Test
//    public void testhowManyEmployees() throws Exception {
//        assertEquals(5, facade.howManyEmployees());
//    }

//    @Test
//    public void testAgetAllRichEmployee() throws Exception {
//        Vector<String> expected = new Vector<String>();
//        expected.add("hyu654");
//        expected.add("Hanne");
//        expected.add("uio876");
//        expected.add("Jan");
//        expected.add("xa12tt");
//        expected.add("Kurt");
//        assertEquals(expected, facade.getAllRichEmployee());
//    }

//    @Test
//    public void testAgetEmployeeById() throws Exception {
//        String expected = "klo999, Irene";
//        assertEquals(expected, facade.getEmployeeById("klo999"));
//    }

//    @Test
//    public void testdetailsOnHigestSalery() throws Exception {
//
//        assertEquals(5, facade.detailsOnHigestSalery());
//    }
}
