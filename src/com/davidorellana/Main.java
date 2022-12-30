package com.davidorellana;

import com.davidorellana.booking.Booking;
import com.davidorellana.booking.PaymentMethods;
import com.davidorellana.booking.User;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        System.out.println("***** Booking System - 1 *****");
        LocalDateTime bookingEndDateOne = LocalDateTime.of(2023,2,2,15,30,32);
        Booking bookingOne = new Booking("hotel", LocalDateTime.now(), bookingEndDateOne, PaymentMethods.valueOf("BITCOIN"));
        User userOne = new User("Luis", "Orellana", "12346", "099999999", "luis@mail.com");
        System.out.println(userOne.createBooking(bookingOne));
        System.out.println(userOne.deleteBooking(bookingOne));

        System.out.println("***** Booking System - 2 *****");
        LocalDateTime bookingStartDateTwo = LocalDateTime.of(2022,12,30,15,30,32);
        LocalDateTime bookingEndDateTwo = LocalDateTime.of(2023,1,2,15,30,32);
        Booking bookingTwo = new Booking("medical appointment", bookingStartDateTwo, bookingEndDateTwo, PaymentMethods.valueOf("CASH"));
        User userTwo = new User("Felipe", "Calvache", "456799", "123456777", "felipe@mail.com");
        System.out.println(userTwo.createBooking(bookingTwo));
        System.out.println(userTwo.deleteBooking(bookingTwo));

    }
}
