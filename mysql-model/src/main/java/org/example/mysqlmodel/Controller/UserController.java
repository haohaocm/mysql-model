package org.example.mysqlmodel.Controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.tomcat.util.json.JSONFilter;
import org.example.mysqlmodel.Entity.Response;
import org.example.mysqlmodel.Entity.User;
import org.example.mysqlmodel.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/mysql")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    //查询
    @GetMapping("/getAllUsers")
    public Response getAllUsers() {
        List<User> examples = userMapper.selectList(null);
        String result = JSON.toJSONString(examples);
        return new Response(result);
    }

    @PostMapping("/getUserById")
    public Response getUserById(@RequestBody int id) {
        User user = userMapper.selectById(id);
        String result = JSON.toJSONString(user);
        return new Response(result);
    }

    //条件查询,实现一
    @PostMapping("/getUserByAny")
    public Response getUserByAny(@RequestBody User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", user.getName());
        userQueryWrapper.ge("age", user.getAge());
        userQueryWrapper.orderByDesc("id");
        userQueryWrapper.like("email", user.getEmail());
        List<User> users = userMapper.selectList(userQueryWrapper);
        String result = JSON.toJSONString(users);
        return new Response(result);
    }

    //条件查询,实现二
    @PostMapping("/getUserByAny2")
    public Response getUserByAny2(@RequestBody User user) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getName, user.getName());
        userLambdaQueryWrapper.ge(User::getAge, user.getAge());
        userLambdaQueryWrapper.orderByDesc(User::getId);
        userLambdaQueryWrapper.like(User::getEmail, user.getEmail());
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        String result = JSON.toJSONString(users);
        return new Response(result);
    }

    //添加数据
    @PostMapping("/addUser")
    public Response addUser(@RequestBody User user) {
        userMapper.insert(user);
        return new Response("success");
    }

    //修改数据

    //删除数据
    @PostMapping("/deleteUserById")
    public Response addUser(@RequestBody int id) {
        int i = userMapper.deleteById(id);
        return new Response("success");
    }

    //分页查询
    @PostMapping("/PageQuery")
    public Response PageQuery(@RequestBody int id,@RequestParam int page,@RequestParam int size) {
        //查询条件
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", id);
        userQueryWrapper.orderByDesc("id");
        //查询分页
        Page<User> userPage = new Page<>(page,size);
        //进行查询
        Page<User> result = userMapper.selectPage(userPage, userQueryWrapper);
        String jsonString = JSON.toJSONString(result);
        return new Response(jsonString);
    }
}
