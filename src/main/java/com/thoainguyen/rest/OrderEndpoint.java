package com.thoainguyen.rest;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class OrderEndpoint {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderEndpoint.class);
  private final StreamBridge streamBridge;

  @PostMapping("/app/order")
  public ResponseEntity<String> createOrder() {
    streamBridge.send("produceOrder-out-0","I love be code");
    return ResponseEntity.ok("OK");
  }
}
