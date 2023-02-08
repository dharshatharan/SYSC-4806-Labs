package course.sysc4806.labs;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddressBookRepository repository;

    @BeforeEach()
    public void setUp() {
        AddressBook addBook = new AddressBook();
        addBook.addBuddy(new BuddyInfo("James"));
        addBook.addBuddy(new BuddyInfo("Cam"));
        addBook.addBuddy(new BuddyInfo("Ryan"));
        repository.save(addBook);
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/addressBook/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[James, Cam, Ryan]")));
    }
}