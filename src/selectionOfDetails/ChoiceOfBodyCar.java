package selectionOfDetails;

import attributes_cars.BodyCars;
import carShop.Car;
import carShop.Customer;
import carShop.SalonCars;

/** body type choice */
public class ChoiceOfBodyCar {


    public Car choiceOfBodyCars(Car newCar, Customer customer, SalonCars salonCars) {
        System.out.println("------------------------------------" + "\n" + "please choose the Body Cars for new car: " + "\n" + "------------------------------------");
        int bodyCarsValue;
        int costBodyCarsValue;
        do {

            int i = 1;
            for (BodyCars bodyCars : BodyCars.values()) {
                System.out.println((i++) + ".   " + bodyCars.name() + " , price : " + bodyCars.getBodyCars_price() + " EURO");
            }
            System.out.println("0 - return and the default car body will be selected");
            System.out.println("Please choose the number");
            bodyCarsValue = customer.checksForTheCorrectValue();

            switch (bodyCarsValue) {
                case 1: {
                    costBodyCarsValue = BodyCars.SEDAN.getBodyCars_price();
                    if (customer.changeTemporaryWalletCustomer(costBodyCarsValue)) {
                        salonCars.setBodyCars(true);
                        newCar.setBodyCars(BodyCars.SEDAN);
                    } else {
                        System.out.println("you don't have money of the body cars ");
                    }


                    break;
                }
                case 2: {
                    costBodyCarsValue = BodyCars.PICKUP.getBodyCars_price();
                    if (customer.changeTemporaryWalletCustomer(costBodyCarsValue)) {
                        salonCars.setBodyCars(true);
                        newCar.setBodyCars(BodyCars.PICKUP);
                    } else {
                        System.out.println("you don't have money of the body cars ");
                    }

                    break;
                }

                case 3: {
                    costBodyCarsValue = BodyCars.HATCHBACK.getBodyCars_price();
                    if (customer.changeTemporaryWalletCustomer(costBodyCarsValue)) {
                        salonCars.setBodyCars(true);
                        newCar.setBodyCars(BodyCars.HATCHBACK);
                    } else {
                        System.out.println("you don't have money of the body cars ");
                    }
                    break;
                }

                case 4: {
                    costBodyCarsValue = BodyCars.COMBI.getBodyCars_price();
                    if (customer.changeTemporaryWalletCustomer(costBodyCarsValue)) {
                        salonCars.setBodyCars(true);
                        newCar.setBodyCars(BodyCars.COMBI);
                    } else {
                        System.out.println("you don't have money of the body cars ");
                    }
                    break;
                }

                default: {
                    if (bodyCarsValue != 0) {
                        System.out.println("Try again, you not choose a color car");
                    }
                    break;
                }
            }


        } while( (bodyCarsValue != 0) && (!customer.threeAttemptstoBuyByTheCustomer() && (! salonCars.isBodyCars()) ) );

        if(newCar.getBodyCars() == null) { // if nothing selected then we give the client default body cars
            newCar.setBodyCars(BodyCars.SEDAN);
            salonCars.setBodyCars(true);
            System.out.println("you didn't make a choice, I assign you the default body cars ...");
        }
        System.out.println("adds body cars -> " + newCar.getBodyCars().toString());

        return newCar;
    }
}
