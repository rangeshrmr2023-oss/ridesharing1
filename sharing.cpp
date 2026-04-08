public class PricingService {

    public double calculateFare(double baseFare, double demandSupplyRatio, double distance, int hour) {
        double surge = 1.0;

        if (demandSupplyRatio > 1.5) {
            surge += 1.0;
        }

        if ((hour >= 8 && hour <= 10) || (hour >= 18 && hour <= 21)) {
            surge += 0.5;
        }

        if (distance > 10) {
            surge += 0.3;
        }

        return baseFare * surge;
    }
}