/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import Menu.ManagerDish;
import WeddingHall.WeddingHall;
import com.mycompany.btl.GeneralConfiguration;
import java.text.ParseException;
import java.util.Date;
import MyInterface.IShow;
import Service.ManagerService;

/**
 *
 * @author Admin
 */
public class Bill implements IShow {

    //Attribute
    private String partyName;
    private WeddingHall weddingHall;
    private Date dateRent;
    private ManagerDish listDish;
    private ManagerService listService;

    //Constructor
    public Bill() {
    }

    public Bill(WeddingHall w, ManagerDish listDish, ManagerService listService) {
        this.weddingHall = w;
        this.listDish = listDish;
        this.listService = listService;
        if (w != null) {
            this.weddingHall.getBill().add(this);
        }

    }

    public Bill(String partyName, WeddingHall weddingHall, ManagerDish listDish, Date dateRent, ManagerService listService) {
        this.partyName = partyName;
        this.weddingHall = weddingHall;
        this.listDish = listDish;
        this.dateRent = dateRent;
        this.listService = listService;
        if (weddingHall != null) {
            this.weddingHall.getBill().add(this);
        }
    }

    public Bill(String partyName, WeddingHall weddingHall, ManagerDish listDish, String ngayThue, ManagerService listService) throws ParseException {
        this.partyName = partyName;
        this.weddingHall = weddingHall;
        this.listDish = listDish;
        this.listService = listService;
        this.dateRent = GeneralConfiguration.f.parse(ngayThue);
        if (weddingHall != null) {
            this.weddingHall.getBill().add(this);
        }
    }

    public void input() throws ParseException {
        System.out.println("Enter party name: ");
        this.partyName = GeneralConfiguration.sc.nextLine();
        System.out.println("Enter date rent: ");
        this.dateRent = GeneralConfiguration.f.parse(GeneralConfiguration.sc.nextLine());
    }

    @Override
    public void show() {
        System.out.printf("\nParty name: %s\n", this.partyName);
        System.out.println(">>>> Information wedding hall <<<<<<");
        this.weddingHall.show();
        System.out.println(">>>> Information menu <<<<<<");
        this.listDish.show();
        System.out.printf("Unit price of menu: %,.1f\n", this.listDish.calculateUnitPrice());
        System.out.println(">>>> Information services <<<<<<");
        this.listService.show();
        System.out.printf("Unit price of services: %,.1f\n", this.listService.calculateUnitPrice());
        System.out.printf("Date rent wedding hall: %s\n", GeneralConfiguration.f.format(this.dateRent));
        System.out.printf("Caculate bill: %,.1f\n", this.calculateBill());
    }

    public double calculateBill() {
        return (this.listDish.calculateUnitPrice() + this.weddingHall.rentCostOfWeddingHall() + this.listService.calculateUnitPrice());
    }

    //Setter getter
    /**
     * @return the partyName
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * @param partyName the partyName to set
     */
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    /**
     * @return the weddingHall
     */
    public WeddingHall getWeddingHall() {
        return weddingHall;
    }

    /**
     * @param weddingHall the weddingHall to set
     */
    public void setWeddingHall(WeddingHall weddingHall) {
        this.weddingHall = weddingHall;
    }

    /**
     * @return the menu
     */
    public ManagerDish getListDish() {
        return listDish;
    }

    /**
     * @param menu the menu to set
     */
    public void setListDish(ManagerDish menu) {
        this.listDish = menu;
    }

    /**
     * @return the dateRent
     */
    public Date getDateRent() {
        return dateRent;
    }

    /**
     * @param dateRent the dateRent to set
     */
    public void setDateRent(String dateRent) throws ParseException {
        this.dateRent = GeneralConfiguration.f.parse(dateRent);
    }

    /**
     * @return the listService
     */
    public ManagerService getListService() {
        return listService;
    }

    /**
     * @param listService the listService to set
     */
    public void setListService(ManagerService listService) {
        this.listService = listService;
    }

}
