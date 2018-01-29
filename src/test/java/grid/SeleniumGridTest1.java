package grid;

import org.testng.annotations.Test;

public class SeleniumGridTest1 extends TestSuiteBase {


    @Test
    public void searchFlights() {
        search.clickFlightsTab();
        search.setOriginCity("New York");
        search.setDestinationCity("Chicago");
        search.setDepartureDate("10/28/2018");
        search.setReturningDate("11/31/2018");
        search.clickSearchButton();
    }


}
