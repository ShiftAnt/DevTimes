package com.woong.devtimes.service

import com.woong.devtimes.model.dto.Member

interface MemberService {
    fun findById(id: String): Member?
}