class IKLCMartPayment extends Payment {
    public IKLCMartPayment(double totalPrice, String paymentMethod) {
        super(totalPrice, paymentMethod);
    }
}

public class Main {
    public static void main(String[] args) {
        // Case Siti
        IKLCMartPayment siti = new IKLCMartPayment(3500000, "Credit Card");
        siti.processPayment();  
        siti.showPaymentDetail();

        // Case Ciciripi
        IKLCMartPayment ciciripi = new IKLCMartPayment(10000000, "Voucher Diskon");
        ciciripi.setDiscount(15); // diskon 15%
        ciciripi.processPayment();
        ciciripi.showPaymentDetail();

        // Case Asnawi
        IKLCMartPayment asnawi = new IKLCMartPayment(1200000, "Bank Transfer");
        asnawi.processPayment();  
        asnawi.showPaymentDetail();
    }
}
