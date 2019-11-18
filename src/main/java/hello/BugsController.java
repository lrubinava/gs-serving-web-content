package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class BugsController {

    @GetMapping("/bugs")
    public String displayList(@RequestParam(name="status", required=false) BugStatus status, Model model) {

        List<Bug> filtered = Arrays.stream(bugsList)
                .filter(bug -> status == null || bug.status == status)
                .collect(Collectors.toList());

        model.addAttribute("bugs", filtered);
        return "bugs";
    }

    // aka database
    static Bug[] bugsList = {
            new Bug(1, BugStatus.NEW,"Vse ploxo", "Apr 2019"),
            new Bug(2, BugStatus.CLOSED,"Tak sebe", "Sep 2019"),
            new Bug(3, BugStatus.FIXED,"Zashibis", "Oct 2019"),
            new Bug(4, BugStatus.FIXED,"Ok", "Mar 2021"),
            new Bug(5, BugStatus.WONT_FIX,"Bodun", "Dec 1997"),
    };
}
