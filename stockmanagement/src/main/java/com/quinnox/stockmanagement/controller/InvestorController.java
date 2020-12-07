package com.quinnox.stockmanagement.controller;



import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.stockmanagement.dto.InvestorRequest;
import com.quinnox.stockmanagement.dto.InvestorResponse;
import com.quinnox.stockmanagement.dto.InvestorShare;
import com.quinnox.stockmanagement.service.InvestorService;

@RestController
public class InvestorController {
	@Autowired
	InvestorService service;

	@PostMapping(path = "/add-share")
	public InvestorResponse addShare(@RequestBody InvestorRequest investor) {
		InvestorResponse investorResponse = new InvestorResponse();
		if (service.addShare(investor)) {
			investorResponse.setStatusCode(201);
			investorResponse.setMessage("Success");
			investorResponse.setDescription("Successfully... Shares are bought");
		} else {
			investorResponse.setStatusCode(401);
			investorResponse.setMessage("Failure");
			investorResponse.setDescription("Something went wrong in buying shares");
		}
		return investorResponse;
	}

	@PutMapping(path = "/buy-share", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse updateCompanyBuy(InvestorRequest investor) {
		InvestorResponse investorResponse = new InvestorResponse();
		if (service.buyShare(investor)) {
			investorResponse.setStatusCode(201);
			investorResponse.setMessage("Success");
			investorResponse.setDescription("Successfully... Shares are bought");
		} else {
			investorResponse.setStatusCode(401);
			investorResponse.setMessage("Failure");
			investorResponse.setDescription("Something went wrong in buying shares");
		}
		return investorResponse;
	}


	@PutMapping(path = "/sell-share", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse updateCompanySell(InvestorRequest investor) {
		InvestorResponse investorResponse = new InvestorResponse();
		if (service.sellShare(investor)) {
			investorResponse.setStatusCode(201);
			investorResponse.setMessage("Success");
			investorResponse.setDescription("Successfully... Shares are sold");
		} else {
			investorResponse.setStatusCode(401);
			investorResponse.setMessage("Failure");
			investorResponse.setDescription("Something went wrong in buying shares");
		}
		return investorResponse;
	}
@GetMapping(path = "/get-allshares/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse getAllShares(@PathVariable("userId") int id) {
	       InvestorResponse response = new InvestorResponse();
		List<InvestorShare> shareDetails = service.getAllShares(id);
		if (shareDetails.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("You got all the Shares details");
			response.setShareDetails(shareDetails);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data is present");
		}
		return response;

	}
}

