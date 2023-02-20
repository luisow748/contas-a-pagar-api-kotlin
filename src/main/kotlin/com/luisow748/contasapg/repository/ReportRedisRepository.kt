package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.redis.Report
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReportRedisRepository : CrudRepository<Report, String> {
}