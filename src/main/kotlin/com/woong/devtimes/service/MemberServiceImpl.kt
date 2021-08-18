package com.woong.devtimes.service

import com.woong.devtimes.model.dto.Member
import com.woong.devtimes.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl (
    val repo: MemberRepository
): MemberService {

    override fun findById(id: String): Member? {
        return repo.findById(id)
    }

}