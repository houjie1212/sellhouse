package com.sellhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellhouse.form.ReserveForm;
import com.sellhouse.service.ReserveService;

@RestController
public class ReserveController {

  @Autowired
  private ReserveService reserveService;

  @GetMapping("/reserve/num")
  public int selectCount() {
    int num = reserveService.selectCount();
    return num;
  }
  
  @PostMapping("/reserve/submit")
  public String submit(ReserveForm form) {
    String id = reserveService.save(form);
    return id;
  }
}
