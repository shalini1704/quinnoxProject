package com.quinnox.stockmanagement.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.stockmanagement.dto.Stock;
import com.quinnox.stockmanagement.dto.StockResponse;
import com.quinnox.stockmanagement.service.StockService;


@RestController

public class StockController {
	@Autowired
	StockService service;

	@PostMapping(path = "/add-stock", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse addStock(@RequestBody Stock stock) {
		StockResponse response = new StockResponse();
		if (service.addStock(stock)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Stock is added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("This Stock is already exists");
		}
		return response;
	}

	@GetMapping(path = "/get-allstocks", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse getAllStock() {
		StockResponse response = new StockResponse();
		List<Stock> list = service.getAllStocks();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("You got all the Stock details");
			response.setStocks(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data is present");
		}
		return response;

	}

	@GetMapping(path = "/get-stock/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse getStock(@PathVariable("stockId") int stockId) {
		StockResponse response = new StockResponse();
		Stock stock = service.searchStock(stockId);
		if (stock != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("You found the Stock details");
			response.setStocks(Arrays.asList(stock));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No stocks present");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-stock/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse deleteStock(@PathVariable("stockId") int stockId) {
		StockResponse response = new StockResponse();
		if (service.deleteStock(stockId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Stock is deleted successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Stock is not found");
		}
		return response;
	}

	@PutMapping(path = "/update-stock/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse updateHaulier(@PathVariable("stockId") int stockId, @RequestBody Stock stock) {
		StockResponse response = new StockResponse();
		if (service.updateStock(stockId, stock)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Stock details are updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Stocks are not found");
		}
		return response;
	}

}