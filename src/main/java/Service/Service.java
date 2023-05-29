/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author Admin
 */
public abstract class Service {
    //Attribute
    private static int count;
    protected int serviceId = ++count;
    protected String serviceName;
    protected double servicePrice;

    //Constructor
    public Service() {
    }

    
    public Service(String serviceName, double servicePrice) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }
    
    //Method Abstact
     public abstract void input();
     public abstract void show();
    
     
     //Getter setter
    /**
     * @return the serviceId
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the servicePrice
     */
    public double getServicePrice() {
        return servicePrice;
    }

    /**
     * @param servicePrice the servicePrice to set
     */
    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }
    
    
}
