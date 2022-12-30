package com.davidorellana.booking;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Booking {

    private final Long id;
    private final String typeBooking;
    private final LocalDateTime bookingStartDate;
    private final LocalDateTime bookingEndDate;
    private final PaymentMethods paymentMethods;
    private static long incrementId = 1;

    public Booking(String typeBooking, LocalDateTime bookingStartDate, LocalDateTime bookingEndDate, PaymentMethods paymentMethods) {
        this.id = incrementId++;
        this.typeBooking = typeBooking;
        this.bookingStartDate = getBookingStartDate(bookingStartDate);
        this.bookingEndDate = getBookingEndDate(bookingEndDate);
        this.paymentMethods = getPaymentMethods(paymentMethods);
    }

    private LocalDateTime getBookingStartDate(LocalDateTime bookingStartDate) {
        LocalDateTime dateTimeNow = LocalDateTime.now().minusDays(1);
        if (bookingStartDate.isAfter(dateTimeNow)) {
            return bookingStartDate;
        } else {
            throw new DateTimeParseException("Inconsistent initial booking date.", "error", 0);
        }
    }

    private LocalDateTime getBookingEndDate(LocalDateTime bookingEndDate) {
        LocalDateTime dateTimeNow = LocalDateTime.now().minusDays(1);
        if (bookingEndDate.isAfter(dateTimeNow) && bookingEndDate.isAfter(bookingStartDate)) {
            return bookingEndDate;
        } else {
            throw new DateTimeParseException("Inconsistent final booking date.", "error", 0);
        }
    }

    private PaymentMethods getPaymentMethods(PaymentMethods paymentMethods) {
        switch (paymentMethods) {
            case CASH:
                System.out.println("Successful reservation with CASH payment.");
                break;
            case CARD:
                System.out.println("Successful reservation with CARD payment.");
                break;
            case PAYPAL:
                System.out.println("Successful reservation with PAYPAL payment.");
                break;
            case ALIPAY:
                System.out.println("Successful reservation with ALIPAY payment.");
                break;
            case BITCOIN:
                System.out.println("Successful reservation with BITCOIN payment.");
                break;
        }
        return paymentMethods;
    }

    public Long getId() {
        return id;
    }

    public String getTypeBooking() {
        return typeBooking;
    }

    public LocalDateTime getBookingStartDate() {
        return bookingStartDate;
    }

    public LocalDateTime getBookingEndDate() {
        return bookingEndDate;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", typeBooking='" + typeBooking + '\'' +
                ", bookingStartDate=" + bookingStartDate +
                ", bookingEndDate=" + bookingEndDate +
                ", paymentMethods=" + paymentMethods +
                '}';
    }
}
