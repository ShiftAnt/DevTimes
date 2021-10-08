package com.woong.devtimes.model.mapper

import com.woong.devtimes.model.dto.MemberDto
import com.woong.devtimes.model.entity.Member
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring")
interface MemberMapper {

    @Mapping(target = "authStatus")
    fun memberToMemberDto(member: Member): MemberDto

    @Mapping(target = "authStatus")
    fun memberDtoToMember(memberDto: MemberDto): Member

    fun updateMemberFromMemberDto(memberDto: MemberDto, @MappingTarget member: Member)

}