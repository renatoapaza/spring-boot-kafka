/* ================================================================
 * Desarrollador: Renato Apaza Tito (renato.apaza@outlook.com)
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
