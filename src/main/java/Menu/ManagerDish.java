/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import MyInterface.IAdd;
import MyInterface.IDelete;
import com.mycompany.btl.GeneralConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import MyInterface.ISearch;
import MyInterface.IShow;
import MyInterface.IUpdate;

/**
 *
 * @author Admin
 */
public class ManagerDish implements IShow, IAdd<Dish>, IUpdate<Integer>, IDelete<Dish, Integer> , ISearch<Dish, Integer>{

    private List<Dish> list = new ArrayList<>();

    @Override
    public void show() {
        this.list.forEach(x -> x.show());
    }

    //Add
    @Override
    public void add(Dish... d) {
        this.list.addAll(Arrays.asList(d));
    }

    public void add(int n, String type) {
        if (type.equalsIgnoreCase("Food")) {
            for (int i = 0; i < n; i++) {
                Dish f = new Food();
                f.input();
                this.list.add(f);
            }
        } else if (type.equalsIgnoreCase("Drink")) {
            for (int i = 0; i < n; i++) {
                Dish d = new Drink();
                d.input();
                this.list.add(d);
            }
        }
    }

    public void add(String tapTin) throws FileNotFoundException {
        File file = new File(tapTin);
        try ( Scanner sf = new Scanner(file)) {
            while (sf.hasNext()) {
                Food f = new Food();
                /*
                //Vi dynamic binding no se chia ra 2 thoi diem : + bien dich va thuc thi, ma bien dich thi no xet kieu thuc su phai co cai
                ham do neu khong se loi, truong hop nay do lop con moi co ham do nen trinh bien dich bao loi nen khong su dung dynamic binding
                 */
                f.setDishName(sf.nextLine());
                f.setDishPrice(Double.parseDouble(sf.nextLine()));
                f.setIsVegetarian(Boolean.parseBoolean(sf.nextLine()));
                this.list.add(f);
                Drink d = new Drink();
                d.setDishName(sf.nextLine());
                d.setDishPrice(Double.parseDouble(sf.nextLine()));
                d.setManufacturer(sf.nextLine());
                this.list.add(d);

            }
        }
    }


//Update

    public void inputUpdate(Dish d) {
        System.out.println("\nRe-enter dish name: ");
        d.setDishName(GeneralConfiguration.sc.nextLine());
        System.out.println("Re-enter dish price: ");
        d.setDishPrice(Double.parseDouble(GeneralConfiguration.sc.nextLine()));
        if (d instanceof Food) {
            Food f = (Food) d;
            System.out.println("Re-enter Is it vegetarian (True or False): ");
            f.setIsVegetarian(Boolean.parseBoolean(GeneralConfiguration.sc.nextLine()));
        } else if (d instanceof Drink) {
            Drink dr = (Drink) d;
            System.out.println("Re-enter manufacturer: ");
            dr.setManufacturer(GeneralConfiguration.sc.nextLine());
        }
    }

    @Override
    public void update(Integer id) throws Exception {
        try {
            Dish d = this.search(id);
            System.out.printf("===== Dish %s ======", id);
            this.inputUpdate(d);
        } catch (Exception NoSuchElementException) {
            throw new Exception("Id not exist!");
        }
    }

    public void update(String name) {
        List<Dish> l = this.search(name);
        if (l.isEmpty()) {
            System.out.println("Name no exist!");
        } else {
            for (int i = 0; i < l.size(); i++) {
                System.out.printf("====== Dish id %s =====\n", l.get(i).getDishId());
                this.inputUpdate(l.get(i));
            }
        }
    }

    //Delete
    @Override
    public void deleteObject(Dish d) {
        this.list.remove(d);
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            Dish d = this.search(id);
            this.list.removeIf(x -> x.getDishId() == id);
        } catch (Exception NoSuchElementException) {
            throw new Exception("Id no exist");
        }

    }

    public void delete(String name) {
        List<Dish> l = this.search(name);
        if (l.isEmpty()) {
            System.out.println("Name not exist!");
        } else {
            this.list.removeIf(x -> x.getDishName().trim().equalsIgnoreCase(name));
        }

    }

//Search
    @Override
    public Dish search(Integer id) {
        return this.list.stream().filter(x -> x.getDishId() == id).findFirst().get();
    }

    public List<Dish> search(String name) {
        return this.list.stream().filter(x -> x.getDishName().trim().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public List<Dish> search(double p1, double p2) {
        return this.list.stream().filter(x -> x.getDishPrice() >= p1 && x.getDishPrice() <= p2).collect(Collectors.toList());
    }

    public List<Dish> searchObject(String lop) throws ClassNotFoundException {
        Class c = Class.forName(lop);
        return this.list.stream().filter(x -> c.isInstance(x)).collect(Collectors.toList());
    }

    //Caculate Unit Price
    public double calculateUnitPrice() {
        return this.list.stream().mapToDouble(Dish::getDishPrice).sum();
    }

    /**
     * @return the list
     */
    public List<Dish> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Dish> list) {
        this.list = list;
    }

}
