package com.sellhouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellhouse.mapper.ReserveMapper;
import com.sellhouse.service.ReserveService;

@Service
public class ReserveServiceImpl implements ReserveService {

  @Autowired
  private ReserveMapper reserveMapper;

  @Override
  public int selectCount() {
    return reserveMapper.selectCount();
  }
}
