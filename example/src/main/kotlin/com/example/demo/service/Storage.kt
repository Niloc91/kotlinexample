package com.example.demo.service

import com.example.demo.model.DataModel
import org.springframework.stereotype.Service

@Service
class DataModelStorage() {

    var list: MutableList<DataModel> = mutableListOf()


}