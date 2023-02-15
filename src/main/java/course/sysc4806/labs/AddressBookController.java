package course.sysc4806.labs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin()
@RequestMapping("/addressBook")
public class AddressBookController {

    @GetMapping("/{id}")
    public String greeting(@PathVariable("id") AddressBook addressBook, Model model) {
        model.addAttribute("id", addressBook.getId());
        model.addAttribute("buddyList", addressBook.getBuddyListAsString());
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressBook";
    }

    @PostMapping("/{id}/addBuddy")
    public String greeting(@PathVariable("id") AddressBook addressBook, @ModelAttribute BuddyInfo newBuddy, Model model) {
        addressBook.addBuddy(newBuddy);
        model.addAttribute("id", addressBook.getId());
        model.addAttribute("buddyList", addressBook.getBuddyListAsString());
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressBook";
    }

}