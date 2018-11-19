package com.tan.java8.stream.reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tan.java8.stream.User;

public class ReduceOperations {
    
    static final Logger logger = LoggerFactory.getLogger(ReduceOperations.class);

 // 初始化
    List<User> users = new ArrayList<User>() {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        {
            add(new User(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
            add(new User(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
            add(new User(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
            add(new User(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
            add(new User(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
            add(new User(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
            add(new User(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
            add(new User(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
            add(new User(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
            add(new User(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
        }
    };
    
    public void filter() {

        // 前面例子中的方法
        int totalAge0 =
                users.stream().filter(user -> "计算机科学".equals(user.getMajor()))
                        .mapToInt(User::getAge).sum();
        // 归约操作
        int totalAge =
                users.stream().filter(user -> "计算机科学".equals(user.getMajor())).map(User::getAge)
                        .reduce(0, (a, b) -> a + b);

        // 进一步简化
        int totalAge2 =
                users.stream().filter(user -> "计算机科学".equals(user.getMajor())).map(User::getAge)
                        .reduce(0, Integer::sum);

        // 采用无初始值的重载版本，需要注意返回Optional
        Optional<Integer> totalAge3 =
                users.stream().filter(user -> "计算机科学".equals(user.getMajor())).map(User::getAge)
                        .reduce(Integer::sum); // 去掉初始值
    }

}
