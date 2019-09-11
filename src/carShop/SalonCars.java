package carShop;

import attributes_cars.*;
import selectionOfDetails.ChoiceOfBodyCar;
import selectionOfDetails.ChoiceOfColor;
import selectionOfDetails.ChoiceOfFuel;
import selectionOfDetails.ChoiceOfUpholstery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SalonCars extends Salon  {
    private Customer customer;
    private List<Car> listSalonCars;
    private Car newCar;
    private boolean colorCars, bodyCars, upholsteryCars, fuel;

    public boolean isColorCars() {
        return colorCars;
    }
    public void setColorCars(boolean colorCars) {
        this.colorCars = colorCars;
    }

    public boolean isBodyCars() {
        return bodyCars;
    }
    public void setBodyCars(boolean bodyCars) {
        this.bodyCars = bodyCars;
    }
    public boolean isUpholsteryCars() {
        return upholsteryCars;
    }
    public void setUpholsteryCars(boolean upholsteryCars) {
        this.upholsteryCars = upholsteryCars;
    }
    public boolean isFuel() {
        return fuel;
    }
    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }

    public SalonCars(List<Car> carListAvailable){ // each time it assigns a new list of available cars to the customer

        listSalonCars = new ArrayList<>();
        listSalonCars = carListAvailable; // new car list in the salon
    }
    // selects the details of the car model
    public Car choiceOfModel(int choiceModelByCustomer, Customer newCustomer, SalonCars salonCars) {
    customer = newCustomer; // assigns a customer to customer

        newCar = new Car(); //default car
        newCar = listSalonCars.get(choiceModelByCustomer);

    System.out.println("***************************"+ "\n"+ "CHOOSE MODEL : " + "***************************");
        System.out.println("Temporary Wallet customer: " + customer.getTemporaryWallet() + " EURO");
        System.out.println("choose model : " + newCar.getName_model() + "\n" +
                "price : " + newCar.getPrice_car() + " EURO" +"\n");
        do{

            choiceOfDetails(newCar, salonCars);

            if( ! (colorCars && fuel && upholsteryCars && bodyCars) ) {

                if(newCar.getColorCars() == null) {
                    newCar.setColorCars(ColorCars.STANDARD_BLACK);
                    System.out.println("adds default color -> " + newCar.getColorCars().toString());
                }
                if(newCar.getCarsFuel() == null) {
                    newCar.setCarsFuel(CarsFuel.PETROL);
                    System.out.println("adds default fuel -> " + newCar.getCarsFuel().toString());
                }
                if(newCar.getUpholsteryCars() == null) {
                    newCar.setUpholsteryCars(UpholsteryCars.VELOR);
                    System.out.println("adds default upholstery -> " + newCar.getUpholsteryCars().toString());
                }
                if(newCar.getBodyCars() == null) {
                    newCar.setBodyCars(BodyCars.SEDAN);
                    System.out.println("adds default body cars -> " + newCar.getBodyCars().toString());
                }
            }

            customer.threeAttemptstoBuyByTheCustomer();

                showModelNewCar();

                isTheNewCarOk();

        }while(newCar == null);

        return newCar;
    }

    // does the customer want the car propositiona
    private void isTheNewCarOk() {
        Scanner sc = new Scanner(System.in);

        System.out.println("select : yes or no");
        boolean exit = false;
        while(! exit) {
            String str = sc.nextLine();
            switch (str) {
                case "yes": {
                    customer.setCustomerDecision(true);
                    exit = true;
                    break;
                }
                case "no": {
                    customer.setCustomerDecision(false);
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("wrong value, please again ...");
                    break;
                }
            }
        }
    }

    private void showModelNewCar() {
        System.out.println("***************************\n");
        System.out.println("Temporary Wallet customer: " + customer.getTemporaryWallet() + " EURO");
        System.out.println("choose model : " + newCar.getName_model() + "\n" +
                                  "price : " + newCar.getPrice_car() + " EURO" +"\n" +
                                  "color : " + newCar.colorCars.toString() + ",  COST: " + newCar.colorCars.getColorCars_price() + "\n" +
                               "bodyCars : " + newCar.bodyCars.toString()  + ", COST: " + newCar.bodyCars.getBodyCars_price()   + "\n" +
                         "upholsteryCars : " + newCar.getUpholsteryCars().toString() + ", COST: " + newCar.getUpholsteryCars().getUpholsteryCars_price() + "\n" +
                                   "fuel : " + newCar.getCarsFuel().toString() + ", COST: " + newCar.getCarsFuel().getCars_fuel_price() + "\n"
                          );
        System.out.println("***************************\n");
    }


    /** choice of car details */
    private Car choiceOfDetails(Car newCar, SalonCars salonCars) {
        int numberDetails;
        colorCars = false;
        fuel = false;
        upholsteryCars = false;
        bodyCars = false;
        ChoiceOfColor color = new ChoiceOfColor();
        ChoiceOfBodyCar bodyCar = new ChoiceOfBodyCar();
        ChoiceOfFuel fuelCar = new ChoiceOfFuel();
        ChoiceOfUpholstery upholstery = new ChoiceOfUpholstery();

        do {

            System.out.println("------------------------------------" + "\n" + "Temporary Wallet customer : " + customer.getTemporaryWallet() + " EURO");
            System.out.println("------------------------------------" + "\n" + "please choose the Details for new car: " + "\n" + "------------------------------------");
            int i = 1;
            for (Details d : Details.values()) {
                System.out.println((i++) + " " + d.toString());
            }
            System.out.println("0   - return and choose proposition new car ");

            System.out.println("Please choose the number");
            numberDetails = customer.checksForTheCorrectValue();

            switch (numberDetails) {
                case 1: {
                    if(! colorCars ) {
                        newCar = color.choiceOfColor(newCar, customer, salonCars);
                        customer.setCounter_sample(0); // resets the attempt counter
                    } else {
                        System.out.println("change not available. you have already chosen the color");
                    }
                    break;
                }

                case 2: {
                    if(! bodyCars ) {
                        newCar = bodyCar.choiceOfBodyCars(newCar, customer, salonCars);
                        customer.setCounter_sample(0);
                    } else {
                        System.out.println("change not available. you have already chosen the body cars");
                    }
                    break;
                }

                case 3: {
                    if(! fuel) {
                        newCar = fuelCar.choiceOfCarsFuel(newCar, customer, salonCars);
                        customer.setCounter_sample(0);
                    } else {
                        System.out.println("change not available. you have already chosen the fuel");
                    }
                    break;
                }

                case  4: {
                    if(! upholsteryCars) {
                        newCar = upholstery.choiceOfUpholstery(newCar, customer, salonCars);
                        customer.setCounter_sample(0);
                    } else {
                        System.out.println("change not available. you have already chosen the upholstery Cars");
                    }
                    break;
                }
                default: {
                    if(numberDetails != 0) {
                        System.out.println(" range 1 - 4, wrong value, please again ...");
                    }
                    break;
                }

            }

            if(colorCars && fuel && upholsteryCars && bodyCars) {
                System.out.println("***************************\nreturn because you have already chosen the details of all the new car\n***************************");
                break; // comes out because all the details of the new car have already been selected
            }

        }while ( (numberDetails != 0) && ( ! (customer.threeAttemptstoBuyByTheCustomer()) ) );


        return newCar;
    }

}
