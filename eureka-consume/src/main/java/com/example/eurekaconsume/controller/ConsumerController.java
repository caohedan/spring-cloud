package com.example.eurekaconsume.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @Autowired
  RestTemplate restTemplate;

  @GetMapping
  public String getClient() {
    ServiceInstance serviceInstance = discoveryClient.getInstances( "eureka-client").get(0);
    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/client";
    System.out.println(url);
    return restTemplate.getForObject(url, String.class);
  }
}
