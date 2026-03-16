package com.invoiceprocessing.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoiceprocessing.server.model.Invoice;
import com.invoiceprocessing.server.services.InvoiceService;

@RestController
@CrossOrigin
public class InvoiceController {
	@Autowired
	public InvoiceService invoiceservice;
	@PostMapping("/invoice")
	public Invoice addInvoice(@RequestBody Invoice invoice) {
		return this.invoiceservice.addInvoice(invoice);
	}
	
	@GetMapping("/invoice")
	public List<Invoice> getInvoices(){
		
		return invoiceservice.getInvoices();
	}
	@PutMapping("/invoice/{invoiceId}")
	public Invoice updateInvoice(@PathVariable String invoiceId,@RequestBody Invoice invoice) {
		return invoiceservice.updateInvoice(Long.parseLong(invoiceId),invoice);
		
	}
	@DeleteMapping("/invoice/{invoiceId}")
	public Invoice deleteInvoice(@PathVariable String invoiceId ) {
		return invoiceservice.deleteInvoice(Long.parseLong(invoiceId));
		
	}

}
