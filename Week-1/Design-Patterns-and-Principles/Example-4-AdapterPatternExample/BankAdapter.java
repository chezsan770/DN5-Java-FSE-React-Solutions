public class BankAdapter implements PaymentProcessor {
    BankTransfer bt = new BankTransfer();

    @Override
    public void processPayment() {
        bt.transfer();
    }
}
