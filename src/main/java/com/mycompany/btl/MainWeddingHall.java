/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl;

import Bill.ManagerBill;
import Menu.ManagerDish;
import Service.ManagerService;
import WeddingHall.ManagerWeddingHall;
import java.util.InputMismatchException;

/**
 *
 * @author Admin
 */
public class MainWeddingHall {

    public static void main(String[] args) throws Exception {
        int choice = 0, choice1 = 0;
        int year1 = 0;
        ManagerWeddingHall listWH = new ManagerWeddingHall();
        ManagerService listService = new ManagerService();
        ManagerDish listDish = new ManagerDish();
        ManagerBill listBill = new ManagerBill();
        System.out.println("\n\n---------------------------------------- < < < WELCOME TO LUXURY PALACE > > >-----------------------------------------------");
        do {
            System.out.println("\n--------------------------------------------------MANAGER RESTAURENT----------------------------------------------------");
            System.out.printf(" 1.Manage the wedding hall\n"
                    + " 2.Service Management\n"
                    + " 3.Food Management\n"
                    + " 4.Input bill\n"
                    + " 5.Sort List Wedding Halls By Quantity Rental\n"
                    + " 6.Show Revenue wedding halls by year\n"
                    + " 7.Show Revenue by Quarterly\n"
                    + " 8.Show Bill"
                    + "------->>>>>0:EXIT MANAGER!\n"
                    + "Your Choose: ");
            try {
                choice = Integer.parseInt(GeneralConfiguration.sc.nextLine());
            } catch (InputMismatchException e) {
            }
            switch (choice) {
                case 1: //Manage the wedding hall
                    do {
                        String idWH;
                        System.out.printf("\n 1. Add Wedding hall\n"
                                + " 2.Search Wedding hall\n"
                                + " 3.Delete Wedding hall\n"
                                + " 4.Update Wedding hall\n"
                                + " 5.Show list Wedidng hall\n"
                                + " 0. Exit Manage the wedding hall\n"
                                + " Your choice: ");
                        try {
                            choice1 = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                        } catch (InputMismatchException e) {
                        }
                        switch (choice1) {
                            case 1:
                                System.out.println("============================= ADD WEDDING HALL ====================================");
                                listWH.add("src/main/resources/weddinghall.txt");
                                break;
                            case 2:
                                if (!listWH.getList().isEmpty()) {
                                    System.out.println("=========================== SEARCH WEDDING HALL ================================");
                                    System.out.println("Please enter id of wedding hall: ");
                                    try {
                                        idWH = GeneralConfiguration.sc.nextLine();
                                        listWH.search(idWH).show();
                                    } catch (Exception NoSuchElementException) {
                                        System.out.println("Id not exist!");
                                    }
                                }
                                break;
                            case 3:
                                if (!listWH.getList().isEmpty()) {
                                    System.out.println("============================= DELETE WEDDING HALLL ================================");
                                    System.out.println("Please enter id of wedding hall: ");
                                    try {
                                        idWH = GeneralConfiguration.sc.nextLine();
                                        listWH.delete(idWH);
                                    } catch (Exception NoSuchElementException) {
                                        System.out.println("Id not exist!");
                                    }
                                }
                                break;
                            case 4:
                                if (!listWH.getList().isEmpty()) {
                                    System.out.println("============================= UPDATE WEDDING HALL =================================");
                                    System.out.println("Please enter id of wedding hall: ");
                                    try {
                                        idWH = GeneralConfiguration.sc.nextLine();
                                        listWH.update(idWH);
                                    } catch (Exception NoSuchElementException) {
                                        System.out.println("Id not exist!");
                                    }
                                }
                                break;
                            case 5:
                                if (!listWH.getList().isEmpty()) {
                                    System.out.println("============================= SHOW WEDDING HALL ====================================");
                                    listWH.show();
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Please choose from 1-5!!!!!!!!!!");
                        }
                    } while (choice1 != 0);
                    break;
                case 2: //Service Management
                    do {
                        int idService;
                        System.out.printf("\n 1. Add Service\n"
                                + " 2.Search Service\n"
                                + " 3.Delete Service\n"
                                + " 4.Update Service\n"
                                + " 5.Show list Services\n"
                                + " 0. Exit Manage Service\n"
                                + " Your choice: ");
                        try {
                            choice1 = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                        } catch (InputMismatchException e) {
                        }
                        switch (choice1) {
                            case 1:
                                System.out.println("============================= ADD SERVICE ====================================");
                                listService.add("src/main/resources/service.txt");
                                break;
                            case 2:
                                if (!listService.getList().isEmpty()) {
                                    System.out.println("=========================== SEARCH SERVICE ================================");
                                    System.out.println("Please enter id of service: ");
                                    try {
                                        idService = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                                        listService.search(idService).show();
                                    } catch (NumberFormatException NoSuchElementException) {
                                        System.out.println("Id not exist!");
                                    }
                                }
                                break;
                            case 3:
                                if (!listService.getList().isEmpty()) {
                                    System.out.println("============================= DELETE SERVICE ================================");
                                    System.out.println("Please enter id of service: ");
                                    try {
                                        idService = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                                        listService.delete(idService);
                                    } catch (Exception NoSuchElementException) {
                                        System.out.println("Id not exist!");
                                    }
                                }
                                break;
                            case 4:
                                if (!listService.getList().isEmpty()) {
                                    System.out.println("============================= UPDATE SERVICE =================================");
                                }
                                System.out.println("Please enter id of service: ");
                                try {
                                    idService = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                                    listService.update(idService);
                                } catch (Exception NoSuchElementException) {
                                    System.out.println("Id not exist!");
                                }
                                break;
                            case 5:
                                if (!listService.getList().isEmpty()) {
                                    System.out.println("============================= SHOW SERVICES ====================================");
                                }
                                listService.show();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Please choose from 1-5!!!!!!!!!!");
                        }
                    } while (choice1 != 0);

                    break;
                case 3: //Food Management
                    do {
                        int idDish;
                        System.out.printf("\n 1. Add Dish\n"
                                + " 2.Search Dish\n"
                                + " 3.Delete Dish\n"
                                + " 4.Update Dish\n"
                                + " 5.Show List Dishes\n"
                                + " 0. Exit Manage Dishes\n"
                                + " Your choice: ");
                        try {
                            choice1 = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                        } catch (InputMismatchException e) {
                        };
                        switch (choice1) {
                            case 1:
                                System.out.println("============================= ADD DISH ====================================");
                                listDish.add("src/main/resources/dish.txt");
                                break;
                            case 2:
                                if (!listDish.getList().isEmpty()) {
                                    System.out.println("=========================== SEARCH DISH ================================");
                                }
                                System.out.println("Please enter id of service: ");
                                try {
                                    idDish = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                                    listDish.search(idDish).show();
                                } catch (Exception NoSuchElementException) {
                                    System.out.println("Id not exist!");
                                }
                                break;
                            case 3:
                                if (!listDish.getList().isEmpty()) {
                                    System.out.println("============================= DELETE DISH ================================");
                                    System.out.println("Please enter id of service: ");
                                    try {
                                        idDish = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                                        listDish.delete(idDish);
                                    } catch (Exception NoSuchElementException) {
                                        System.out.println("Id not exist!");
                                    }
                                }
                                break;
                            case 4:
                                if (!listDish.getList().isEmpty()) {
                                    System.out.println("============================= UPDATE DISH =================================");
                                    System.out.println("Please enter id of service: ");
                                    try {
                                        idDish = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                                        listDish.update(idDish);
                                    } catch (Exception NoSuchElementException) {
                                        System.out.println("Id not exist!");
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("============================= SHOW DISHES ====================================");
                                listDish.show();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Please choose from 1-5!!!!!!!!!!");
                        }
                    } while (choice1 != 0);
                    break;
                case 4: // Add Bill For Wedding Hall
                    if (!listDish.getList().isEmpty() && !listService.getList().isEmpty() && !listWH.getList().isEmpty()) {
                        System.out.println("\n============================= INPUT BILL ====================================");
//                        listBill.add("src/main/resources/bill.txt", listWH, listDish, listService);
                        listBill.creatData(listDish, listService, listWH);
                    }

                    break;
                case 5: //Sort List Wedding Halls By Quality Rental
                    if (!listBill.getList().isEmpty() && !listWH.getList().isEmpty()) {
                        System.out.println("\n============================= SORT LIST WEDDING HALLS  ====================================");
                        System.out.print("Enter year: ");
                        int year = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                        listWH.sortQuantityOfWeddingHall(year);
                        listWH.getList().forEach(x -> x.showForSortQuantityWeddingHall(year));
                    }
                    break;
                case 6: //Search revenu wedding halls by year
                    if (!listBill.getList().isEmpty()) {
                        System.out.println("\n============================= REPORT REVENU WEDDING HALLS BY YEAR====================================");
                        System.out.print("Enter year: ");
                        year1 = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                        listBill.monthlyRevenueReport(year1);
                    }
                    break;
                case 7: //Show Revenue By Quartely
                    if (!listBill.getList().isEmpty()) {
                        System.out.println("\n============================= REPORT REVENU WEDDING HALLS BY QUARTERLY====================================");
                        System.out.print("Enter year: ");
                        year1 = Integer.parseInt(GeneralConfiguration.sc.nextLine());
                        listBill.quarterlyRevenueReport(year1);
                    }
                    break;
                case 8: //Show Bill 
                    if (!listBill.getList().isEmpty()) {
                        System.out.println("\n============================= SHOW BILL ====================================");
                        listBill.show();
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose from 1 to 5!!!!!");

            }

        } while (choice
                != 0);

    }

}
