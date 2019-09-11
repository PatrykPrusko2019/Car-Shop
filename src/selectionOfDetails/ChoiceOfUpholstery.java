package selectionOfDetails;

import attributes_cars.UpholsteryCars;
import carShop.Car;
import carShop.Customer;
import carShop.SalonCars;

/** choice of car upholstery  */
public class ChoiceOfUpholstery {

        public Car choiceOfUpholstery(Car newCar, Customer customer, SalonCars salonCars) {
            System.out.println("------------------------------------" + "\n" + "please choose the Fuel Cars for new car: " + "\n" + "------------------------------------");
            int upholsteryValue;
            int costUpholsteryValue;
            do {

                int i = 1;
                for (UpholsteryCars upholsteryCars : UpholsteryCars.values()) {
                    System.out.println((i++) + ".   " + upholsteryCars.name() + " , price : " + upholsteryCars.getUpholsteryCars_price() + " EURO");
                }
                System.out.println("0 - return and the default car upholstery will be selected");

                System.out.println("Please choose the number");
                upholsteryValue = customer.checksForTheCorrectValue();

                switch (upholsteryValue) {
                    case 1: {
                        costUpholsteryValue = UpholsteryCars.VELOR.getUpholsteryCars_price();
                        if(customer.changeTemporaryWalletCustomer(costUpholsteryValue)) {
                            salonCars.setUpholsteryCars(true);
                            newCar.setUpholsteryCars(UpholsteryCars.VELOR);
                        } else {
                            System.out.println("you don't have money of the upholstery cars");
                        }

                        break;
                    }
                    case 2: {
                        costUpholsteryValue = UpholsteryCars.LEATHER.getUpholsteryCars_price();
                        if(customer.changeTemporaryWalletCustomer(costUpholsteryValue)) {
                            salonCars.setUpholsteryCars(true);
                            newCar.setUpholsteryCars(UpholsteryCars.LEATHER);
                        } else {
                            System.out.println("you don't have money of the upholstery cars");
                        }
                        break;
                    }

                    case 3: {
                        costUpholsteryValue = UpholsteryCars.QUILTED_LEATHER.getUpholsteryCars_price();
                        if(customer.changeTemporaryWalletCustomer(costUpholsteryValue)) {
                            salonCars.setUpholsteryCars(true);
                            newCar.setUpholsteryCars(UpholsteryCars.QUILTED_LEATHER);
                        } else {
                            System.out.println("you don't have money of the upholstery cars");
                        }
                        break;
                    }

                    default: {
                        if(upholsteryValue != 0) {
                            System.out.println("Try again, you not choose a color car");
                        }
                    }
                }

            } while( (upholsteryValue != 0) && (! customer.threeAttemptstoBuyByTheCustomer()) && (! salonCars.isUpholsteryCars() ) );

            if(newCar.getUpholsteryCars() == null) {
                newCar.setUpholsteryCars(UpholsteryCars.VELOR); // default upholstery
                salonCars.setUpholsteryCars(true);
                System.out.println("you didn't make a choice, I assign you the default Upholstery Cars ...");
            }
            System.out.println("adds Upholstery Cars -> " + newCar.getUpholsteryCars().toString());

            return newCar;
        }

}
