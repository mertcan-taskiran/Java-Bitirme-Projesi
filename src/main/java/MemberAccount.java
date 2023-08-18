public class MemberAccount {
    private int id; // Hesap ID'si
    private String firstName; // Hesap sahibinin adı
    private String lastName; // Hesap sahibinin soyadı
    private String code; // Hesap kodu
    private double balance; // Hesap bakiyesi

    // constructor
    public MemberAccount(int id, String firstName, String lastName, String code, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.balance = balance;
    }

    // getters, setters

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCode() {
        return code;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  "\n*******************" +
                "\nID: " + id +
                "\nAdı: '" + firstName + '\'' +
                "\nSoyadı: '" + lastName + '\'' +
                "\nHesap Kodu: '" + code + '\'' +
                "\nBakiye: " + balance +
                "\n*******************";
    }
}
