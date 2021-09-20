package com.greatlearning.stockers.userinterfcae;

import com.greatlearning.stockers.logic.StockProcessor;
import com.greatlearning.stockers.model.Stock;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {

    private final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        UserInterfaceImpl instance = new UserInterfaceImpl();
        Stock[] stocksInfo = instance.buildStockInfo();

        StockProcessor stockProcessor = new StockProcessor(stocksInfo);
        int selectedOption = 0;
        do {
            instance.displayOptions();
            selectedOption = instance.acceptOptions();
            switch (selectedOption) {
                case 1: {
                    instance.displayStocks(stockProcessor.getStocksInCreasingOrder());
                    break;
                }

                case 2: {
                    instance.displayStocks(stockProcessor.getStocksInDecreasingOrder());
                    break;
                }

                case 3: {
                    int count = stockProcessor.numberOfCompaniesStockRose();
                    System.out.println(count);
                    break;
                }

                case 4:{
                    int count = stockProcessor.numOfCompaniesStockDecreased();
                    System.out.println(count);
                    break;
                }
            }
        } while (selectedOption != 0);

    }

    @Override
    public Stock[] buildStockInfo() {

        DisplayHelper.displayInfo("Enter the number of companies:- ");
        int numberOfCompanies = scanner.nextInt();

        Stock[] stockArray = new Stock[numberOfCompanies];
        for (int num = 0; num < numberOfCompanies; num++) {

            DisplayHelper.displayInfo("Enter current stock price of the company " + (num + 1));
            double price = scanner.nextDouble();
            DisplayHelper.displayInfo("Whether company's stock price rose today compare to yesterday?");
            boolean hasRaised = scanner.nextBoolean();

            stockArray[num] = new Stock(price, hasRaised);
        }

        return stockArray;
    }

    @Override
    public void displayOptions() {
        DisplayHelper.displayDecorationHeader("Stock info");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Display the companies stock prices in ascending order")
                .append("Display the companies stock prices in descending order")
                .append("Display the total no of companies for which stock prices rose today")
                .append("Display the total no of companies for which stock prices declined today")
                .append("Search a specific stock price");
        DisplayHelper.displayInfo(stringBuilder.toString());
        DisplayHelper.displayDecorationFooter();
    }

    @Override
    public int acceptOptions() {

        return scanner.nextInt();
    }

    @Override
    public void displayStocks(Stock[] stocks) {
        for (Stock stock : stocks)
            System.out.println(stock.getStockPrice());
    }
}
