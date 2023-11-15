package exercise;

// BEGIN
class Circle {
    private Point circleCenter;
    private int circleRadius;

    Circle(Point circleCenter, int circleRadius) {
        this.circleCenter = circleCenter;
        this.circleRadius = circleRadius;
    }

    public int getCircleRadius() {
        return circleRadius;
    }
    public double getSquare() throws NegativeRadiusException {
        if (getCircleRadius() < 0) {
            throw new NegativeRadiusException("Radius can not be negative");
        }
        return Math.PI * Math.pow(circleRadius, 2);
    }
}
// END
