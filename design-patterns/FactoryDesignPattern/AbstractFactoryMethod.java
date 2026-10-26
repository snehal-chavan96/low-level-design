package FactoryDesignPattern;

// Abstract Product A
interface UPIPayment{
    void pay(double payment);
}

// Abstract Product B 
interface PaymentNotification{
    void sendNotification(double amount);
}

// Concrete Product A1
class GooglePayPayment implements UPIPayment{
    public void pay(double amount){
        System.out.println("Google Pay Processing payment: ₹"+amount);
    }
}

// Concrete Product A2
class PhonePePayment implements UPIPayment{
    public void pay(double amount){
        System.out.println("PhonePe processing payment: ₹" + amount);
    }
}

// Concrete Product B1
class GooglePayNotification implements PaymentNotification{
    public void sendNotification(double amount){
        System.out.println("Google Pay notification: Payment of ₹" + amount + "completed.");
    }
}

// Concrete Product B2
class PhonePeNotification implements PaymentNotification{
    public void sendNotification(double amount){
        System.out.println("PhonePe notification: Payment of ₹" + amount + " completed.");
    }
}

// Abstract Factory
interface UPIServiceFactory{
    UPIPayment createPayment();

    PaymentNotification createNotification();
}


// Concrete Factory 1
class GooglePayFactory implements UPIServiceFactory{
    public UPIPayment createPayment(){
        return new GooglePayPayment();
    }

    public PaymentNotification createNotification(){
        return new GooglePayNotification();
    }
}

// Concrete Factory 2
class PhonePeFactory implements UPIServiceFactory{
    public UPIPayment createPayment(){
        return new PhonePePayment();
    }

    public PaymentNotification createNotification(){
        return new PhonePeNotification();
    }
}

// Client Service
class PaymentService{
    private final UPIPayment payment;
    private final PaymentNotification notification;

    public PaymentService(UPIServiceFactory factory){
        this.payment = factory.createPayment();
        this.notification = factory.createNotification();
    }

    public void makePayment(double amount){
        payment.pay(amount);
        notification.sendNotification(amount);
    }
}


// Main Class
public class AbstractFactoryMethod {

    public static void main(String[] args) {
        // Use Goolge Pay Family
        UPIServiceFactory factory = new GooglePayFactory();
        PaymentService service = new PaymentService(factory);

        service.makePayment(500);

        System.out.println();

        // Use PhonePe Family
        factory = new PhonePeFactory();
        service = new PaymentService(factory);

        service.makePayment(1000);
    }
}
