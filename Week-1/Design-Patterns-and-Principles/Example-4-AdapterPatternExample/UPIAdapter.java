public class UPIAdapter implements PaymentProcessor{
    UPIPayment payment = new UPIPayment();
    @Override
    public void processPayment() {
        payment.ScanQR();
    }
}
