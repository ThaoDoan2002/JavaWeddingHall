/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WeddingHall;

import Bill.Bill;
import com.mycompany.btl.GeneralConfiguration;
import com.mycompany.btl.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import MyInterface.IInput;
import MyInterface.IShow;

/**
 *
 * @author Admin
 */
public class WeddingHall implements IInput, IShow {

    //Attribute
    private static int count;
    private String whId;
    private String whName;
    private int location;
    private int capacity;
    private String time;
    private List<Bill> bill;

    {
        whId = String.format("S%03d", ++count);
    }

    // Constructor
    public WeddingHall() {
        this.bill = new ArrayList<Bill>();
    }

    public WeddingHall(String whName, int location, int capacity, String time) throws Exception {
        this.whName = whName;

        if (location != 1 && location != 2) {
            throw new Exception("Error! Just have 2 floors!");
        }
        this.location = location;
        this.capacity = capacity;
        this.time = time;
        this.bill = new ArrayList<Bill>();
    }

    @Override
    public void input() {
        int floor;
        System.out.println("\nEnter wedding hall name: ");
        this.whName = GeneralConfiguration.sc.nextLine();
        System.out.println("Enter time to know rent cost hall wedding. Example (Morning weekend): ");
        this.time = GeneralConfiguration.sc.nextLine();
        do {
            System.out.println("Enter location (1 OR 2): ");
            floor = Integer.parseInt(GeneralConfiguration.sc.nextLine());
        } while (floor != 1 && floor != 2);
        this.location = floor;
        System.out.println("Enter capacity: ");
        this.capacity = Integer.parseInt(GeneralConfiguration.sc.nextLine());

    }

    @Override
    public void show() {
        System.out.printf("Wedding hall id: %s\t"
                + "Wedding hall name: %s\t"
                + "Wedding hall location: %d floor\t"
                + "Wedding hall capacity: %d table\t"
                + "Wedding hall rental time: %s\t"
                + "Wedding hall rent cost: %,.1f\n",
                this.whId, this.whName, this.location, this.capacity, this.time, this.rentCostOfWeddingHall());
    }

    public double rentCostOfWeddingHall() {
        double rentCost = 0;
        if (this.time.equalsIgnoreCase("morning weekend")) {
            rentCost = Time.MORNING_WEEKEND.calculateRentCost();
        } else if (this.time.equalsIgnoreCase("morning weekday")) {
            rentCost = Time.MORNING_WEEKDAY.calculateRentCost();
        } else if (this.time.equalsIgnoreCase("afternoon weekend")) {
            rentCost = Time.AFTERNOON_WEEKEND.calculateRentCost();
        } else if (this.time.equalsIgnoreCase("afternoon weekday")) {
            rentCost = Time.AFTERNOON_WEEKDAY.calculateRentCost();
        } else if (this.time.equalsIgnoreCase("evening weekend")) {
            rentCost = Time.EVENING_WEEKEND.calculateRentCost();
        } else if (this.time.equalsIgnoreCase("evening weekday")) {
            rentCost = Time.EVENING_WEEKDAY.calculateRentCost();
        }
        return rentCost;
    }

    public int quantityRentOfWeddingHall(int year) {
        return this.getBill().stream().filter(x -> x.getDateRent().getYear() == year - 1900).collect(Collectors.toList()).size();
    }

 

    public void showForSortQuantityWeddingHall(int year) {
        System.out.printf("Wedding name: %s\n", this.whName);
        System.out.printf("Quantity of rent Wedding hall: %d\n", this.quantityRentOfWeddingHall(year));

    }

    //Getter setter
    /**
     * @return the whId
     */
    public String getWhId() {
        return whId;
    }

    /**
     * @return the whName
     */
    public String getWhName() {
        return whName;
    }

    /**
     * @param whName the whName to set
     */
    public void setWhName(String whName) {
        this.whName = whName;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the location
     */
    public int getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(int location) throws Exception {
        if (location != 1 && location != 2) {
            throw new Exception("Error! Just have 2 floors");
        }
        this.location = location;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the bill
     */
    public List<Bill> getBill() {
        return bill;
    }

    /**
     * @param bill the bill to set
     */
    public void setBill(List<Bill> bill) {
        this.bill = bill;
    }

}
