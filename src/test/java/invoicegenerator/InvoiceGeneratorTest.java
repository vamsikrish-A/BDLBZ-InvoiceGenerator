package invoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(0, fare, 0.0);

    }

    @Test
    public void givenDistanceAndTime_ShouldReturnActualTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);

    }
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(0.0, 0),
                new Ride(0.0, 1)
        };
        InvoiceSummary fare = invoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(0.0, fare, String.valueOf(0.0));

    }
    @Test
    public void givenMultipleRides_ShouldReturnMultipleRaidsTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary fare = invoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(30, fare, String.valueOf(0.0));

    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(0.0, 0),
                new Ride(0.0, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(0, 0.0);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryEquals() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
    @Test
    public void getsTheListOfRides_UsingUserID() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary id = new InvoiceSummary(2, 30.0);
        id.setUserId(1, summary);
        Map<Integer, InvoiceSummary> userID = new HashMap<>();
        for (Map.Entry<Integer, InvoiceSummary> integerInvoiceSummaryEntry : userID.entrySet()) {
            integerInvoiceSummaryEntry.getValue();
        }

        Assertions.assertEquals(userID, id.getUserId());
    }

    @Test
    public void givesPremiumRates_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 2;
        double premiumFare = invoiceGenerator.calculatePremiumFare(distance, time);
        Assertions.assertEquals(20, premiumFare,0.0);
    }
}