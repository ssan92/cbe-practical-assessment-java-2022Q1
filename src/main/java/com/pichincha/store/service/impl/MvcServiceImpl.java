package com.pichincha.store.service.impl;

import com.pichincha.store.repository.TemplateRepository;
import com.pichincha.store.service.MvcService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MvcServiceImpl implements MvcService {

  @Autowired
  private TemplateRepository templateRepository;

  @Override
  public boolean isFinancialAndLegalEligible(String clientId) {
    return true;
  }

  @Override
  public List<String> getAllTemplateFilesNames() {
    return StreamSupport.stream(templateRepository.findAll().spliterator(), false)
        .map(template -> template.getFileName())
        .collect(Collectors.toList());
  }
}
