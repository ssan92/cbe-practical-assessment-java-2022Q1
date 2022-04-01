package com.pichincha.evaluacion.practica.repository;

import com.pichincha.evaluacion.practica.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportRepository extends JpaRepository<ReportEntity, Long> {
}
