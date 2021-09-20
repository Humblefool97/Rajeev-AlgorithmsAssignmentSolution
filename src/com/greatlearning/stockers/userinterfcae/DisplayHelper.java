package com.greatlearning.stockers.userinterfcae;

public class DisplayHelper {

    static void displayDecorationHeader(String message) {
        System.out.println("############################################");
        System.out.println("             " + message + "                    ");
        System.out.println("############################################");
    }

    static void displayDecorationFooter() {
        System.out.println("############################################");
    }

    static void displayInfo(String info) {
        System.out.println(info);
    }
}
