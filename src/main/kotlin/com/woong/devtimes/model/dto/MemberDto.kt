package com.woong.devtimes.model.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime


data class MemberDto (
    @set:JsonIgnore
    var no: Int = 0,
    var id: String = "",
    var pw: String = "",
    var email: String = "",
    var name: String = "",
    var phone: String = "",
    var address: String = "",
    var intro: String = "",
    var description: String = "",
    var authStatus: Char = 'N',
    var authDatetime: LocalDateTime? = null,
    var createDateTime: LocalDateTime = LocalDateTime.now()
)