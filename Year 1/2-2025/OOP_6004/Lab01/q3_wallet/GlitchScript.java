package q3_wallet;

public class GlitchScript {
    static void q3_1() {
        Wallet myWallet = new Wallet();

        myWallet.coins = -999;

        System.out.println("Hacking complete.");
        System.out.println("Current Coins: " + myWallet.coins);
    }
}
