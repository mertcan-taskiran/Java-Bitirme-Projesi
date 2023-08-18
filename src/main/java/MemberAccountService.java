import java.util.HashMap;
import java.util.Map;

public class MemberAccountService {
    private Map<Integer, MemberAccount> accounts = new HashMap<>();
    private int accountIdCounter = 1; // Başlangıç ID

    // Hesap oluşturma
    public void createMemberAccount(MemberAccount account) {
        accounts.put(account.getId(), account);
        System.out.println("Hesap oluşturuldu: " + account);
    }

    // Benzersiz bir hesap IDsi oluşturma
    public int generateUniqueId() {
        return accountIdCounter++;
    }

    // Belirli bir IDye sahip hesabı getirme
    public MemberAccount getMemberAccount(int id) {
        return accounts.get(id);
    }

    // Hesap güncelleme
    public void updateMemberAccount(MemberAccount account) {
        accounts.put(account.getId(), account);
        System.out.println("Hesap güncellendi: " + account);
    }

    // Hesap silme
    public void deleteMemberAccount(int id) {
        accounts.remove(id);
        System.out.println("Hesap silindi: ID " + id);
    }
}
