package attributes_cars;

public enum Details {

    COLOR(1, 2, 3, 4),
    BodyCars(1, 2, 3, 4),
    CarsFuel(1, 2, 3, 4),
    UpholsteryCars(1, 2, 3, 4);

    int first;
    int second;
    int third;
    int fourth;


    Details(int first, int second, int third, int fourth) {

        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

}
