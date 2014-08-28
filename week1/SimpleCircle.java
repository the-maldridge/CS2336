class SimpleCircle {
    double radius;

    SimpleCircle() {
	radius = 1;
    }

    SimpleCircle(double newRadius) {
	radius = newRadius;
    }

    double computeArea() {
	return radius * radius * Math.PI;
    }

    double computePerimeter() {
	return 2 * radius * Math.PI;
    }

    void setRadius(double newRadius) {
	radius = newRadius;
    }

    double getRadius() {
	return radius;
    }
}