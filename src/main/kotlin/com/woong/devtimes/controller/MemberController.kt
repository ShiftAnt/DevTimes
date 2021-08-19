package com.woong.devtimes.controller

import com.woong.devtimes.model.dto.MemberDto
import com.woong.devtimes.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/member")
class MemberController (
    val service: MemberService
        ) {

    @GetMapping("/{id}")
    fun viewMember(@PathVariable id: String) : ResponseEntity<MemberDto> {
        return ResponseEntity(service.findById(id), HttpStatus.OK)
    }
}