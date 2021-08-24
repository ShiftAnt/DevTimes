package com.woong.devtimes.model.mapper

import com.woong.devtimes.model.dto.MemberDto
import com.woong.devtimes.model.entity.Member
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface MemberMapper {

    @Mapping(target = "authStatus", expression = "java(member.getAuthStatus() ? 'Y' : 'N')")
    fun memberToMemberDto(member: Member): MemberDto

    @Mapping(target = "authStatus", expression = "java(memberDto.getAuthStatus() == 'Y' ? true : false)")
    fun memberDtoToMember(memberDto: MemberDto): Member

}