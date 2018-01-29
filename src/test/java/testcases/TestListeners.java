package testcases;


import listeners.CustomListener1;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListener1.class)
public class TestListeners {

    @BeforeClass
    public void setUp() {
        System.out.println("Code in before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("Code in after class");
    }

    @Test
    public void test1() {
        System.out.println("Code in test1");
    }

    @Test
    public void test2() {
        System.out.println("Code in test2");
    }
}
