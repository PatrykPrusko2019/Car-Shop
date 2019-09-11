package carShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {

    private Scanner sc = new Scanner(System.in);
    private int wallet;
    private String name;
    private List<Car> listCarCustomer;
    private int counter_sample; // 3 attempt counter
    private int temporaryWallet;
    private boolean customerDecision;

    public Customer() {
        listCarCustomer = new ArrayList<>();
        this.counter_sample = 0;
        System.out.println("give me name my friend: ");
        this.name = sc.nextLine();

        System.out.println("welcome " + name + ", to the car dealerShip by Patryk Prusko: ");
        System.out.println("please, tell me how many money do you have by new car:  ");

        this.wallet = checksForTheCorrectValue(); // new customer wallet
        this.temporaryWallet = 0;
        this.customerDecision = false;
    }

    //checks that the correct value provided by the customer
    public int checksForTheCorrectValue() {
        boolean exit = false;
        int valueProvidedByTheCustomer = 0;
        while( ! exit) {
            exit = sc.hasNextInt();
            if(exit) {
                valueProvidedByTheCustomer = sc.nextInt();
            } else {
                System.out.println("wrong value... please again");
            }
            sc.nextLine();
        }
        return valueProvidedByTheCustomer;
    }

    public int getWallet(){
        return this.wallet;
    }

    public int getCounter(){
        return counter_sample;
    }

    public String getName() {
        return this.name;
    }

    public List<Car> getListCarCustomer (){
        return this.listCarCustomer;
    }

    public void setListCarCustomer(List<Car> newCar) {
        this.listCarCustomer = newCar;
    }

    public void setWallet(int wallet){
        this.wallet = wallet;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCounter(int counter){
        this.counter_sample = counter;
    }

    public boolean isCustomerDecision() {
        return customerDecision;
    }

    public void setCustomerDecision(boolean customerDecision) {
        this.customerDecision = customerDecision;
    }

    public boolean changeTemporaryWalletCustomer(int costNewCar) {
        if(this.temporaryWallet - costNewCar >= 0) {
            this.temporaryWallet -= costNewCar;
            return true;
        } else {
            this.counter_sample++;
            showCounterThreeAttempts();
            return false;
        }
    }


    public boolean threeAttemptstoBuyByTheCustomer() {
        if(counter_sample < 3) {
            return false;
        } else {
            System.out.println("three Attempts to Buy By The Customer !!!! Finish shopping ");
            System.exit(0);
            return true;
        }
    }

    public void showCounterThreeAttempts() {
        System.out.println("********************************\nthe number of buying attempts : " + counter_sample);
        System.out.println("\nat the third attempt to buy, the end of shopping\n********************************");
    }

    public int getCounter_sample() {
        return counter_sample;
    }

    public void setCounter_sample(int counter_sample) {
        this.counter_sample = counter_sample;
    }

    public int getTemporaryWallet() {
        return temporaryWallet;
    }

    public void setTemporaryWallet(int temporaryWallet) {
        this.temporaryWallet = temporaryWallet;
    }

}
