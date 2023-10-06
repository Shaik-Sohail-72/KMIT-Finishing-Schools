// CarType enum
enum CarType {
    SUV, SEDAN, LUXURY, HATCHBACK, OTHER
}

// Car class
class Car {
    String model;
    CarType type;
    int manufacturingYear;
    double price;

    public Car(String model, CarType type, int manufacturingYear, double price) {
        this.model = model;
        this.type = type;
        this.manufacturingYear = manufacturingYear;
        this.price = price;
    }
}

// InsurancePolicy abstract base class
abstract class InsurancePolicy {
    String policyHolderName;
    int id;
    Car car;
    int numberOfClaims;

    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims) {
        this.policyHolderName = policyHolderName;
        this.id = id;
        this.car = car;
        this.numberOfClaims = numberOfClaims;
    }

    public abstract void calcPayment(double flatRate);

    public void print() {
        System.out.println("Policy Holder: " + policyHolderName);
        System.out.println("Policy ID: " + id);
        System.out.println("Car Model: " + car.model);
        System.out.println("Number of Claims: " + numberOfClaims);
    }
}

// ThirdPartyPolicy class
class ThirdPartyPolicy extends InsurancePolicy {
    String comments;

    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, String comments) {
        super(policyHolderName, id, car, numberOfClaims);
        this.comments = comments;
    }

    @Override
    public void calcPayment(double flatRate) {
        double premium = car.price / 100 + numberOfClaims * 200 + flatRate;
        System.out.println("Premium Payment: " + premium);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Comments: " + comments);
    }

    @Override
    public String toString() {
        return "Third Party Policy: " + policyHolderName + ", ID: " + id;
    }
}

// ComprehensivePolicy class
class ComprehensivePolicy extends InsurancePolicy {
    int driverAge;
    int level;

    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, int driverAge, int level) {
        super(policyHolderName, id, car, numberOfClaims);
        this.driverAge = driverAge;
        this.level = level;
    }

    @Override
    public void calcPayment(double flatRate) {
        double premium = car.price / 50 + numberOfClaims * 200 + flatRate;
        if (driverAge < 30) {
            premium += (30 - driverAge) * 50;
        }
        System.out.println("Premium Payment: " + premium);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Driver Age: " + driverAge);
        System.out.println("Level: " + level);
    }

    @Override
    public String toString() {
        return "Comprehensive Policy: " + policyHolderName + ", ID: " + id;
    }
}

// Test code
public class Main {
    public static void main(String[] args) {
        final double flatRate = 1000.0; // Example flat rate

        Car car1 = new Car("Honda Civic", CarType.SEDAN, 2020, 20000.0);
        Car car2 = new Car("BMW X5", CarType.SUV, 2019, 60000.0);

        ThirdPartyPolicy thirdPartyPolicy = new ThirdPartyPolicy("John Doe", 1, car1, 2, "Basic coverage");
        ComprehensivePolicy comprehensivePolicy = new ComprehensivePolicy("Jane Smith", 2, car2, 1, 25, 3);

        thirdPartyPolicy.print();
        thirdPartyPolicy.calcPayment(flatRate);

        System.out.println();

        comprehensivePolicy.print();
        comprehensivePolicy.calcPayment(flatRate);

        InsurancePolicy[] policies = {thirdPartyPolicy, comprehensivePolicy};

        double totalPremium = 0.0;
        for (InsurancePolicy policy : policies) {
            totalPremium += policy.car.price / 50 + policy.numberOfClaims * 200 + flatRate;
            if (policy instanceof ComprehensivePolicy) {
                if (((ComprehensivePolicy) policy).driverAge < 30) {
                    totalPremium += (30 - ((ComprehensivePolicy) policy).driverAge) * 50;
                }
            }
        }

        System.out.println("\nTotal Premium Payment: " + totalPremium);
    }
}
