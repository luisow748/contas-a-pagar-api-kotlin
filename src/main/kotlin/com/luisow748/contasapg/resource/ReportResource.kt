package com.luisow748.contasapg.resource

import com.luisow748.contasapg.domain.redis.Report
import com.luisow748.contasapg.service.redis.ReportService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/report")
class ReportResource(
    val reportService: ReportService
) {
    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun getAll(): List<Report> {
        return reportService.getReports()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody report: Report): Report {
        return reportService.saveReport(report)
    }
}