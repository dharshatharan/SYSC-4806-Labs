package course.sysc4806.labs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addressBook")
public class AddressBookController {

    @GetMapping("/{id}")
    public String greeting(@PathVariable("id") AddressBook addressBook, Model model) {
        model.addAttribute("id", addressBook.getId());
        model.addAttribute("buddyList", addressBook.getBuddyListAsString());
        return "addressBook";
    }

}