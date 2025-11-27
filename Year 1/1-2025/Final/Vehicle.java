class Vehicle {
    private String model;
    private int speed;
    private int capacity;

    Vehicle(String model, int speed, int capacity) {
        this.model = model;
        this.speed = speed;
        this.capacity = capacity;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int capSpeed() {
        return capacity * speed;
    }
}
