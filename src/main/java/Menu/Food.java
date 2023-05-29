/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Menu.Dish;
import com.mycompany.btl.GeneralConfiguration;

/**
 *
 * @author Admin
 */
public class Food extends Dish {

    //Attribute
    private boolean isVegetarian;

    //Constructor
    public Food() {

    }

    public Food(String dishName, double dishPrice, boolean isVegetarian) {
        super(dishName, dishPrice);
        this.isVegetarian = isVegetarian;
    }

    @Override
    public void input() {
        String s;
        System.out.println("Enter dish name: ");
        this.dishName = GeneralConfiguration.sc.nextLine();
        System.out.println("Enter dish price: ");
        this.dishPrice = Double.parseDouble(GeneralConfiguration.sc.nextLine());
        do {
            System.out.println("Enter Is it vegetarian (True or False): ");
            s = GeneralConfiguration.sc.nextLine();
        } while (s.equalsIgnoreCase("true")!=true && s.equalsIgnoreCase("false")!=true);
        this.isVegetarian = Boolean.parseBoolean(s);


    }

    @Override
    public void show() {
        System.out.printf("Dish id: %d\t"
                + "Dish name: %s\t"
                + "Dish price: %,.1f\t", this.dishId, this.dishName, this.dishPrice);
        System.out.printf("Is vegetarian: %s\n", this.isVegetarian);
    }

    //Setter getter
    /**
     * @return the isVegetarian
     */
    public boolean isIsVegetarian() {
        return isVegetarian;
    }

    /**
     * @param isVegetarian the isVegetarian to set
     */
    public void setIsVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

}
