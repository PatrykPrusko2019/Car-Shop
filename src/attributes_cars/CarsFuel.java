package attributes_cars;

public enum CarsFuel {

    PETROL(0),
    DIESEL(10000),
    HYBRID(15000);

    int cars_fuel_price;

    CarsFuel(int cars_fuel_price){
        this.cars_fuel_price = cars_fuel_price;
    }

    public int getCars_fuel_price() {
        return cars_fuel_price;
    }


}
