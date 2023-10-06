import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

class MyDate {
    int year;
    int month;
    int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class Address {
    int streetNum;
    String street;
    String suburb;
    String city;

    public Address(int streetNum, String street, String suburb, String city) {
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }
}

class Car {
    private String model;
    private double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void priceRise(double rise) {
        this.price *= (1 + rise);
    }
}

class InsurancePolicy {
    private int policyID;
    private String policyHolderName;
    private Car car;
    private MyDate expiryDate;

    public InsurancePolicy(int policyID, String policyHolderName, Car car, MyDate expiryDate) {
        this.policyID = policyID;
        this.policyHolderName = policyHolderName;
        this.car = car;
        this.expiryDate = expiryDate;
    }

    public int getPolicyID() {
        return policyID;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public Car getCar() {
        return car;
    }

    public MyDate getExpiryDate() {
        return expiryDate;
    }

    public void setPolicyHolderName(String newName) {
        this.policyHolderName = newName;
    }

    public static void printPolicies(ArrayList<InsurancePolicy> policies) {
        for (InsurancePolicy policy : policies) {
            System.out.println("Policy ID: " + policy.getPolicyID());
            System.out.println("Policy Holder: " + policy.getPolicyHolderName());
            System.out.println("Car Model: " + policy.getCar().getModel());
            System.out.println("Expiry Date: " + policy.getExpiryDate().year + "-" + policy.getExpiryDate().month + "-" + policy.getExpiryDate().day);
            System.out.println();
        }
    }

    public static double calcTotalPayments(ArrayList<InsurancePolicy> policies, int flatRate) {
        double totalPayments = 0.0;
        for (InsurancePolicy policy : policies) {
            totalPayments += flatRate; // Assuming flatRate is the same for all policies
        }
        return totalPayments;
    }

    public void carPriceRise(double risePercent) {
        car.priceRise(risePercent);
    }

    public static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent) {
        for (InsurancePolicy policy : policies) {
            policy.carPriceRise(risePercent);
        }
    }

    public static ArrayList<InsurancePolicy> filterByCarModel(ArrayList<InsurancePolicy> policies, String carModel) {
        ArrayList<InsurancePolicy> filteredPolicies = new ArrayList<>();
        for (InsurancePolicy policy : policies) {
            if (policy.getCar().getModel().equalsIgnoreCase(carModel)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }
}

class User {
    private String name;
    private int userID;
    private Address address;
    private ArrayList<InsurancePolicy> policies;

    public User(String name, int userID, Address address) {
        this.name = name;
        this.userID = userID;
        this.address = address;
        this.policies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<InsurancePolicy> getPolicies() {
        return policies;
    }

    public boolean addPolicy(InsurancePolicy policy) {
        for (InsurancePolicy existingPolicy : policies) {
            if (existingPolicy.getPolicyID() == policy.getPolicyID()) {
                return false; // Policy with the same ID already exists
            }
        }
        policies.add(policy);
        return true;
    }

    public InsurancePolicy findPolicy(int policyID) {
        for (InsurancePolicy policy : policies) {
            if (policy.getPolicyID() == policyID) {
                return policy;
            }
        }
        return null; // Policy not found
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("User ID: " + userID);
        System.out.println("Address: " + address.streetNum + " " + address.street + ", " + address.suburb + ", " + address.city);
        System.out.println("Policies:");
        InsurancePolicy.printPolicies(policies);
    }

    public String toString() {
        String userInfo = "Name: " + name + "\nUser ID: " + userID + "\nAddress: " + address.streetNum + " " + address.street + ", " + address.suburb + ", " + address.city + "\n";
        String userPolicies = "Policies:\n";
        for (InsurancePolicy policy : policies) {
            userPolicies += "Policy ID: " + policy.getPolicyID() + ", Car Model: " + policy.getCar().getModel() + ", Expiry Date: " + policy.getExpiryDate().year + "-" + policy.getExpiryDate().month + "-" + policy.getExpiryDate().day + "\n";
        }
        return userInfo + userPolicies;
    }

    public void printPolicies(int flatRate) {
        InsurancePolicy.printPolicies(policies);
        double totalPayments = InsurancePolicy.calcTotalPayments(policies, flatRate);
        System.out.println("Total Premium Payments: $" + totalPayments);
    }

    public double calcTotalPremiums(int flatRate) {
        return InsurancePolicy.calcTotalPayments(policies, flatRate);
    }

    public void carPriceRiseAll(double risePercent) {
        InsurancePolicy.carPriceRiseAll(policies, risePercent);
    }

    public ArrayList<InsurancePolicy> filterByCarModel(String carModel) {
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }
}

public class MainCar2 {
    public static void main(String[] args) {
        // Create MyDate objects
        MyDate expiry1 = new MyDate(2023, 11, 30);
        MyDate expiry2 = new MyDate(2024, 5, 15);

        // Create Address objects
        Address address1 = new Address(123, "Main St", "Suburb1", "City1");
        Address address2 = new Address(456, "Oak Ave", "Suburb2", "City2");

        // Create Car objects
        Car car1 = new Car("Toyota Camry 2018", 20000);
        Car car2 = new Car("Honda Civic 2020", 25000);

        // Create InsurancePolicy objects
        InsurancePolicy policy1 = new InsurancePolicy(1, "John Doe", car1, expiry1);
        InsurancePolicy policy2 = new InsurancePolicy(2, "Jane Doe", car2, expiry2);

        // Create User object
        User user = new User("Alice", 1001, address1);

        // Add policies to user
        user.addPolicy(policy1);
        user.addPolicy(policy2);

        // Print user information
        user.print();

        // Find a policy (invalid ID)
        InsurancePolicy invalidPolicy = user.findPolicy(3);
        if (invalidPolicy == null) {
            System.out.println("Policy has not been found");
        }

        // Find a policy (valid ID)
        InsurancePolicy validPolicy = user.findPolicy(1);
        if (validPolicy != null) {
            System.out.println("\nPolicy found:");
            validPolicy.carPriceRise(0.1); // Increase car price
            validPolicy.printPolicies(100); // Print policy details
            validPolicy.setPolicyHolderName("Robert"); // Change policy holder name
        }

        // Change city of user
        user.getAddress().city = "Wollongong";

        // Change user's address with user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter new address details:");
        System.out.print("Street Number: ");
        int newStreetNum = scanner.nextInt();
        System.out.print("Street: ");
        String newStreet = scanner.next();
        System.out.print("Suburb: ");
        String newSuburb = scanner.next();
        System.out.print("City: ");
        String newCity = scanner.next();
        user.getAddress().setAddress(newStreetNum, newStreet, newSuburb, newCity);

        // Print updated user information
        user.print();

        // Print total premium payments
        double totalPayments = user.calcTotalPremiums(100);
        System.out.println("\nTotal Premium Payments: $" + totalPayments);

        // Add 10% to car prices
        user.carPriceRiseAll(0.1);

        // Print updated total premium payments
        totalPayments = user.calcTotalPremiums(100);
        System.out.println("\nUpdated Total Premium Payments: $" + totalPayments);

        // Filter policies by car model
        System.out.print("\nEnter a car model to filter policies: ");
        String carModel = scanner.next();
        ArrayList<InsurancePolicy> filteredPolicies = user.filterByCarModel(carModel);
        InsurancePolicy.printPolicies(filteredPolicies);
    }
}
