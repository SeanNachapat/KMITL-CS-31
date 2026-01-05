public enum MemberTypeWithDiscount {
    NONE(0.0, 0.0),
    SILVER(0.05, 0.05),
    GOLD(0.10, 0.20),
    PREMIUM(0.30, 0.45);

    private double productDiscountRate;
    private double serviceDiscountRate;

    MemberTypeWithDiscount(double productDiscountRate, double serviceDiscountRate) {
        this.productDiscountRate = productDiscountRate;
        this.serviceDiscountRate = serviceDiscountRate;
    }

    public double getProductDiscountRate() {
        return productDiscountRate;
    }

    public double getServiceDiscountRate() {
        return serviceDiscountRate;
    }
}
