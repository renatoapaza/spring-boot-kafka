/* ================================================================
 * El archivo "KafkaConsumer"  fue creado para Y.P.F.B. Corporación, todos los Derechos reservados 
 * Desarrollador: Renato Apaza Tito (rapaza@ypfb.gob.bo)
 * Fecha: 4/7/20 00:46
 * ==============================================================
 */
package com.rapaza.kafka.listener

import com.rapaza.kafka.model.User
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    @KafkaListener(topics = "kafka-ejemplo", groupId = "group_id")
    void consume(String message){
        println " Cosumed message: ${message}"
    }

    @KafkaListener(topics = "kafka-ejemplo-json", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    void consumeJson(User user){
        println "Consumed JSON Message: ${user.name} - ${user.dept} - ${user.salary}"
    }
}
