package com.greatlearning.stockers.model;

/**
 * Stock information POJO
 */
public class Stock {
    private double stockPrice;
    private boolean hasIncreased;

    public Stock(double stockPrice, boolean hasIncreased) {
        this.stockPrice = stockPrice;
        this.hasIncreased = hasIncreased;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public boolean isHasIncreased() {
        return hasIncreased;
    }
}
