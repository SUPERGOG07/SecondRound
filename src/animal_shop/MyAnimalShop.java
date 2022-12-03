package animal_shop;

import animal_shop.exception.AnimalNotFoundException;
import animal_shop.exception.InsufficientBalanceException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop{

    private double balance;

    private ArrayList<Animal> animals;

    private ArrayList<CustomerInfo> customers;

    private boolean isClosed;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<CustomerInfo> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<CustomerInfo> customers) {
        this.customers = customers;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public MyAnimalShop() {
        this.balance = 200.0;
        this.animals = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.isClosed = true;
    }

    @Override
    public void open() {
        this.isClosed = false;
        System.out.println("店铺开张啦==========================================================================");
    }

    @Override
    public void buyNewAnimal(Animal animal) {
        try{
            if(animal.getBidPrice()>this.balance){
                throw new InsufficientBalanceException(String.format("店内余额不足|购买失败-->{%s}",animal));
            }else {
                this.balance-= animal.getBidPrice();
                this.animals.add(animal);
                System.out.printf("购买成功-->{%s}%n",animal);
            }
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void entertainCustomers(Customer customer) {
        if(this.isClosed){
            System.out.println("店铺尚未开张,不能接客");
            return;
        }
        try {
            LocalDate date = LocalDate.now();
            customer.setFrequency(customer.getFrequency()+1);
            customer.setLastTime(date);
            if(animals.isEmpty()){
                throw new AnimalNotFoundException("店里没有动物了");
            }else {
                Animal sell = animals.remove(0);
                System.out.printf("卖出-->{%s}%n",sell);
                this.balance+= sell.getPrice();
                this.customers.add(new CustomerInfo(customer,sell.getPrice()-sell.getBidPrice(),date));
            }
        }catch (AnimalNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() {
        LocalDate date = LocalDate.now();
        this.isClosed = true;
        double profit = 0.0;
        for (CustomerInfo customerInfo:this.customers){
            if(date.getDayOfYear()==customerInfo.getDate().getDayOfYear()){
                System.out.println(customerInfo.getCustomer());
                profit += customerInfo.getProfit();
            }
        }
        System.out.printf("%s的收入-->%.2f%n",date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),profit);
        System.out.println("店铺关门了==========================================================================");
    }
}


class CustomerInfo{ //用作记录的用户信息类
    private Customer customer;
    private double profit;
    private LocalDate date;

    public CustomerInfo(Customer customer, double profit, LocalDate date) {
        this.customer = customer;
        this.profit = profit;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
