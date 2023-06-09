package Abstract;
import java.util.ArrayList;
import java.util.List;

public class Cellphone implements Phone
{
    private String merk;
    private String type;
    private int batteryLevel;
    private int status;
    private int volume;
    private int credit;
    private List<Contact> contacts;

    public Cellphone(String merk, String type) {
        this.merk = merk;
        this.type = type;
        this.batteryLevel = (int)(Math.random() * (100 - 0 + 1) + 0);
        this.contacts = new ArrayList<>();
    }

    public void powerOn() {
        this.status = 1;
        System.out.println("Ponsel menyala");
    }

    public void powerOff() {
        this.status = 0;
        System.out.println("Ponsel mati");
    }

    public void volumeUp() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
        } else {
            this.volume++;
            if (this.volume >= MAX_VOLUME) {
                this.volume = MAX_VOLUME;
            }
        }
    }

    public void volumeDown() {
        this.volume--;
        if (this.volume <= MIN_VOLUME) {
            this.volume = MIN_VOLUME;
        }
    }

    public int getVolume() {
        return this.volume;
    }

    public void topUpCredit(int amount) {
        this.credit += amount;
        System.out.println("Pulsa berhasil diisi sebesar " + amount);
    }

    public int getRemainingCredit() {
        return this.credit;
    }

    public void addContact(String nama, String nomor) {
        Contact contact = new Contact(nama, nomor);
        contacts.add(contact);
        System.out.println("Kontak berhasil ditambahkan");
    }

    public List<Contact> getAllContacts() {
        return this.contacts;
    }

    public Contact searchContact(String nama) {
        for (Contact contact : contacts) {
            if (contact.getNama().equalsIgnoreCase(nama)) {
                return contact;
            }
        }
        return null; // Jika kontak tidak ditemukan
    }
}
