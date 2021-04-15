package cn.wbomb.www;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("repos")
public class IssueController {
    @DeleteMapping("/{owner}/{repo}/{issue_number/lock}")
    public void unlock(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo,
            @PathVariable("issue_number") String issueNumber
    ) {
        System.out.println(owner);
        System.out.println(repo);
        System.out.println(issueNumber);
    }

    @PostMapping("/{owner}/{repo}/issues")
    public void create(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo,
            @RequestBody Object object
    ) {
        System.out.println(object);
    }

    @PostMapping("/demo")
    public void formDemo(@RequestParam("aaa") String aaa,
                         @RequestParam("bbb") String bbb) {
        System.out.println(aaa);
        System.out.println(bbb);
    }
}
