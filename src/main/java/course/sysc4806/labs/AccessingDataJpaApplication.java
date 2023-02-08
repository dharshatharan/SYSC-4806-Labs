package course.sysc4806.labs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demoBuddyInfo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new BuddyInfo("Jack"));
            repository.save(new BuddyInfo("Chloe"));
            repository.save(new BuddyInfo("Kim"));
            repository.save(new BuddyInfo("David"));
            repository.save(new BuddyInfo("David"));

            // fetch all buddies
            log.info("Buddies found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual buddy by ID
            BuddyInfo buddy = repository.findById(1L);
            log.info("Buddy found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddy.toString());
            log.info("");

            // fetch buddies by last name
            log.info("Buddies found with findByName('David'):");
            log.info("--------------------------------------------");
            repository.findByName("David").forEach(david -> {
                log.info(david.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

    @Bean
    public CommandLineRunner demoAddressBook(AddressBookRepository repository) {
        return (args) -> {
            // save a few customers
            AddressBook addBook = new AddressBook();
            addBook.addBuddy(new BuddyInfo("James"));
            addBook.addBuddy(new BuddyInfo("Cam"));
            addBook.addBuddy(new BuddyInfo("Ryan"));
            repository.save(addBook);
            repository.save(new AddressBook());

            // fetch all addressBooks
            log.info("AddressBook found with findAll():");
            log.info("-------------------------------");
            for (AddressBook addressBook : repository.findAll()) {
                log.info(addressBook.toString());
                log.info("Buddies:\n");
                addressBook.printBuddies();
            }
            log.info("");

            // fetch an individual addressBooks by ID
            AddressBook addressBook = repository.findById(1L);
            log.info("AddressBook found with findById(1L):");
            log.info("--------------------------------");
            log.info(addressBook.toString());
            log.info("Buddies:\n");
            addressBook.printBuddies();
            log.info("");

            // fetch buddies by last name
//            log.info("Buddies found with findByName('David'):");
//            log.info("--------------------------------------------");
//            repository.findByName("David").forEach(david -> {
//                log.info(david.toString());
//            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}