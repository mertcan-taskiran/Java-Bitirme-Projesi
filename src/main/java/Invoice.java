import java.util.Date;

public class Invoice {
    private double amount; // Fatura miktarı
    private Date process_date; // İşlem tarihi
    private int bill_type; // Fatura tipi (1-Telefon, 2-Internet, 3-Su)

    // Constructor
    public Invoice(double amount, Date processDate, int bill_type) {
        this.amount = amount;
        this.process_date = processDate;
        this.bill_type = bill_type;
    }

    // Getter metotları
    public double getAmount() {
        return amount;
    }

    public Date getProcessDate() {
        return process_date;
    }

    public int getBillType() {
        return bill_type;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "amount=" + amount +
                ", processDate=" + process_date +
                ", billType=" + bill_type +
                '}';
    }
}