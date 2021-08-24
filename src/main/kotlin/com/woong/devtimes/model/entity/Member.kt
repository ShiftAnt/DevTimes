package com.woong.devtimes.model.entity

import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "member")
@Entity
class Member (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Int,
    @Column(unique = true, nullable = false, updatable = false)
    var id: String,
    @Column(nullable = false)
    var pw: String,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var phone: String,
    var address: String,
    var intro: String,
    var description: String,
    @ColumnDefault(value = "false")
    var authStatus: Boolean,
    var authDatetime: LocalDateTime?,
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    var createDateTime: LocalDateTime
)