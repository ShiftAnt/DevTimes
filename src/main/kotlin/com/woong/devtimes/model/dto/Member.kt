package com.woong.devtimes.model.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime

data class Member (
    var no: Int,
    var id: String,
    var pw: String,
    var email: String,
    var name: String,
    var phone: String,
    var address: String,
    var intro: String,
    var description: String,
    var authStatus: Boolean,
    var authDatetime: LocalDateTime,
    var createDateTime: LocalDateTime
)