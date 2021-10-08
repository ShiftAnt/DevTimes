package com.woong.devtimes.repository

import com.woong.devtimes.model.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface MemberRepository : JpaRepository<Member, Int> {
    fun findById(id: String): Member

    @Transactional
    fun deleteById(id: String): Long
}