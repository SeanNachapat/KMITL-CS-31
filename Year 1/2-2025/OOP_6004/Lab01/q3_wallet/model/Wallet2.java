package q3_wallet.model;

public class Wallet2 {
    public int coins;

    public void setCoins(int newCoins) {
        if (newCoins < 0) {
            System.out.println("Not Allow!!");
        } else {
            this.coins = newCoins;
        }
    }
}