package com.greatlearning.stockers.userinterfcae;

import com.greatlearning.stockers.model.Stock;

interface UserInterface{

    Stock[] buildStockInfo();

    void displayOptions();

    int acceptOptions();

    void displayStocks(Stock[] stocks);
}