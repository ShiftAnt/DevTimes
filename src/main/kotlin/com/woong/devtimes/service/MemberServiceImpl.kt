package com.woong.devtimes.service

import com.woong.devtimes.model.dto.MemberDto
import com.woong.devtimes.model.mapper.MemberMapper
import com.woong.devtimes.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl (
    val repo: MemberRepository,
    val memberMapper: MemberMapper
): MemberService {

    override fun findById(id: String): MemberDto {
        return  memberMapper.memberToMemberDto(repo.findById(id))
    }

    override fun registerMember(memberDto: MemberDto) {
        repo.save(memberMapper.memberDtoToMember(memberDto))
    }

}