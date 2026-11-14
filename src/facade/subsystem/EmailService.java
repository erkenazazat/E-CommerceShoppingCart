package facade.subsystem;

public class EmailService {
    public void sendConfirmation(String customer, int orderId) {
        System.out.printf("[Email] Confirmation of order #%d sent to %s%n", orderId, customer);
    }
}