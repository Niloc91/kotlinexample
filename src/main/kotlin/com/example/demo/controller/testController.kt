package com.example.demo.controller

import com.example.demo.model.DataModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class testController {

    @RequestMapping("/answer")
        fun answer() = 42


    @GetMapping("/test")
        fun test() = "is working"

    @GetMapping("/model")
        fun model():DataModel  {
           val foo= DataModel("Peter",25);
        return foo
    }

}