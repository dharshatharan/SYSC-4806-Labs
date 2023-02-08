package course.sysc4806.labs;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.Collection;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Collection<BuddyInfo> buddyList;

    public AddressBook() {
        this.buddyList = new LinkedList<>();
    }

    public Integer getId() {
        return this.id;
    }

    public Collection<BuddyInfo> getBuddyList() {
        return buddyList;
    }

    public Collection<String> getBuddyListAsString() {
        return buddyList.stream()
                .map(buddy -> buddy.getName())
                .toList();
    }

    public void setBuddyList(Collection<BuddyInfo> buddyList) {
        this.buddyList = buddyList;
    }

    public void addBuddy(BuddyInfo buddyInfo) {
        if(buddyInfo != null) {
            buddyList.add(buddyInfo);
        }
    }

    public void removeBuddy(int index) {
        if(index >= 0 && index < buddyList.size()) {
            buddyList.remove(index);
        }
    }

    public void printBuddies() {
        buddyList.forEach(buddy -> System.out.println(buddy.getName()));
    }

    public void testMethod() {}

    public static void main(String[] args) {
        BuddyInfo buddy1 = new BuddyInfo("Tom");
        BuddyInfo buddy2 = new BuddyInfo("Jerry");
        AddressBook addressBook = new AddressBook();
        System.out.println("\nMy buddies...");
        addressBook.printBuddies();
        System.out.println("\nAdding buddies...");
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        System.out.println("\nMy buddies...");
        addressBook.printBuddies();
        System.out.println("\nRemoving buddies...");
        addressBook.removeBuddy(0);
        addressBook.removeBuddy(0);
        System.out.println("\nMy buddies...");
        addressBook.printBuddies();
    }
}

