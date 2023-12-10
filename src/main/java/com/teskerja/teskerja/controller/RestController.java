package com.teskerja.teskerja.controller;

import com.teskerja.teskerja.model.Member;
import com.teskerja.teskerja.model.Person;
import com.teskerja.teskerja.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("t")
public class RestController {

    @Autowired
    private TestService testService;

    @GetMapping("/example-json")
    @ResponseBody
    public Object exampleJson(){
        // Membuat ArrayList yang berisi objek Person
        List<Person> personList = new ArrayList<>();

        // Menambahkan objek Person ke ArrayList
        personList.add(new Person("Alice", 30));
        personList.add(new Person("Bob", 25));
        personList.add(new Person("Charlie", 35));

        return personList;
    }

//    @GetMapping("/test")
//    @ResponseBody
//    public List<Member> test() {
//        return testService.testRepo("John");
//    }
}
