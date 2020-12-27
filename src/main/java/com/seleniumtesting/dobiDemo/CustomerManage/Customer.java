package com.seleniumtesting.dobiDemo.CustomerManage;

public class Customer {

    //instance variables
    private String name;
    private String phone_number;
    private String description;
    private String starting_balance;

    //constructor
    public Customer(
            String name,
            String phone_number,
            String description,
            String starting_balance
    ){
        this.name=name;
        this.phone_number=phone_number;
        this.description=description;
        this.starting_balance=starting_balance;
    }

    //All getters
    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getDescription() {
        return description;
    }

    public String getStarting_balance() {
        return starting_balance;
    }

    //to.String() for logging or print purpose when a Customer is created
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", description='" + description + '\'' +
                ", starting_balance='" + starting_balance + '\'' +
                '}';
    }
}
