public class Client {
    private String name;
    private MemberTypeWithDiscount memberType;

    public Client(String name) {
        this.name = name;
        this.memberType = MemberTypeWithDiscount.NONE;
    }

    public void spend(int direction) {
        if (direction > 0) {
            promoteMemberType();
        } else if (direction < 0) {
            demoteMemberType();
        }
        showMembershipStatus();
    }

    private void promoteMemberType() {
        switch (memberType) {
            case NONE:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.PREMIUM;
                break;
            case PREMIUM:
                break;
        }
    }

    private void demoteMemberType() {
        switch (memberType) {
            case PREMIUM:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER:
                break;
            case NONE:
                break;
        }
    }

    public void showMembershipStatus() {
        System.out.println(name + " is now " + memberType + " " +
                (int) (memberType.getProductDiscountRate() * 100) + "% discount on Product " +
                (int) (memberType.getServiceDiscountRate() * 100) + "% discount on Service");
    }
}
