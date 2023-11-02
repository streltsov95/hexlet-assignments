package exercise;

// BEGIN
class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return this.area + this.balconyArea;
    }

    public int compareTo(Home apartment) {
        return Double.compare(getArea(), apartment.getArea());
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
