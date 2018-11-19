package com.tan.java8.stream.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tan.java8.stream.User;

public class TerminalOperations {
    
    static final Logger logger = LoggerFactory.getLogger(TerminalOperations.class);

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
    

    public void allMatch() {
        /**
         * allMatch用于检测是否全部都满足指定的参数行为，如果全部满足则返回true，例如我们希望检测是否所有的学生都已满18周岁
         */
        boolean isAdult = users.stream().allMatch(user -> user.getAge() >= 18);
        logger.info(" isAdult:{}", isAdult);
    }

    
    public void anyMatch() {
        /**
         * anyMatch则是检测是否存在一个或多个满足指定的参数行为，如果满足则返回true，例如我们希望检测是否有来自武汉大学的学生
         */
        boolean hasWhu = users.stream().anyMatch(user -> "武汉大学".equals(user.getSchool()));
        logger.info(" hasWhu:{}", hasWhu);
    }

    public void noneMathch() {
        /**
         * anyMatch则是检测是否存在一个或多个满足指定的参数行为，如果满足则返回true，例如我们希望检测是否有来自武汉大学的学生
         */
        boolean noneCs = users.stream().noneMatch(user -> "计算机科学".equals(user.getMajor()));
        logger.info(" noneCs:{}", noneCs);
    }
    
    public void findFirst() {
        /**
         * anyMatch则是检测是否存在一个或多个满足指定的参数行为，如果满足则返回true，例如我们希望检测是否有来自武汉大学的学生
         */
        Optional<User> optStu = users.stream().filter(user -> "土木工程".equals(user.getMajor())).findFirst();
        logger.info(" optStu:{}", optStu);
    }
    
    
    public void findAny() {
        /**
         * anyMatch则是检测是否存在一个或多个满足指定的参数行为，如果满足则返回true，例如我们希望检测是否有来自武汉大学的学生
         */
        Optional<User> optStu = users.stream().filter(user -> "土木工程".equals(user.getMajor())).findAny();
        logger.info(" optStu:{}", optStu);
    }
    
}
