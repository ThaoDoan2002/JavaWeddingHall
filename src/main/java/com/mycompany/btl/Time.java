/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.btl;

/**
 *
 * @author Admin
 */
public enum Time {
    MORNING_WEEKEND(10000000,2000000),
    AFTERNOON_WEEKEND(15000000,2000000),
    EVENING_WEEKEND(20000000,2000000),
    MORNING_WEEKDAY(10000000,1000000),
    AFTERNOON_WEEKDAY(15000000,1000000),
    EVENING_WEEKDAY(20000000,1000000);

    private final double price;
    private final double priceSpecial;
    

    private Time(double price,double priceSpecial) {
        this.price = price;
        this.priceSpecial = priceSpecial;
    }
    
    public double calculateRentCost(){
        return this.price + this.priceSpecial;
    }
    
    

   

}
