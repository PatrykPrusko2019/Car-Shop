package carShop;

import java.util.ArrayList;
import java.util.List;

public class Salon{

    int cheapestPriceCar; //the cheapest price of the car
    List<Car> listCars;
    SalonCars salonCars;
    boolean doesHeHaveMoney = false;
    Customer customer;
    Car buyNewCarCustomer;


    /**choice model */
    public void customerChoice(){

        if(customer == null) { customer = new Customer(); }//if there is no customer then create a new one

        if(listCars == null) { createNewLisCars(); }//creates a new list of cars available in the salon

        doesHeHaveMoney = checkToWalletCustomer(customer.getWallet());
        exitProgram();//checks if no cash register
        boolean exit = false;
        int choiceOption;

        do { //shopping start


            System.out.println(" 0 - exit");
            System.out.println(" 1 - available cars in your wallet ");
            System.out.println(" 2 - show my new cars");
            System.out.println(" 3 - show my wallet ");
            choiceOption = customer.checksForTheCorrectValue();

            if(choiceOption == 1 && exit) { //if one is skipped
                int count = customer.getCounter_sample();
                customer.setCounter_sample(count + 1);
                System.out.println("you can't buy a car, stop trying");
                customer.showCounterThreeAttempts();
            } else {

                switch (choiceOption) {
                    case 0: {
                        System.out.println("bye bye " + customer.getName() + " , thank you for shopping !!!! ");
                        break;
                    }
                    case 1: {
                        System.out.println("***********************" + "/\n" + "CHOOSE NEW CAR : " + "\n" + "**************************");
                        System.out.println("Your money: " + customer.getWallet() + " EURO\n");

                        List<Car> carListAvailable = new ArrayList<>(); // new list of cars available to the customer
                        carListAvailable = carsForCustomer(listCars);
                        exitProgram();

                        int chooseNewCar = chooseNewCar(carListAvailable); // choosing a new car

                        salonCars = new SalonCars(carListAvailable); // sets a new list of available cars for the client
                        buyNewCarCustomer = salonCars.choiceOfModel(chooseNewCar, customer, salonCars);

                        if (customer.isCustomerDecision()) { //if the customer is yes

                            customer.setWallet(customer.getTemporaryWallet()); // changes the contents of the customer wallet
                            System.out.println("*******************\nadds new Car\n*******************");
                            customer.getListCarCustomer().add(buyNewCarCustomer); // adds new bought cars to the customer

                            listCars.remove(buyNewCarCustomer); // removes already selected car

                            cheapestPriceCar = lookingForCheapeastCarPrice(listCars);
                        } else {
                            System.out.println("********************\nyou resigned from buying, please choose another car\n********************");
                        }
                        break;
                    }

                    case 2: {
                        if (customer.getListCarCustomer().isEmpty()) {
                            System.out.println("empty list cars for customer, please choose one new car");
                        } else {
                            System.out.println("********************\nSHOW MY NEW CARS:\n********************\n");
                            int counter = 1;
                            for (Car car : customer.getListCarCustomer()) {
                                System.out.println((counter++) + "\n**********************\n" + "MODEL:        " + car.getName_model() + "\n" +
                                        "PRICE:        " + car.price_car + " EURO" + "\n" +
                                        "COLOR:        " + (null == car.getColorCars() ? "no choice color" : car.getColorCars() + ",  COST: " + car.getColorCars().getColorCars_price()) + "\n" +
                                        "FUEL :        " + (null == car.getCarsFuel() ? "no choice fuel" : car.getCarsFuel() + ",  COST: " + car.getCarsFuel().getCars_fuel_price()) + "\n" +
                                        "BODY OF CAR: " + (null == car.getBodyCars() ? "no choice body of car" : car.getBodyCars() + ", COST: " + car.getBodyCars().getBodyCars_price()) + "\n" +
                                        "UPHOLSTERY OF CAR: " + (null == car.getUpholsteryCars() ? "no Upholstery of car" : car.getUpholsteryCars() + ", COST: " + car.getUpholsteryCars().getUpholsteryCars_price()) + "\n");
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("your wallet -> " + customer.getWallet() + " EURO ");
                        break;
                    }
                    default: {
                        System.out.println("range 0 - 3, wrong value , please again !!!");
                    }
                }

            }

            if(choiceOption != 0) { // if the choice is 0, do not display this message
                if ((customer.getWallet() < cheapestPriceCar) && (!customer.threeAttemptstoBuyByTheCustomer())) {
                    System.out.println("***************************************\nno money for a new car, please select 0 to leave the store !!!\n***************************************");
                    exit = true;
                }
            }

        }while( (choiceOption != 0) && ( ! customer.threeAttemptstoBuyByTheCustomer()) ); //end of shopping

    }

    //new car choice by customer
    private int chooseNewCar(List<Car> carListAvailable) {
        System.out.println("******************\ncar list available: ");
        int i = 1;
        for(Car car : carListAvailable){
            System.out.println( (i++) + " model: " + car.getName_model() + ", cena : " + car.getPrice_car());
        }
        System.out.println("******************\n");
        boolean exit = false;
        int numberOfCar = 0;

        while (! exit) {
            System.out.println("enter the value: ");
            numberOfCar = customer.checksForTheCorrectValue();
            numberOfCar--;

            if (numberOfCar < carListAvailable.size() && numberOfCar >= 0) {

                  int costNewCar = carListAvailable.get(numberOfCar).getPrice_car();
                  customer.setTemporaryWallet(customer.getWallet()); // sets the value of the temporary wallet
                  customer.changeTemporaryWalletCustomer(costNewCar); // reduces the customer's wallet
                exit = true;

            } else {
                System.out.println("wrong value , please again !!!");
            }
        }
        return numberOfCar;
    }

    /**creates a new list of cars available in the salon */
    private void createNewLisCars() {
        listCars = new ArrayList<>();//tworzymy liste aut
        listCars.add(new Car("NISSAN", 32000));
        listCars.add(new Car("FIAT", 43000));
        listCars.add(new Car("SSANGYONG KYRON", 88000));
        listCars.add(new Car("HYUNDAI", 27000));
        listCars.add(new Car("FERRARI", 1000000));
        listCars.add(new Car("PEUGEOT", 8000));
    }

    private int lookingForCheapeastCarPrice(List<Car> listCars) {

            cheapestPriceCar = listCars.get(0).getPrice_car();
        for(Car car : listCars){
            if(car.getPrice_car() < cheapestPriceCar ){
                cheapestPriceCar = car.getPrice_car();
            }
        }

            return cheapestPriceCar;
    }


    /** checks if the end of the program */
    public void exitProgram() {
        if(!doesHeHaveMoney){ System.out.println("you don't have money, bye !!!"); System.exit(0); }//jak brak kasy to bye bye
    }


    /** checks available cars for the customer */
    private List<Car> carsForCustomer(List<Car> listCars) {

        List<Car> newListCarForCustomer = new ArrayList<>();

        for(Car car : listCars){
            if(car.getPrice_car() <= customer.getWallet()) { // if the wallet is larger then add a car
                newListCarForCustomer.add(car);
                doesHeHaveMoney = true;
            }
        }

        return newListCarForCustomer;
    }


    /**checks if the customer has money for any car model*/
    private boolean checkToWalletCustomer(int walletCustomer) {
        for(Car car : listCars){

            if(walletCustomer >= car.getPrice_car()){//wallet > than the cheapest car model
                doesHeHaveMoney = true;
            }
        }
        return doesHeHaveMoney;
    }

}
