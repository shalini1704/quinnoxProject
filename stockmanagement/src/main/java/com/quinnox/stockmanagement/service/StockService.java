package com.quinnox.stockmanagement.service;



import java.util.List;

import com.quinnox.stockmanagement.dto.Stock;

public interface StockService {

	boolean addStock(Stock stock);

	boolean deleteStock(int stockId);

	boolean updateStock(int stockId, Stock stock);

	List<Stock> getAllStocks();

	Stock searchStock(int stockId);
}
