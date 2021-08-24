package com.woong.devtimes.restapi

import com.woong.devtimes.model.dto.ErrorDto
import com.woong.devtimes.model.dto.ResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class RestApiResponse {
    fun<T> response(status: HttpStatus = HttpStatus.OK, data: T?, error: ErrorDto? = null): ResponseEntity<ResponseDto<T>> {
        return ResponseEntity(ResponseDto(status.value(), data, error), status)
    }
}