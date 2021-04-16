package cn.wbomb.www;

import cn.wbomb.www.dao.UserMapper;
import cn.wbomb.www.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    @ResponseBody
    public User index() {
        return userMapper.getUserByID(1);
    }

    @RequestMapping("search")
    public String search(@RequestParam("p") String searchKey,
                         @RequestParam(value = "charset", required = false) String charset) {
        return "You are search:" + searchKey + charset;
    }


}