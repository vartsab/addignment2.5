package com.company;

public class Main {

    public static void main(String[] args) {

        final RosterService rosterService = new RosterServiceImpl();

        rosterService.addEmployee("Petro", "Petrenko");
        rosterService.addEmployee("Vasyl", "Vasyltsiv");
        rosterService.addEmployee("Danylo", "Danylchenko");

        System.out.println(rosterService.addEmployee("Ivan", "Ivanov"));

        System.out.println(rosterService.removeEmployee("Ivan", "Ivanov"));

        rosterService.addEmployee("Mykola", "Mykolenko");

        System.out.println(rosterService.findEmployee("Zynovii", "Zinchenko"));

        System.out.println(rosterService);

    }
}
