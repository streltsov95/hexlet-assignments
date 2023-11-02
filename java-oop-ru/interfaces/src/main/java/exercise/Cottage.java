package exercise;

// BEGIN
class Cottage implements Home {
    private double area;
    private int floorCount;

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return this.area;
    }

    public int compareTo(Home apartment) {
        return Double.compare(getArea(), apartment.getArea());
    }

    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }
}
// END
