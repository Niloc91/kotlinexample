package com.example.demo.controller

import com.example.demo.model.DataModel
import com.example.demo.service.DataModelStorage
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
class testController constructor(
        private val dataModelStorage: DataModelStorage
) {

    @RequestMapping("/answer")
    fun answer() = 42


    @GetMapping("/findname/{name}")
    fun findName(@PathVariable name: String): List<DataModel> {
        val list: List<DataModel> = dataModelStorage.list.filter { it.name == name }
        return list
    }

    @GetMapping("/findallname/{name}")
    fun findallName(@PathVariable name: String): List<DataModel> {
        val list: List<DataModel> = dataModelStorage.list.filter { it.name.toLowerCase() == name.toLowerCase() }
        return list
    }

    @GetMapping("/findallnamesorted/{name}")
    fun findallNameSorted(@PathVariable name: String): List<DataModel> {
        val list: List<DataModel> = dataModelStorage.list.filter { it.name.toLowerCase() == name.toLowerCase() }.sortedBy { it.datenow }
        return list
    }

    @GetMapping("/findallnamesortedanddate/{name}{startDate}{endDate}")
    fun findallNameSortedanddate(@PathVariable name: String,
                                 @PathVariable startDate: Instant?,
                                 @PathVariable endDate: Instant?
    ): List<DataModel> {

        val list: List<DataModel> = dataModelStorage.list
                .filter {
                    it.name.toLowerCase() == name.toLowerCase()
                }
                .sortedBy { it.datenow }

        if (startDate == null || endDate == null) {
            return list
        }


        return list.filter { startDate < it.datenow }.filter { endDate > it.datenow }


    }


    @GetMapping("/test")
    fun test() = "is working"

    @GetMapping("/model")
    fun model(): DataModel {
        val foo = DataModel("Peter", 25, Instant.now())
        return foo
    }

    @PutMapping("/put/{data}")
    fun addmodel(@RequestBody data: DataModel): String {
        data.datenow = Instant.now()
        dataModelStorage.list.add(data)

        return "added"
    }


    @GetMapping("/get/{id}")
    fun getName(@PathVariable id: Int): DataModel {

        return dataModelStorage.list.get(id)

    }


    @GetMapping("/list")
    fun getmodel(): List<DataModel> {

        return dataModelStorage.list

    }

}
