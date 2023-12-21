package com.etiya.rentacar.business.messages;

public class CarBusinessMessages {
    public static final String EachBrandCanContainMaxTenCars = "Each brand can contains max 10 cars";
    public static final String CarShouldBeExists = "The car doesn't exist with id: ";
    public static final String CarCanNotBeSentMaintenanceWithStateMaintenance = "This car is already at maintenance";
    public static final String CarCanNotBeSentMaintenanceWithStateRented = "This car can not be sent to maintenance. Status: rented";
}
