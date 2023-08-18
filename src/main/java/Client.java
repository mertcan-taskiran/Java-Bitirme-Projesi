import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberAccountService accountService = new MemberAccountService();
        InvoiceService invoiceService = new InvoiceService();

        // Kullanıcıdan girişleri al ve işlemleri yap
        System.out.println("Hoş geldiniz!");

        while (true) {
            // Kullanıcı seçim
            System.out.println("\n1. Hesap Oluştur\n2. Hesap Sorgula\n3. Hesap Güncelle\n4. Hesap Sil\n5. Fatura Ödeme\n6. Fatura Sorgulama\n7. Fatura İptali\n8. Çıkış");
            System.out.print("Yapmak istediğiniz işlemi seçin: ");
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {

                case 1:
                    // Yeni hesap
                    System.out.print("Adınız: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Soyadınız: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Hesap Kodunuz: ");
                    String code = scanner.nextLine();
                    double initialBalance = 0; // İlk bakiye
                    MemberAccount newAccount = new MemberAccount(accountService.generateUniqueId(), firstName, lastName, code, initialBalance);
                    accountService.createMemberAccount(newAccount);
                    break;

                case 2:
                    // Hesap sorgulama
                    System.out.print("Hesap ID giriniz:: ");
                    int accountId = scanner.nextInt();
                    MemberAccount queriedAccount = accountService.getMemberAccount(accountId);
                    System.out.println("Hesap Bilgileri: " + queriedAccount);
                    break;

                case 3:
                    // Hesap güncelleme
                    System.out.print("Hesap ID giriniz: ");
                    int accountToUpdateId = scanner.nextInt();
                    MemberAccount accountToUpdate = accountService.getMemberAccount(accountToUpdateId);
                    if (accountToUpdate != null) {
                        System.out.print("Yeni bakiye: ");
                        double newBalance = scanner.nextDouble();
                        accountToUpdate.setBalance(newBalance);
                        accountService.updateMemberAccount(accountToUpdate);
                    } else {
                        System.out.println("Hesap bulunamadı !");
                    }
                    break;

                case 4:
                    // Hesap silme
                    System.out.print("Hesap ID giriniz: ");
                    int accountToDeleteId = scanner.nextInt();
                    MemberAccount accountToDelete = accountService.getMemberAccount(accountToDeleteId);
                    if (accountToDelete != null) {
                        accountService.deleteMemberAccount(accountToDeleteId);
                    } else {
                        System.out.println("Hesap bulunamadı !");
                    }
                    break;

                case 5:
                    // Fatura ödeme
                    System.out.print("Hesap ID giriniz: ");
                    int accountID = scanner.nextInt();
                    MemberAccount selectedAccount = accountService.getMemberAccount(accountID);
                    System.out.print("Fatura Miktarı: ");
                    double invoiceAmount = scanner.nextDouble();
                    System.out.print("Fatura Tipi (1-Telefon, 2-Internet, 3-Su): ");
                    int billType = scanner.nextInt();
                    Invoice newInvoice = new Invoice(invoiceAmount, new Date(), billType);
                    try {
                        invoiceService.payingBills(selectedAccount, newInvoice);
                    } catch (CustomException e) {
                        System.out.println("Hata: " + e.getMessage());
                    }
                    break;

                case 6:
                    // Fatura sorgulama
                    System.out.print("Hesap ID giriniz: ");
                    int accountToQueryId = scanner.nextInt();
                    MemberAccount accountToQuery = accountService.getMemberAccount(accountToQueryId);
                    if (accountToQuery != null) {
                        System.out.print("Fatura Tipi (1-Telefon, 2-Internet, 3-Su): ");
                        int queriedBillType = scanner.nextInt();
                        Invoice queriedInvoice = new Invoice(0, null, queriedBillType);
                        invoiceService.queryInvoice(accountToQuery, queriedInvoice);
                    } else {
                        System.out.println("Hesap bulunamadı !");
                    }
                    break;

                case 7:
                    // Fatura iptal
                    System.out.print("Hesap ID giriniz: ");
                    int accountToCancelPaymentId = scanner.nextInt();
                    MemberAccount accountToCancelPayment = accountService.getMemberAccount(accountToCancelPaymentId);
                    if (accountToCancelPayment != null) {
                        System.out.print("İptal Edilecek Fatura Miktarı: ");
                        double cancelledInvoiceAmount = scanner.nextDouble();
                        System.out.print("Fatura Tipi (1-Telefon, 2-Internet, 3-Su): ");
                        int cancelBillType = scanner.nextInt();

                        Invoice invoiceToCancel = new Invoice(cancelledInvoiceAmount, new Date(), cancelBillType);

                        try {
                            invoiceService.cancelPayment(accountToCancelPayment, invoiceToCancel);
                        } catch (CustomException e) {
                            System.out.println("Hata: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Hesap bulunamadı !");
                    }
                    break;

                case 8:
                    System.out.println("Programdan çıkılıyor...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Geçersiz seçenek, lütfen tekrar deneyin.");
                    break;
            }
        }
    }
}