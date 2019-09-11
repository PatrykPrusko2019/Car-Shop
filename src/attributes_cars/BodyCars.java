package attributes_cars;

public enum BodyCars {

    SEDAN(0),
    PICKUP(2000),
    HATCHBACK(1000),
    COMBI(1000);

    int bodyCars_price;


    BodyCars(int bodyCars_price) {
        this.bodyCars_price = bodyCars_price;
    }



    public int getBodyCars_price() {
        return bodyCars_price;
    }

}
