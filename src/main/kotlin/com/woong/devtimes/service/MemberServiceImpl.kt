package com.woong.devtimes.service

import com.woong.devtimes.model.dto.MemberDto
import com.woong.devtimes.model.mapper.MemberMapper
import com.woong.devtimes.repository.MemberRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

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

    @Transactional
    override fun updateMember(memberDto: MemberDto) {
        val targetMember = repo.findById(memberDto.id)
        memberMapper.updateMemberFromMemberDto(memberDto, targetMember)
        repo.save(targetMember)
    }

    override fun deleteMember(id: String) {
        repo.deleteById(id)
    }

}