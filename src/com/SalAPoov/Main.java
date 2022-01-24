package com.SalAPoov;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static double getMonthlyIntrestRate(double AnnualIntrestRate) {
        return (AnnualIntrestRate/100)/12;
    }
    public static double calculateMortgage(double Principle, double MonthlyIntrestRate, int Years) {
        int Months = Years * 12;
        double p1 = Math.pow((MonthlyIntrestRate+1),Months);
        p1 *= MonthlyIntrestRate;

        double p2 = Math.pow((MonthlyIntrestRate+1),Months);
        p2 -= 1;

        double div = p1/p2;

        return Principle*div;
    }
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Principle: ");
        double Principle = scan.nextDouble();
        System.out.print("Annual Intrest Rate: ");
        double AnnualIntrestRate = scan.nextDouble();
        System.out.print("Period (Years): ");
        int Years = scan.nextInt();

        double MonthlyIntrestRate = getMonthlyIntrestRate(AnnualIntrestRate);
        double M = calculateMortgage(Principle, MonthlyIntrestRate, Years);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String Mortgage = currency.format(M);

        System.out.println(Mortgage);

    }
}
