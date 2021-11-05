package invoicegenerator;
/*
* @purpose: Cab Invoice Generator, where the customer books the cab pays at end of month
* @since: 05-nov
* @author: Vamsi Krishna
* */

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5.0;
    private static final double PREMIUM_COST_PER_KM = 15.0;
    private static final int PREMIUM_COST_PER_MINUTE = 2;
    private static final double MINIMUM_PREMIUM_FARE = 20;

    /*
    * Method calculating Fare for the given distance and time
    * @params: given distance and time, costPerKm, CostPerTime
    *  */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    /*
    * calculated fare for multiple rides gives fare
    * refactored  for calculating fare for invoice summary with multiple rides
    * */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare =0;
        for (Ride ride: rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);

        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /*
    * method for calculating premium fare for premium rates (bonus)*/
    public double calculatePremiumFare(double distance, int time) {
        double totalFare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_PREMIUM_FARE);
    }
}
