package com.davidorellana.booking;

import java.util.ArrayList;
import java.util.List;

public class User implements BookingService {

    private final Long id;
    private final String name;
    private final String lastName;
    private final String dni;
    private final String phone;
    private final String email;
    private static long incrementId = 1;

    private List<Booking> bookings = new ArrayList<>();

    public User(String name, String lastName, String dni, String phone, String email) {
        this.id = incrementId++;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDni() {
        return dni;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String createBooking(Booking booking) {
        String createdBooking = bookings.add(booking) ? "Reservation created successfully.\n" : "Error creating reservation.\n";
        return createdBooking + booking;
    }

    @Override
    public String deleteBooking(Booking booking) {
        if (bookings.isEmpty()) {
            return "There are no reservations to delete, it is empty.";
        } else {
            bookings.remove(booking);
            return "Booking with id " + booking.getId() + " removed.";
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
