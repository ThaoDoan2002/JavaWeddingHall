/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WeddingHall;

import MyInterface.IAdd;
import MyInterface.IDelete;
import MyInterface.ISearch;
import com.mycompany.btl.GeneralConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import MyInterface.IShow;
import MyInterface.IUpdate;

/**
 *
 * @author Admin
 */
public class ManagerWeddingHall implements IShow, IAdd<WeddingHall>, IUpdate<String>, IDelete<WeddingHall, String>, ISearch<WeddingHall, String>{

    private List<WeddingHall> list = new ArrayList<>();

    @Override
    public void show() {
        this.list.forEach(x -> x.show());
    }

    //Add
    @Override
    public void add(WeddingHall... w) {
        this.list.addAll(Arrays.asList(w));
    }

    public void add(int n) {
        for (int i = 0; i < n; i++) {
            WeddingHall w = new WeddingHall();
            w.input();
            this.list.add(w);
        }
    }

    public void add(String tapTin) throws FileNotFoundException, Exception {
        File file = new File(tapTin);
        try ( Scanner sf = new Scanner(file)) {
            while (sf.hasNext()) {
                WeddingHall w = new WeddingHall();
                w.setWhName(sf.nextLine());
                w.setTime(sf.nextLine());
                w.setLocation(Integer.parseInt(sf.nextLine()));
                w.setCapacity(Integer.parseInt(sf.nextLine()));
                this.list.add(w);
            }
        }
    }

    //Update
    @Override
    public void update(String id) throws Exception {
        try {
            WeddingHall w = search(id);
            System.out.printf("================== Wedding hall %s ===================\n", id);
            this.inputUpdate(w);
        } catch (Exception NoSuchElementException) {
            throw new Exception("Id not exist!");
        }

    }

    public void updateName(String name) throws Exception {
        List<WeddingHall> l = searchName(name);
        if (l.isEmpty()) {
            System.out.println("Name no exist!");
        } else {
            for (int i = 0; i < l.size(); i++) {
                System.out.printf("============== Wedding id %s ===============\n", l.get(i).getWhId());
                this.inputUpdate(l.get(i));
            }
        }

    }

    public void inputUpdate(WeddingHall w) throws Exception {
        int floor;
        System.out.println("Re-enter wedding hall name: ");
        w.setWhName(GeneralConfiguration.sc.nextLine());
        System.out.println("Re-enter rent wedding hall time (Example: morning weekedn): ");
        w.setTime(GeneralConfiguration.sc.nextLine());
        do {
            System.out.println("Re-enter wedding hall location 1 OR 2: ");
            floor = Integer.parseInt(GeneralConfiguration.sc.nextLine());
        } while (floor != 1 && floor != 2);
        w.setLocation(floor);
        System.out.println("Re-enter wedding hall capacity: ");
        w.setCapacity(Integer.parseInt(GeneralConfiguration.sc.nextLine()));
    }

    //Delete
    @Override
    public void deleteObject(WeddingHall d) {
        this.list.remove(d);
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            WeddingHall w = this.search(id);
            this.list.removeIf(x -> x.getWhId().equalsIgnoreCase(id));
        } catch (Exception NoSuchElementException) {
            throw new Exception("Id no exist");

        }
    }

    public void deleteName(String name) {
        List<WeddingHall> l = this.searchName(name);
        if (l.isEmpty()) {
            System.out.println("Name not exist!");
        } else {
            this.list.removeIf(x -> x.getWhName().trim().equalsIgnoreCase(name));
        }

    }

    //Search
    @Override
    public WeddingHall search(String id) {
        return this.list.stream().filter(x -> x.getWhId().equalsIgnoreCase(id)).findFirst().get();
    }

    public List<WeddingHall> searchName(String name) {
        return this.list.stream().filter(x -> x.getWhName().trim().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public List<WeddingHall> searchCapacity(int capacity) {
        return this.list.stream().filter(x -> x.getCapacity() == capacity).collect(Collectors.toList());
    }

    public List<WeddingHall> searchLocation(int location) {
        return this.list.stream().filter(x -> x.getLocation() == location).collect(Collectors.toList());
    }

    //Sort by quantity of rent wedding hall
    public void sortQuantityOfWeddingHall(int year) {
        this.list.sort(Comparator.comparing((WeddingHall w) -> w.quantityRentOfWeddingHall(year)).reversed());
    }

    /**
     * @return the list
     */
    public List<WeddingHall> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<WeddingHall> list) {
        this.list = list;
    }

}
