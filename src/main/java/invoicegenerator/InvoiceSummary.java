package invoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class InvoiceSummary {
    private final double numberOfRides;
    private final double totalFare;
    private final double averageFare;

    //constructor
    public InvoiceSummary(int fare, double rides) {
        this.numberOfRides = rides;
        this.totalFare = fare;
        this.averageFare = this.totalFare/ this.numberOfRides;

    }
    /*
    * taking multiple rides with userID
    * store list of multiple rides
    * */
    Map<Integer, InvoiceSummary> userId = new HashMap<>();

    public Map<Integer, InvoiceSummary> getUserId() {
        return userId;
    }

    public void setUserId(int id, InvoiceSummary summary) {
        this.userId = userId;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return Double.compare(summary.numberOfRides, numberOfRides) == 0 && totalFare == summary.totalFare && Double.compare(summary.averageFare, averageFare) == 0;
    }



}
