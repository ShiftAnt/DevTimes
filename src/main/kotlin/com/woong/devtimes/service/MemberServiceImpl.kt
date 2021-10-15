package com.woong.devtimes.service

import com.woong.devtimes.model.dto.MemberDto
import com.woong.devtimes.model.mapper.MemberMapper
import com.woong.devtimes.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class MemberServiceImpl (
    val repo: MemberRepository,
    val memberMapper: MemberMapper
): MemberService {

    override fun findById(id: String): MemberDto? {
        return memberMapper.memberToMemberDto(repo.findById(id))
    }

    override fun registerMember(memberDto: MemberDto): Boolean {
        return try {
            repo.save(memberMapper.memberDtoToMember(memberDto))
            true
        } catch (e: Exception) {
            false
        }
    }

    @Transactional(isolation=Isolation.READ_COMMITTED, )
    override fun updateMember(memberDto: MemberDto): Boolean {
        return try {
            val targetMember = repo.findById(memberDto.id)!!
            memberMapper.updateMemberFromMemberDto(memberDto, targetMember)
            repo.save(targetMember)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun deleteMember(id: String): Boolean {
        return try {
            repo.deleteById(id)
            true
        } catch (e: Exception) {
            false
        }
    }

}