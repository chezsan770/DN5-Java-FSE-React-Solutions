public class Main {
    static void main(String[] args) {
        PaymentProcessor upi = new UPIAdapter();
        upi.processPayment();

        PaymentProcessor bank = new BankAdapter();
        bank.processPayment();
    }
}
