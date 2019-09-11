package attributes_cars;

public enum UpholsteryCars {

    VELOR(0),
    LEATHER(1000),
    QUILTED_LEATHER(2000);

    int upholsteryCars_price;

    UpholsteryCars(int upholsteryCars_price){
        this.upholsteryCars_price = upholsteryCars_price;
    }

    public int getUpholsteryCars_price() {
        return upholsteryCars_price;
    }

}
