package com.sellhouse.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellhouse.entity.ReserveEntity;
import com.sellhouse.form.ReserveForm;
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

  @Override
  public String save(ReserveForm form) {
    ReserveEntity entity = new ReserveEntity();
    BeanUtils.copyProperties(form, entity);
    entity.setId(UUID.randomUUID().toString());
    entity.setCreateTime(LocalDateTime.now());
    reserveMapper.insert(entity);
    return entity.getId();
  }
}
