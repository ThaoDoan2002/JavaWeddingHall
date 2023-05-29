/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import MyInterface.IAdd;
import MyInterface.IDelete;
import MyInterface.ISearch;
import com.mycompany.btl.GeneralConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import MyInterface.IShow;
import MyInterface.IUpdate;

/**
 *
 * @author Admin
 */
public class ManagerService implements IShow, IAdd<Service>, IUpdate<Integer>, IDelete<Service, Integer>, ISearch<Service,Integer> {

    private List<Service> list = new ArrayList<>();

    @Override
    public void show() {
        this.list.forEach(x -> x.show());
    }

    //Add
    @Override
    public void add(Service... s) {
        this.list.addAll(Arrays.asList(s));
    }

    public void add(int n, String type) {
        if (type.equalsIgnoreCase("Karaoke")) {
            for (int i = 0; i < n; i++) {
                Service k = new Karaoke();
                k.input();
                this.list.add(k);
            }
        } else if (type.equalsIgnoreCase("HireSingle")) {
            for (int i = 0; i < n; i++) {
                Service hs = new HireSinger();
                hs.input();
                this.list.add(hs);
            }
        } else if (type.equalsIgnoreCase("PartyDecoration")) {
            for (int i = 0; i < n; i++) {
                Service pd = new PartyDecoration();
                pd.input();
                this.list.add(pd);
            }
        }
    }

    public void add(String tapTin) throws FileNotFoundException {
        File file = new File(tapTin);
        try ( Scanner sf = new Scanner(file)) {
            while (sf.hasNext()) {
                Karaoke k = new Karaoke();
                k.setServiceName(sf.nextLine());
                k.setServicePrice(Double.parseDouble(sf.nextLine()));
                k.setRentPeriod(Double.parseDouble(sf.nextLine()));
                this.list.add(k);
                HireSinger hs = new HireSinger();
                hs.setServiceName(sf.nextLine());
                hs.setServicePrice(Double.parseDouble(sf.nextLine()));
                hs.setInfoSinger(sf.nextLine());
                hs.setNumberOfSong(Integer.parseInt(sf.nextLine()));
                this.list.add(hs);
                PartyDecoration pd = new PartyDecoration();
                pd.setServiceName(sf.nextLine());
                pd.setServicePrice(Double.parseDouble(sf.nextLine()));
                this.list.add(pd);
            }
        }
    }

    //Update
    public void inputUpdate(Service s) {
        System.out.println("\nRe-enter service name: ");
        s.setServiceName(GeneralConfiguration.sc.nextLine());
        System.out.println("Re-enter service price: ");
        s.setServicePrice(Double.parseDouble(GeneralConfiguration.sc.nextLine()));
        if (s instanceof Karaoke) {
            Karaoke k = (Karaoke) s;
            System.out.println("Re-enter rent period: ");
            k.setRentPeriod(Double.parseDouble(GeneralConfiguration.sc.nextLine()));
        } else if (s instanceof HireSinger) {
            HireSinger hs = (HireSinger) s;
            System.out.println("Re-enter information's singer: ");
            hs.setInfoSinger(GeneralConfiguration.sc.nextLine());
            System.out.println("Re-enter number of song: ");
            hs.setNumberOfSong(Integer.parseInt(GeneralConfiguration.sc.nextLine()));
        }
    }

    @Override
    public void update(Integer id) throws Exception {
        try {
            Service s = this.search(id);
            System.out.printf("===== Service %s ======", id);
            this.inputUpdate(s);
        } catch (Exception NoSuchElementException) {
            throw new Exception("Id not exist!");
        }
    }

    public void update(String name) {
        List<Service> l = this.search(name);
        if (l.isEmpty()) {
            System.out.println("Name no exist!");
        } else {
            for (int i = 0; i < l.size(); i++) {
                System.out.printf("====== Service id %s =====\n", l.get(i).getServiceId());
                this.inputUpdate(l.get(i));
            }
        }
    }

    // //Delete
    @Override
    public void deleteObject(Service s) {
        this.list.remove(s);
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            Service s = this.search(id);
            this.list.removeIf(x -> x.getServiceId() == id);
        } catch (Exception NoSuchElementException) {
            throw new Exception("Id no exist");
        }

    }

    public void delete(String name) {
        List<Service> l = this.search(name);
        if (l.isEmpty()) {
            System.out.println("Name not exist!");
        } else {
            this.list.removeIf(x -> x.getServiceName().trim().equalsIgnoreCase(name));
        }

    }

//Search
    @Override
    public Service search(Integer id) {
        return this.list.stream().filter(x -> x.getServiceId() == id).findFirst().get();
    }

    public List<Service> search(String name) {
        return this.list.stream().filter(x -> x.getServiceName().trim().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public List<Service> search(double p1, double p2) {
        return this.list.stream().filter(x -> x.getServicePrice() >= p1 && x.getServicePrice() <= p2).collect(Collectors.toList());
    }

    public List<Service> searchObject(String lop) throws ClassNotFoundException {
        Class c = Class.forName(lop);
        return this.list.stream().filter(x -> c.isInstance(x)).collect(Collectors.toList());
    }

    //Caculate Unit Price
    public double calculateUnitPrice() {
        return this.list.stream().mapToDouble(Service::getServicePrice).sum();
    }

    /**
     * @return the list
     */
    public List<Service> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Service> list) {
        this.list = list;
    }





}
