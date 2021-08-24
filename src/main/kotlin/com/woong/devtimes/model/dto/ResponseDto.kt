package com.woong.devtimes.model.dto

import org.springframework.http.HttpStatus

data class ResponseDto<T>(
    var status: Int = HttpStatus.OK.value(),
    var data: T?,
    var error: ErrorDto? = null
)