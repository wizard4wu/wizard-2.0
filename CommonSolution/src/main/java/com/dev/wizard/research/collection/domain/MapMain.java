package com.dev.wizard.research.collection.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapMain {

    @Data
    static class User {

        User(String id, String name){
            this.id = id;
            this.name = name;
        }

        private String id;

        private String name;
    }

    public static void main(String[] args) {


        List<User> list = new ArrayList<>();

        User user1 = new User("id1", "name1");
        User user2 = new User("id2", "name2");
        User user3 = new User("id1", "name3");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        Map<String, User> userMap = list.stream().collect(Collectors.toMap(user -> user.getId(), user->user, (previous, next) -> next));

        List<User> users = userMap.values().stream().collect(Collectors.toList());
        System.out.println(users);
        System.out.println(userMap);
    }
}
