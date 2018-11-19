package com.tan.java8.stream.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tan.java8.stream.User;

/**https://www.cnblogs.com/shenlanzhizun/p/6027042.html
 * @author Administrator
 *
 */
public class IntermediateOperations {
    
    static final Logger logger = LoggerFactory.getLogger(IntermediateOperations.class);

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
        List<User> whuStudents =
                users.stream().filter(user -> "武汉大学".equals(user.getSchool()))
                        .collect(Collectors.toList());
        logger.info(" whuStudents size:{}", whuStudents.size());

    }

   /* public void distinct() {
        List<Integer> evens = users.stream()
                .filter(num -> num % 2 == 0).distinct()
                .collect(Collectors.toList());
    }*/
    
    public void limit() {
        List<User> civilStudents =
                users.stream().filter(user -> "土木工程".equals(user.getMajor())).limit(2)
                        .collect(Collectors.toList());
    }

    public void sorted() {
        List<User> sortedCivilStudents =
                users.stream().filter(user -> "土木工程".equals(user.getMajor()))
                        .sorted((s1, s2) -> s1.getAge() - s2.getAge()).limit(2)
                        .collect(Collectors.toList());
    }

    
    public void skip() {
        List<User> civilStudents = users.stream()
                .filter(user -> "土木工程".equals(user.getMajor()))
                .skip(2)
                .collect(Collectors.toList());
    }
    
    
}
