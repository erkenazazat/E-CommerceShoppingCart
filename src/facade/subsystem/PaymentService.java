package facade.subsystem;

public class PaymentService {
    public boolean charge(String customer, double amount) {
        System.out.printf("[Payment] Charged %.2f from customer %s%n", amount, customer);
        return true;
    }
}