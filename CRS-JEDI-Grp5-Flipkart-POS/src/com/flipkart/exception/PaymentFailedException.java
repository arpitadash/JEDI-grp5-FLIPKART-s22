package com.flipkart.exception;

/*
 * Exception arises when payment is failed.
 */
public class PaymentFailedException extends Exception {

    public String getMessage() {
        return "Payment was not successful ! Please try again";
    }
}