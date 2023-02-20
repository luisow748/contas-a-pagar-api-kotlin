package com.luisow748.contasapg.service.redis

import com.luisow748.contasapg.domain.redis.Report
import com.luisow748.contasapg.repository.ReportRedisRepository
import org.springframework.stereotype.Service

@Service
class ReportService(
    val reportRedisRepository: ReportRedisRepository
) {

    fun getReports(): List<Report> {
        return reportRedisRepository.findAll().toList()
    }

    fun saveReport(report: Report): Report {
        return reportRedisRepository.save(report)
    }
}