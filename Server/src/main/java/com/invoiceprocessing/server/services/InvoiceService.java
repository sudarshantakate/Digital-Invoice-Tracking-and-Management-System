package com.invoiceprocessing.server.services;

import java.util.List;

import com.invoiceprocessing.server.model.Invoice;

public interface InvoiceService {
	
	public Invoice addInvoice(Invoice invoice);
	public List<Invoice> getInvoices();
	public Invoice updateInvoice(long id,Invoice invoice);
	public Invoice deleteInvoice(long id);

}
