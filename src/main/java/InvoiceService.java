public class InvoiceService {

    // Fatura ödeme
    public void payingBills(MemberAccount account, Invoice invoice) throws CustomException {
        if (account.getBalance() >= invoice.getAmount()) {
            double newBalance = account.getBalance() - invoice.getAmount();
            account.setBalance(newBalance);
            System.out.println("Ödeme yapıldı. Yeni bakiye: " + newBalance);
        } else {
            throw new CustomException("Yetersiz bakiye !");
        }
    }

    // Fatura sorgulama
    public void queryInvoice(MemberAccount account, Invoice invoice) {
        System.out.println("Fatura Sorgulama: " + invoice);
    }

    // Fatura iptali
    public void cancelPayment(MemberAccount account, Invoice invoice) throws CustomException {
        double newBalance = account.getBalance() + invoice.getAmount();
        account.setBalance(newBalance);
        System.out.println("Ödeme iptal edildi. Yeni bakiye: " + newBalance);
    }
}
