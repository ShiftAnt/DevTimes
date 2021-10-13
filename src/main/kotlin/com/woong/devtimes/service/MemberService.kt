package com.woong.devtimes.service

import com.woong.devtimes.model.dto.MemberDto

interface MemberService {
    fun findById(id: String): MemberDto?

    fun registerMember(memberDto: MemberDto): Boolean

    fun updateMember(memberDto: MemberDto): Boolean

    fun deleteMember(id: String): Boolean

}