package com.tan.java8.stream.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tan.java8.stream.User;

public class MapOperations {
    
    static final Logger logger = LoggerFactory.getLogger(MapOperations.class);

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
        List<String> names = users.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(User::getName).collect(Collectors.toList());
        
        int totalAge = users.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(User::getAge).sum();

    }

    
    
    public void flatMap() {
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .distinct()
                .collect(Collectors.toList());
        
        List<String> diStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());

    }

    
    
}
