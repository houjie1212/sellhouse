package com.sellhouse.service;

import com.sellhouse.form.ReserveForm;

public interface ReserveService {

  int selectCount();
  
  String save(ReserveForm form);
}
