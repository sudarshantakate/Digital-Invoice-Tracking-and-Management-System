package com.invoiceprocessing.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoiceprocessing.server.dao.InvoiceDao;
import com.invoiceprocessing.server.model.Invoice;
@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	public InvoiceDao invoicedao;

	@Override
	public Invoice addInvoice(Invoice invoice) {
		invoicedao.save(invoice);
		return invoice;
	}

	@Override
	public List<Invoice> getInvoices() {
		return invoicedao.findAll();
	}
	

	@Override
	public Invoice deleteInvoice(long id) {
		Invoice invoice= invoicedao.findById(id).get();
	    invoicedao.delete(invoice);
	    return invoice;
		
	}

	@Override
	public Invoice updateInvoice(long id, Invoice invoice) {
		Invoice existinginvoice = invoicedao.findById(id).get();
		if(existinginvoice!=null) {
			existinginvoice.setAction(invoice.getAction());
			return invoicedao.save(existinginvoice);
		}
		return null;
	}

}
