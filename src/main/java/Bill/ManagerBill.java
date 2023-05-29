/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import Menu.Dish;
import Menu.Drink;
import Menu.Food;
import Menu.ManagerDish;
import MyInterface.IAdd;
import WeddingHall.ManagerWeddingHall;
import WeddingHall.WeddingHall;
import com.mycompany.btl.GeneralConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import MyInterface.IShow;
import Service.HireSinger;
import Service.Karaoke;
import Service.ManagerService;
import Service.PartyDecoration;
import Service.Service;

/**
 *
 * @author Admin
 */
public class ManagerBill implements IShow, IAdd<Bill> {

    private List<Bill> list = new ArrayList<>();

    //Add
    @Override
    public void add(Bill... b) {
        this.list.addAll(Arrays.asList(b));
    }

    public void add(int n, ManagerWeddingHall listWH, ManagerDish listDish, ManagerService listService) throws ParseException {
        String whId;
        WeddingHall w;
        int id;
        Dish d;
        Service s;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter wedding hall id: ");
            whId = GeneralConfiguration.sc.nextLine();
            w = listWH.search(whId);
            ManagerDish menu = new ManagerDish();
            for (int j = 0; j < 1; j++) {
                System.out.println("Enter food id: ");
                id = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                d = listDish.search(id);
                menu.add(d);
            }
            for (int k = 0; k < 1; k++) {
                System.out.println("Enter drink id: ");
                id = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                d = listDish.search(id);
                menu.add(d);
            }
            ManagerService services = new ManagerService();
            for (int j = 0; j < 1; j++) {
                System.out.println("Enter karaoke id: ");
                id = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                s = listService.search(id);
                services.add(s);
            }
            for (int k = 0; k < 1; k++) {
                System.out.println("Enter singer id: ");
                id = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                s = listService.search(id);
                services.add(s);
            }
            for (int k = 0; k < 1; k++) {
                System.out.println("Enter party decoration id: ");
                id = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                s = listService.search(id);
                services.add(s);
            }

            Bill b = new Bill(w, menu, services);
            b.input();
            this.list.add(b);
        }
    }

    public void add(String tapTin, ManagerWeddingHall listWh, ManagerDish listDish, ManagerService listService) throws FileNotFoundException, Exception {
        File file = new File(tapTin);
        try ( Scanner sf = new Scanner(file)) {
            while (sf.hasNext()) {
                Bill b = new Bill();
                b.setPartyName(sf.nextLine());
                WeddingHall w = new WeddingHall();
                w.setWhName(sf.nextLine());
                w.setLocation(Integer.parseInt(sf.nextLine()));
                w.setCapacity(Integer.parseInt(sf.nextLine()));
                w.setTime(sf.nextLine());
                w.getBill().add(b);
                listWh.add(w);
                b.setWeddingHall(w);
                b.setDateRent(sf.nextLine());
                Food f = new Food();
                f.setDishName(sf.nextLine());
                f.setDishPrice(Double.parseDouble(sf.nextLine()));
                f.setIsVegetarian(Boolean.parseBoolean(sf.nextLine()));
                Food f2 = new Food();
                f2.setDishName(sf.nextLine());
                f2.setDishPrice(Double.parseDouble(sf.nextLine()));
                f2.setIsVegetarian(Boolean.parseBoolean(sf.nextLine()));
                Drink dr1 = new Drink();
                dr1.setDishName(sf.nextLine());
                dr1.setDishPrice(Double.parseDouble(sf.nextLine()));
                dr1.setManufacturer(sf.nextLine());
                ManagerDish m = new ManagerDish();
                m.add(f, f2, dr1);
                b.setListDish(m);
                listDish.add(f, f2, dr1);
                Karaoke k = new Karaoke();
                k.setServiceName(sf.nextLine());
                k.setServicePrice(Double.parseDouble(sf.nextLine()));
                k.setRentPeriod(Double.parseDouble(sf.nextLine()));
                HireSinger h = new HireSinger();
                h.setServiceName(sf.nextLine());
                h.setServicePrice(Double.parseDouble(sf.nextLine()));
                h.setInfoSinger(sf.nextLine());
                h.setNumberOfSong(Integer.parseInt(sf.nextLine()));
                PartyDecoration p = new PartyDecoration();
                p.setServiceName(sf.nextLine());
                p.setServicePrice(Double.parseDouble(sf.nextLine()));
                ManagerService s = new ManagerService();
                s.add(k, h, p);
                b.setListService(s);
                listService.add(k, h, p);
                this.add(b);
            }
        }
    }

    public void creatData(ManagerDish listDish, ManagerService listService, ManagerWeddingHall listWH) throws ParseException {
        WeddingHall w = listWH.search("S001");
        WeddingHall w4 = listWH.search("S004");
        WeddingHall w6 = listWH.search("S006");
        WeddingHall w8 = listWH.search("S008"); 
        WeddingHall w2 = listWH.search("S002");

        ManagerDish listD = new ManagerDish();
        listD.setList(listDish.search(50000, 180000));
        ManagerService listS = new ManagerService();
        listS.setList(listService.search(200000, 20000000));
        Bill b1 = new Bill("party b1", w, listD, "01/02/2022", listS);

        ManagerDish listD2 = new ManagerDish();
        listD2.setList(listDish.search(200000, 300000));
        ManagerService listS2 = new ManagerService();
        listS2.setList(listService.search(1000000, 4000000));
        Bill b2 = new Bill("party b2", w, listD2, "01/03/2022", listS2);

        ManagerDish listD3 = new ManagerDish();
        listD3.setList(listDish.search(300000, 500000));
        ManagerService listS3 = new ManagerService();
        listS3.setList(listService.search(200000, 3000000));
        Bill b3 = new Bill("party b3", w4, listD3, "01/05/2022", listS3);

        Bill b4 = new Bill("party b4", w, listD2, "01/06/2022", listS);

        Bill b5 = new Bill("party b5", w6, listD3, "01/12/2022", listS);

        Bill b6 = new Bill("party b6", w8, listD3, "01/07/2022", listS2);

        ManagerDish listD4 = new ManagerDish();
        listD4.setList(listDish.search(100000, 200000));
        ManagerService listS4 = new ManagerService();
        listS4.setList(listService.search(50000, 2000000));
        Bill b7 = new Bill("party b7", w8, listD4, "01/07/2023", listS4);

        Bill b8 = new Bill("party b8", w6, listD4, "01/05/2023", listS2);

        Bill b9 = new Bill("party b9", w2, listD3, "01/12/2023", listS2);
        
        Bill b10 = new Bill("party b10", w8, listD2, "01/06/2023", listS4);

        this.add(b1, b2, b3, b4, b5, b6, b7, b8, b9,b10);
    }

    public double calculateRevenueOf1Month(int year, int month) {
//        double sum = 0;
//        ManagerBill list = new ManagerBill();
//        list.setList(this.searchByMonth(month, year));
//        for (int i = 0; i < list.getList().size(); i++) {
//            sum += list.getList().get(i).calculateBill();
//        }
//        return sum;

        List<Bill> listMonth = new ArrayList<>();
        listMonth = this.searchByMonth(month, year);
        return listMonth.stream().mapToDouble(Bill::calculateBill).sum();
    }

    public void monthlyRevenueReport(int year) {
        for (int i = 1; i < 13; i++) {
            System.out.printf("Doanh thu thang %d:\n"
                    + "Unit price: %,.1f\n", i, calculateRevenueOf1Month(year, i));
        }
    }

    public void quarterlyRevenueReport(int year) {
        int month = 1;
        for (int i = 1; i < 5; i++) {
            double sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += this.calculateRevenueOf1Month(year, month);
                month++;
            }
            System.out.printf("Revenue of quarterly %d: "
                    + "Unit price: %,.1f\n", i, sum);
        }
    }

    @Override
    public void show() {
        this.list.forEach(x -> x.show());
    }

    public List<Bill> searchByMonth(int month, int year) {
        return this.list.stream().filter(x -> x.getDateRent().getMonth() + 1 == month && x.getDateRent().getYear() == year - 1900).collect(Collectors.toList());
    }

    public List<Bill> searchByYear(int year) {
        return this.list.stream().filter(x -> x.getDateRent().getYear() == year - 1900).collect(Collectors.toList());
    }

    /**
     * @return the list
     */
    public List<Bill> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Bill> list) {
        this.list = list;
    }

}
