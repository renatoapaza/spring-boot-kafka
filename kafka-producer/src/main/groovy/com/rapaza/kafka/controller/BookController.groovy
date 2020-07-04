/* ================================================================
 * El archivo "BookController"  fue creado para Y.P.F.B. Corporación, todos los Derechos reservados 
 * Desarrollador: Renato Apaza Tito (rapaza@ypfb.gob.bo)
 * Fecha: 3/7/20 23:47
 * ==============================================================
 */
package com.rapaza.kafka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {
    /*
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate
    private static final String TOPIC = "kafka-ejemplo"

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @GetMapping("/publish/{name}")
    String publishMessage(@PathVariable("name") final String name){
        //kafkaTemplate.send(TOPIC, new  User(name: name, dept: "Tecnology", salary: 12000))
        return "Published successfully ${name}"
    }
    */
}
