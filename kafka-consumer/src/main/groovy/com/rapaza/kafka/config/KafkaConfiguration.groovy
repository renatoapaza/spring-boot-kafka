/* ================================================================
 * Desarrollador: Renato Apaza Tito (renato.apaza@outlook.com)
 * Fecha: 4/7/20 00:37
 * ==============================================================
 */
package com.rapaza.kafka.config

import com.rapaza.kafka.model.User
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConfiguration {

    @Bean
    ConsumerFactory<String , String> consumerFactory() {
        Map<String , Object> config = new HashMap<>()

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG , "127.0.0.1:9092")
        config.put(ConsumerConfig.GROUP_ID_CONFIG , "group_id")
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class)
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class)

        return new DefaultKafkaConsumerFactory<>(config)
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String , String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String , String> factory = new ConcurrentKafkaListenerContainerFactory<>()

        factory.setConsumerFactory(consumerFactory())
        //factory.consumerFactory = consumerFactory()

        return factory
    }


    @Bean
    ConsumerFactory<String , User> userConsumerFactory() {
        Map<String , Object> config = new HashMap<>()

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG , "127.0.0.1:9092")
        config.put(ConsumerConfig.GROUP_ID_CONFIG , "group_json")
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class)
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , JsonDeserializer.class)

        return new DefaultKafkaConsumerFactory<>(config , new StringDeserializer() , new JsonDeserializer<>(User.class))
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerFactory(){
        ConcurrentKafkaListenerContainerFactory<String , User> factory = new ConcurrentKafkaListenerContainerFactory<>()

        //factory.consumerFactory = userConsumerFactory()
        factory.setConsumerFactory(userConsumerFactory())
        return factory
    }
}
