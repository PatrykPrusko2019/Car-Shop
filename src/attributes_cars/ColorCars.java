package attributes_cars;

public enum ColorCars {
    STANDARD_WHITE(0),
    STANDARD_BLACK(0),
    PREMIUM_GREEN(500),
    PREMIUM_GRAY(1000);

    int cost_colorCars;

    ColorCars(int cost_colorCars){//construktor
        this.cost_colorCars = cost_colorCars;
    }


    public int getColorCars_price() {
        return cost_colorCars;
    }


}
