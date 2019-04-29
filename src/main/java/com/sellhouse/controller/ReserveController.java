package com.sellhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellhouse.service.ReserveService;

@RestController
public class ReserveController {

  @Autowired
  private ReserveService reserveService;

  @GetMapping("/reservenum")
  public int selectCount() {
    int num = reserveService.selectCount();
    return num;
  }
}
