package com.greatlearning.stockers.logic;

import com.greatlearning.stockers.model.Stock;

import java.util.Arrays;
import java.util.Comparator;

public class StockProcessor {
     private final Stock[] stocks;
     private IncreasingComparator increasingComparator;
     private DecreasingComparator decreasingComparator;

    static class IncreasingComparator implements Comparator<Stock>{

         @Override
         public int compare(Stock o1, Stock o2) {
             return (int) (o1.getStockPrice() - o2.getStockPrice());
         }
     }

     static class DecreasingComparator implements Comparator<Stock>{

         @Override
         public int compare(Stock o1, Stock o2) {
             return (int) (o2.getStockPrice() - o1.getStockPrice());
         }
     }

     public StockProcessor(Stock[] stocks) {
         this.stocks = stocks;
         this.increasingComparator = new IncreasingComparator();
         this.decreasingComparator = new DecreasingComparator();
     }

     public Stock[] getStocksInCreasingOrder(){
         Stock[] tempStock = stocks;
         Arrays.sort(tempStock,increasingComparator);

         return tempStock;
     }

     public Stock[] getStocksInDecreasingOrder(){
         Stock[] tempStock = stocks;
         Arrays.sort(tempStock,decreasingComparator);
         return tempStock;
     }

     public int numberOfCompaniesStockRose(){
        int num = 0;
        for (Stock stock : stocks){
            if(stock.isHasIncreased())
                num++;
        }
        return num;
     }

     public int numOfCompaniesStockDecreased(){
         int num = 0;
         for (Stock stock : stocks){
             if(!stock.isHasIncreased())
                 num++;
         }
         return num;
     }

     public  boolean searchForAStock(Double stock){
        int result = searchStock(stock);
        return result != -1;
     }

     private int searchStock(Double stock){
       int start = 0;
       int end = stocks.length -1 ;
       while (end >= start){
           int mid = (start + end)/2;
           if(stocks[mid].getStockPrice() == stock)
               return mid;
           else if(stocks[mid].getStockPrice() < stock){
               start = mid + 1;
           }else{
               end = mid -1 ;
           }
       }
       return -1;
     }
 }
