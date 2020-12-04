package com.kodilla.hibernate.invoice.dao;
import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ProductDao productDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("123457");
        Product product = new Product("dywan");

        Item item1 = new Item(new BigDecimal(1000.0), 2);
        Item item2 = new Item(new BigDecimal(9000.0), 3);
        Item item3 = new Item(new BigDecimal(900.0), 1);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        product.getItems().add(item1);
        product.getItems().add(item2);
        product.getItems().add(item3);

        //When
        invoiceDao.save(invoice);

        int invoiceID = invoice.getId();
        int productID = product.getId();
        //Then
        assertNotEquals(0,invoiceID);
        assertNotEquals(0,productID);
        //CleanUp
        invoiceDao.delete(invoice);
    }

}
