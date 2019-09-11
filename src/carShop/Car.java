package carShop;

import attributes_cars.BodyCars;
import attributes_cars.CarsFuel;
import attributes_cars.ColorCars;
import attributes_cars.UpholsteryCars;

public class Car {

    String name_model;
    int price_car;
    ColorCars colorCars;
    BodyCars bodyCars;
    UpholsteryCars upholsteryCars;
    CarsFuel carsFuel;

    public Car(){ //default auto
        this.name_model = "Default model";
        this.price_car = 0;
        this.colorCars = null;
        this.upholsteryCars = null;
        this.carsFuel = null;
        this.bodyCars = null;

    }


    public Car(String name_model, int price_car){
        this.name_model = name_model;
        this.price_car = price_car;

    }

    public String getName_model(){
        return name_model;
    }

    public int getPrice_car(){
        return price_car;
    }

    public ColorCars getColorCars(){
        return colorCars;
    }

    public BodyCars getBodyCars(){
        return bodyCars;
    }
    public CarsFuel getCarsFuel(){
        return carsFuel;
    }

    public UpholsteryCars getUpholsteryCars(){
        return upholsteryCars;
    }

    public void setColorCars(ColorCars colorCars){
        this.colorCars = colorCars;
    }

    public void setBodyCars(BodyCars bodyCars){
        this.bodyCars = bodyCars;
    }

    public void setCarsFuel(CarsFuel carsFuel){
        this.carsFuel = carsFuel;
    }

    public void setUpholsteryCars(UpholsteryCars upholsteryCars){
        this.upholsteryCars = upholsteryCars;
    }




}
