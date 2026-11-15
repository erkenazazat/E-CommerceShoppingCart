package facade.subsystem;

public class PaymentService {

    public boolean pay(double amount) {
        System.out.println("Payment of " + amount + " processed successfully.");
        return true;
    }
}