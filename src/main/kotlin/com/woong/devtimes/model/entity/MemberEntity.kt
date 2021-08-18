package com.woong.devtimes.model.entity

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "member")
@Entity
class MemberEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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