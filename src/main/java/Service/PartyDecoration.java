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
public class PartyDecoration extends Service{

    //Constructor
    public PartyDecoration() {
    }

    
    public PartyDecoration(String serviceName, double servicePrice) {
        super(serviceName,servicePrice);
    }
    
    @Override
    public void input() {
         System.out.println("Enter service name: ");
        this.serviceName = GeneralConfiguration.sc.nextLine();
        System.out.println("Enter service price: ");
        this.servicePrice = Double.parseDouble(GeneralConfiguration.sc.nextLine());
    }

    @Override
    public void show() {
       System.out.printf("Service id: %d\t"
                + "Service name: %s\t"
               + "Service price: %,.1f\n",this.serviceId,this.serviceName,this.servicePrice);
    }
    
}
