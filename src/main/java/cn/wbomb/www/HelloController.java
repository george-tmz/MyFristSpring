package cn.wbomb.www;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("search")
    public String search(@RequestParam("p") String searchKey,
                         @RequestParam(value = "charset", required = false) String charset) {
        return "You are search:" + searchKey + charset;
    }


}