class Car {

    int yearModel;
    String make;
    int speed;

    public void accelerate() {
        this.speed += 5;
    }

    public void brake() {
        this.speed = this.speed < 0 ? 0 : this.speed - 5;
    }
}