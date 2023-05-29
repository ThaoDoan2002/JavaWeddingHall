/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import com.mycompany.btl.GeneralConfiguration;

/**
 *
 * @author Admin
 */
public class Drink extends Dish {

    //Attribute
    private String manufacturer;

    //Constructor
    public Drink() {

    }

    public Drink(String dishName, double dishPrice, String manufacturer) {
        super(dishName, dishPrice);
        this.manufacturer = manufacturer;
    }

    @Override
    public void input() {
        System.out.println("Enter dish name: ");
        this.dishName = GeneralConfiguration.sc.nextLine();
        System.out.println("Enter dish price: ");
        this.dishPrice = Double.parseDouble(GeneralConfiguration.sc.nextLine());
        System.out.println("Enter manufacturer: ");
        this.manufacturer = GeneralConfiguration.sc.nextLine();
    }

    @Override
    public void show() {
        System.out.printf("Dish id: %d\t"
                + "Dish name: %s\t"
                + "Dish price: %,.1f\t", this.dishId, this.dishName, this.dishPrice);
        System.out.printf("Manufacturer: %s\n", this.manufacturer);

    }

    //Getter setter
    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
