package com.woong.devtimes.controller

import com.woong.devtimes.model.dto.MemberDto
import com.woong.devtimes.model.dto.ResponseDto
import com.woong.devtimes.restapi.RestApiResponse
import com.woong.devtimes.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/member")
class MemberController (
    val service: MemberService,
    val restApiResponse: RestApiResponse
        ) {

    @GetMapping("/{id}")
    fun viewMember(@PathVariable id: String): ResponseEntity<ResponseDto<MemberDto>> {
        return restApiResponse.response(data = service.findById(id))
    }

    @PostMapping("/register")
    fun registerMember(@RequestBody memberDto: MemberDto) : ResponseEntity<ResponseDto<MemberDto>> {
        service.registerMember(memberDto)
        return restApiResponse.response(data = null)
    }
}