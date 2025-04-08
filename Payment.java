public class Payment {
    protected double totalPrice;
    protected String paymentMethod;
    protected String paymentStatus;
    protected double discountPercentage = 0.0;


    public Payment(double totalPrice, String paymentMethod) {
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "Pending";
    }

    public void processPayment() {
        processPayment(this.paymentMethod);
    }

    public void processPayment(String method) {
        this.paymentMethod = method;
        switch (method.toLowerCase()) {
            case "credit card":
                paymentStatus = "Pembayaran Berhasil dengan Kartu Kredit";
                break;
            case "bank transfer":
                paymentStatus = "Pembayaran Berhasil dengan Transfer Bank";
                break;
            case "voucher diskon":
                paymentStatus = "Pembayaran Berhasil dengan Voucher Diskon";
                break;
            default:
                paymentStatus = "Pembayaran Gagal";
        }
    }

    public void setDiscount(double discountPercentage) {
        if (paymentMethod.equalsIgnoreCase("Voucher Diskon")) {
            this.discountPercentage = discountPercentage;
        }
    }

    public double getTotalAfterDiscount() {
        return totalPrice - (totalPrice * discountPercentage / 100);
    }

    public void showPaymentDetail() {
        System.out.println("Total Harga Sebelum Diskon: Rp " + String.format("%,.0f", totalPrice));
        if (paymentMethod.equalsIgnoreCase("Voucher Diskon")) {
            System.out.println("Voucher Diskon: " + discountPercentage + "%");
            System.out.println("Total Harga Setelah Diskon: Rp " + String.format("%,.0f", getTotalAfterDiscount()));
        }
        System.out.println("Metode Pembayaran: " + paymentMethod);
        System.out.println("Status Pembayaran: " + paymentStatus);
        System.out.println();
    }
}
