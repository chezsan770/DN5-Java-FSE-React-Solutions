package com.dn5.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String customerName = "Sarthak";
        int orderId = 101;
        double orderAmount = 2499.99;

        logOrderDetails(customerName, orderId, orderAmount);
        logLowStockWarning("Java Book", 3);
    }

    private static void logOrderDetails(String customerName, int orderId, double orderAmount) {
        logger.info("Customer {} placed order {} with amount {}", customerName, orderId, orderAmount);
    }

    private static void logLowStockWarning(String productName, int availableQuantity) {
        logger.warn("Product {} has only {} items left in stock", productName, availableQuantity);
    }
}
