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
public class HireSinger extends Service{
    //Attribute
    private String infoSinger;
    private int numberOfSong;

    //Constructor
    public HireSinger() {
    }

    
    public HireSinger(String serviceName, double servicePrice,String infoSinger, int numberOfSong) {
        super(serviceName, servicePrice);
        this.infoSinger = infoSinger;
        this.numberOfSong = numberOfSong;
    }

    
    
    
    @Override
    public void input() {
         System.out.println("Enter service name: ");
        this.serviceName = GeneralConfiguration.sc.nextLine();
        System.out.println("Enter service price: ");
        this.servicePrice = Double.parseDouble(GeneralConfiguration.sc.nextLine());
        System.out.println("Enter information's Singer: ");
        this.infoSinger = GeneralConfiguration.sc.nextLine();
        System.out.println("Enter number of song: ");
        this.numberOfSong = Integer.parseInt(GeneralConfiguration.sc.nextLine());
    }

    @Override
    public void show() {
         System.out.printf("Service id: %d\t"
                + "Service name: %s\t"
                + "Service price: %,.1f\t"
                + "Information's Singer: %s\t"
                 + "Number of song: %d\n", this.serviceId, this.serviceName, this.servicePrice,this.infoSinger,this.numberOfSong);
    }
    
    //Getter setter
    /**
     * @return the infoSinger
     */
    public String getInfoSinger() {
        return infoSinger;
    }

    /**
     * @param infoSinger the infoSinger to set
     */
    public void setInfoSinger(String infoSinger) {
        this.infoSinger = infoSinger;
    }

    /**
     * @return the numberOfSong
     */
    public int getNumberOfSong() {
        return numberOfSong;
    }

    /**
     * @param numberOfSong the numberOfSong to set
     */
    public void setNumberOfSong(int numberOfSong) {
        this.numberOfSong = numberOfSong;
    }

    
    
}
