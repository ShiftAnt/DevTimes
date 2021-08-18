package com.woong.devtimes.repository

import com.woong.devtimes.model.dto.Member
import com.woong.devtimes.model.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<MemberEntity, Int> {
    fun findById(id: String): Member?
}