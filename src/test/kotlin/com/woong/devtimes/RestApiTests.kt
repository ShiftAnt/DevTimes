package com.woong.devtimes

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class RestApiTests @Autowired constructor (
    val mockMvc: MockMvc

) {
    @Test
    fun memberRestTest() {
        mockMvc
        mockMvc.get("/api/v1/member/{id}", "temp") { accept = MediaType.APPLICATION_JSON }.andExpect { status { isOk() } }.andDo { print() }
    }
}