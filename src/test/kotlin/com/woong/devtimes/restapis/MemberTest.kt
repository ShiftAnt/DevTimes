package com.woong.devtimes.restapis

import com.fasterxml.jackson.databind.ObjectMapper
import com.woong.devtimes.model.dto.MemberDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class MemberTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {
    @Test
    fun registerTestMembers() {
        val members = ArrayList<MemberDto>()
        members.add(MemberDto(id = "temp@temp.com", pw = "FDSFDSBEFGB34123123FDSFFDSF4SDFA", name = "Woong"))
        println(members[0].toString())
        members.add(MemberDto(id = "temp2@temp.com", pw = "FDSFDSBEFGB34123123FDSFFDSF4SDFA", name = "Woong1"))
        members.add(MemberDto(id = "temp3@temp.com", pw = "FDSFDSBEFGB34123123FDSFFDSF4SDFA", name = "Woong2"))
        repeat(members.size) {
            mockMvc.post("/api/v1/member/register") { contentType = MediaType.APPLICATION_JSON; content = objectMapper.writeValueAsString(members[it])}
                .andExpect { status { isOk() } }.andDo { print() }
        }
        while (true) {}
    }

    @Test
    fun memberRestTest() {
        mockMvc.get("/api/v1/member/{id}", "temp@temp.com") { accept = MediaType.APPLICATION_JSON }.andExpect { status { isOk() } }.andDo { print() }
    }
}