package com.woong.devtimes.restapis

import com.fasterxml.jackson.databind.ObjectMapper
import com.woong.devtimes.model.dto.MemberDto
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.event.annotation.AfterTestMethod
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
class MemberTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {
    @AfterEach
    fun deleteMembersTest() {
        mockMvc.delete("/api/v1/member/delete/temp@temp.com"){ contentType = MediaType.APPLICATION_JSON}
            .andExpect { status { isOk() } }.andDo { print() }
    }
    @AfterEach
    fun updateMembersTest() {
        val members = ArrayList<MemberDto>()
        members.add(MemberDto(no = 2, id = "temp2@temp.com", pw = "FDSFDSBEFGB34123123FDSFFDSF4SDFA", name = "Woong112"))
        members.add(MemberDto(no = 3, id = "temp3@temp.com", pw = "FDSFDSBEFGB34123123FDSFFDSF4SDFA", name = "Woong212"))

        repeat(members.size) {
            mockMvc.put("/api/v1/member/update") { contentType = MediaType.APPLICATION_JSON; content = objectMapper.writeValueAsString(members[it])}
                .andExpect { status { isOk() } }.andDo { print() }
        }
    }
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
    }

    @Test
    fun memberRestTest() {
        mockMvc.get("/api/v1/member/{id}", "temp@temp.com") { accept = MediaType.APPLICATION_JSON }.andExpect { status { isOk() } }.andDo { print() }
    }
}