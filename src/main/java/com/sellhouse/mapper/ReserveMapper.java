package com.sellhouse.mapper;

import com.sellhouse.entity.ReserveEntity;

public interface ReserveMapper {

  int selectCount();

  int insert(ReserveEntity entity);
}
