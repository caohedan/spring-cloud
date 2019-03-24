package com.example.eurekaclient.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

  @Autowired
  DiscoveryClient discoveryClient;

  @GetMapping
  public String getServices() {
    String services = "[Client]"+"Services: " + discoveryClient.getServices();
    System.out.println(services);
    return services;
  }


}
