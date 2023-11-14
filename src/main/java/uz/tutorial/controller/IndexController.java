package uz.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
public class IndexController {
    HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
    @GetMapping("/")
    public String get(){
        return "Hello World";
    }
    @GetMapping("/result")
    public Integer get(@RequestParam Integer a, @RequestParam Integer b){
        return a+b;
    }

    @GetMapping("/book")
    public HashMap<Integer, ArrayList<String>> get(@RequestParam Integer ID, @RequestParam String Name,@RequestParam String Autheor, @RequestParam String price){
        ArrayList<String> al = new ArrayList<>();
        al.add(Name);
        al.add(Autheor);
        al.add(price);
        map.put(ID,al);
        return map;
    }

}
