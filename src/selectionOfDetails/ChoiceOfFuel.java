package selectionOfDetails;

import attributes_cars.CarsFuel;
import carShop.Car;
import carShop.Customer;
import carShop.SalonCars;

/** choice of car fuel */
public class ChoiceOfFuel {

    public Car choiceOfCarsFuel(Car newCar, Customer customer, SalonCars salonCars) {
        System.out.println("------------------------------------" + "\n" + "please choose the Fuel Cars for new car: " + "\n" + "------------------------------------");
        int fuelCarsValue;
        int costFuelCars;
        do {

            int i = 1;
            for (CarsFuel carsFuel : CarsFuel.values()) {
                System.out.println((i++) + ".   " + carsFuel.name() + " , price : " + carsFuel.getCars_fuel_price() + " EURO");
            }
            System.out.println("0 - return and the default car fuel will be selected");
            System.out.println("Please choose the number");
            fuelCarsValue = customer.checksForTheCorrectValue();

            switch (fuelCarsValue) {
                case 1: {
                    costFuelCars = CarsFuel.PETROL.getCars_fuel_price();
                    if(customer.changeTemporaryWalletCustomer(costFuelCars)) {
                        salonCars.setFuel(true);
                        newCar.setCarsFuel(CarsFuel.PETROL);
                    } else {
                        System.out.println("you don't have money of the fuel ");
                    }

                    break;
                }
                case 2: {
                    costFuelCars = CarsFuel.DIESEL.getCars_fuel_price();
                    if(customer.changeTemporaryWalletCustomer(costFuelCars)) {
                        salonCars.setFuel(true);
                        newCar.setCarsFuel(CarsFuel.DIESEL);
                    } else {
                        System.out.println("you don't have money of the fuel ");
                    }
                    break;
                }

                case 3: {
                    costFuelCars = CarsFuel.HYBRID.getCars_fuel_price();
                    if(customer.changeTemporaryWalletCustomer(costFuelCars)) {
                        salonCars.setFuel(true);
                        newCar.setCarsFuel(CarsFuel.HYBRID);
                    } else {
                        System.out.println("you don't have money of the fuel ");
                    }
                    break;
                }

                default: {
                    if(fuelCarsValue != 0) {
                        System.out.println("Try again, you not choose a fuel");
                    }
                    break;
                }
            }

        } while( (fuelCarsValue != 0) && (! customer.threeAttemptstoBuyByTheCustomer()) && (! salonCars.isFuel() ) );

        if(newCar.getCarsFuel() == null) {
            newCar.setCarsFuel(CarsFuel.PETROL); //default fuel
            salonCars.setFuel(true);
            System.out.println("you didn't make a choice, I assign you the default fuel ...");
        }
        System.out.println("adds fuel -> " + newCar.getCarsFuel().toString());

        return newCar;

    }
}
