package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

@Controller
@RequestMapping("/bugs")
public class BugsController {

    @Autowired
    private BugService bugService;

    @GetMapping(value = "/all")
    public String showAll(Model model) {
        model.addAttribute("bugs", bugService.findAll());
        return "bugs";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        BugCreation bugsForm = new BugCreation();

        for (int i = 1; i <= 3; i++) {
            bugsForm.addBug(new Bug());
        }

        model.addAttribute("form", bugsForm);
        return "addBugsForm";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(Model model) {
        List<Bug> bugsList = new ArrayList<>();
        bugService.findAll()
                .iterator()
                .forEachRemaining(bugsList::add);

        model.addAttribute("form", new BugCreation(bugsList));
        return "editBugsForm";
    }

    @PostMapping(value = "/save")
    public String saveBugs(@ModelAttribute BugCreation form, Model model) {
        bugService.saveAll(form.getBugsList());

        model.addAttribute("bugs", bugService.findAll());
        return "redirect:/bugs/all";
    }

//    public String displayList(@RequestParam(name="status", required=false) BugStatus status, Model model) {

//        List<Bug> filtered = Arrays.stream(bugsList)
//                .filter(bug -> status == null || bug.status == status)
//                .collect(Collectors.toList());
//
//        model.addAttribute("bugs", filtered);
//        return "bugs";
//        }

    // aka database
//    static Bug[] bugsList = {
//            new Bug(1, BugStatus.NEW,"Vse ploxo", "Apr 2019"),
//            new Bug(2, BugStatus.CLOSED,"Tak sebe", "Sep 2019"),
//            new Bug(3, BugStatus.FIXED,"Zashibis", "Oct 2019"),
//            new Bug(4, BugStatus.FIXED,"Ok", "Mar 2021"),
//            new Bug(5, BugStatus.WONT_FIX,"Bodun", "Dec 1997"),
//    };

}