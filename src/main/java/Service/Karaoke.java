/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import com.mycompany.btl.GeneralConfiguration;

/**
 *
 * @author Admin
 */
public class Karaoke extends Service {

    //Attribute
    private double rentPeriod;

    //Constructor
    public Karaoke() {
    }
    
    

    public Karaoke(String serviceName, double servicePrice, double rentPeriod) {
        super(serviceName, servicePrice);
        this.rentPeriod = rentPeriod;
    }

    @Override
    public void input() {
        System.out.println("Enter service name: ");
        this.serviceName = GeneralConfiguration.sc.nextLine();
        System.out.println("Enter service price: ");
        this.servicePrice = Double.parseDouble(GeneralConfiguration.sc.nextLine());
        System.out.println("Enter rentPeriod: ");
        this.rentPeriod = Double.parseDouble(GeneralConfiguration.sc.nextLine());
    }

    @Override
    public void show() {
        System.out.printf("Service id: %d\t"
                + "Service name: %s\t"
                + "Service price: %,.1f\t"
                + "rentPeriod: %.1f hours\n", this.serviceId, this.serviceName, this.servicePrice,this.rentPeriod);
    }

    //Getter setter
    /**
     * @return the rentPeriod
     */
    public double getRentPeriod() {
        return rentPeriod;
    }

    /**
     * @param rentPeriod the rentPeriod to set
     */
    public void setRentPeriod(double rentPeriod) {
        this.rentPeriod = rentPeriod;
    }

}
