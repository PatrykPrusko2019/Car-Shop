package selectionOfDetails;

import attributes_cars.ColorCars;
import carShop.Car;
import carShop.Customer;
import carShop.SalonCars;

/** choice of car color*/
public class ChoiceOfColor {


    public Car choiceOfColor(Car newCar, Customer customer, SalonCars salonCars) {

        System.out.println("------------------------------------" + "\n" + "please choose the COLOR for new car: " + "\n" + "------------------------------------");

        int colorValue;
        do {
            int costColor;
            int i = 1;
            for (ColorCars color : ColorCars.values()) {
                System.out.println((i++) + ".   " + color.name() + " , price : " + color.getColorCars_price() + " EURO");
            }
            System.out.println("0 - return and the default car color will be selected");

            System.out.println("Please choose the number");
            colorValue = customer.checksForTheCorrectValue();

            switch (colorValue) {
                case 1: {
                    costColor = ColorCars.STANDARD_WHITE.getColorCars_price();
                    if (customer.changeTemporaryWalletCustomer(costColor)) {
                        salonCars.setColorCars(true);
                        newCar.setColorCars(ColorCars.STANDARD_WHITE);
                    } else {
                        System.out.println("you don't have money of the color ");
                    }

                    break;
                }
                case 2: {
                    costColor = ColorCars.STANDARD_BLACK.getColorCars_price();
                    if (customer.changeTemporaryWalletCustomer(costColor)) {
                        salonCars.setColorCars(true);
                        newCar.setColorCars(ColorCars.STANDARD_BLACK);
                    } else {
                        System.out.println("you don't have money of the color");
                    }


                    break;
                }

                case 3: {
                    costColor = ColorCars.PREMIUM_GREEN.getColorCars_price();
                    if (customer.changeTemporaryWalletCustomer(costColor)) {
                        salonCars.setColorCars(true);
                        newCar.setColorCars(ColorCars.PREMIUM_GREEN);
                    } else {
                        System.out.println("you don't have money of the color");
                    }

                    break;
                }

                case 4: {
                    costColor = ColorCars.PREMIUM_GRAY.getColorCars_price();
                    if (customer.changeTemporaryWalletCustomer(costColor)) {
                        salonCars.setColorCars(true);
                        newCar.setColorCars(ColorCars.PREMIUM_GRAY);
                    } else {
                        System.out.println("you don't have money of the color");
                    }
                    break;
                }

                default: {
                    if(colorValue != 0) {
                        System.out.println("Try again, you not choose a color car");
                    }
                    break;
                }
            }


        } while( (colorValue != 0) && (! customer.threeAttemptstoBuyByTheCustomer() ) && (!salonCars.isColorCars() ) ); //jesli threeAttemptstoBuyByTheCustomer()-> zwroci false to wychodzmy

        if(newCar.getColorCars() == null) {
            newCar.setColorCars(ColorCars.STANDARD_BLACK); //default color
            salonCars.setColorCars(true);
            System.out.println("you didn't make a choice, I assign you the default color ...");
        }
        System.out.println("adds car color -> " + newCar.getColorCars().toString());

        return newCar;
    }
}
