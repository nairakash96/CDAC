package com.ehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehospital.pojos.BasicReportDetails;

public interface IBasicReportRepository extends JpaRepository<BasicReportDetails, Integer>{

}
