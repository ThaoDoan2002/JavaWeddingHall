/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;


/**
 *
 * @author Admin
 */
public abstract class Dish {

    //Attribute
    private static int count;
    protected int dishId = ++count;
    protected String dishName;
    protected double dishPrice;

    //Constructor
    public Dish() {
        
    }

    public Dish(String dishName, double dishPrice) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }


    //Abstract method
    public abstract void input();

    public abstract void show();

    
    //Getter setter
    /**
     * @return the dishId
     */
    public int getDishId() {
        return dishId;
    }

    /**
     * @return the dishName
     */
    public String getDishName() {
        return dishName;
    }

    /**
     * @param dishName the dishName to set
     */
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    /**
     * @return the dishPrice
     */
    public double getDishPrice() {
        return dishPrice;
    }

    /**
     * @param dishPrice the dishPrice to set
     */
    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

}
