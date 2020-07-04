/* ================================================================
 * Desarrollador: Renato Apaza Tito (renato.apaza@outlook.com)
 * Fecha: 3/7/20 23:50
 * ==============================================================
 */
package com.rapaza.kafka.controller

import com.rapaza.kafka.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate
    private static final String TOPIC = "kafka-ejemplo-json"

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @GetMapping("/publish/{name}")
    String publishMessage(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC, new  User(name: name, dept: "Tecnology", salary: 12000L))
        return "Published successfully ${name}"
    }
}