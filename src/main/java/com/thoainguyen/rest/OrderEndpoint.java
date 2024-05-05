package com.thoainguyen.rest;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class OrderEndpoint {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderEndpoint.class);
  private final StreamBridge streamBridge;

  @PostMapping("/app/order/{id}")
  public ResponseEntity<String> createOrder(@PathVariable Integer id) {
    Message<Order> message = MessageBuilder.withPayload(new Order("Order " + id)).setHeader(
      KafkaHeaders.MESSAGE_KEY, String.valueOf(id)).build();
    streamBridge.send("produceOrder-out-0",message);
    return ResponseEntity.ok("OK");
  }
}
