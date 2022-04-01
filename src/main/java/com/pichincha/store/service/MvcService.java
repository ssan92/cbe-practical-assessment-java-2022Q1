package com.pichincha.store.service;

import java.util.List;

public interface MvcService {

  boolean isFinancialAndLegalEligible(String clientId);
  List<String> getAllTemplateFilesNames();

}
