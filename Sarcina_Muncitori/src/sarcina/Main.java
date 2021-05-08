package sarcina;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduceti numarul de ore lucrate: ");
		Scanner scann = new Scanner(System.in);
        int ore = scann.nextInt();
        
        System.out.println("Introduceti categoria lucratorilor intre 1 - 3: ");
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        if (n == 1) {
        	Muncitor muncitor = new Muncitor();
        	muncitor.getTime(ore);
        	int sal = 0;
			muncitor.salary(sal);
			System.out.println("Categoria " + n + " Muncitor, are un salariu de: " + muncitor.salary(sal));
        } else if (n == 2) {
        	Sef_grupa sef = new Sef_grupa();
        	sef.getTime(ore);
        	int sal = 0;
			sef.salary(sal);
			System.out.println("Categoria " + n + " Sef de echipa, are un salariu de: " + sef.salary(sal));
        } else if (n == 3) {
        	Maistru maistru = new Maistru();
        	maistru.getTime(ore);
        	int sal = 0;
        	maistru.salary(sal);
        	System.out.println("Categoria " + n + " Maistru, are un salariu de: " + maistru.salary(sal));
        } else System.out.print("Error");
        
	}

}
