package com.woong.devtimes.service

import com.woong.devtimes.model.dto.MemberDto

interface MemberService {
    fun findById(id: String): MemberDto

    fun registerMember(memberDto: MemberDto)

    fun updateMember(memberDto: MemberDto)

    fun deleteMember(id: String)

}