package com.woong.devtimes.model.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "board_like")
@Entity
class BoardLike (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Int,
    @ManyToOne
    @JoinColumn(name = "board_no")
    var board: Board,
    var checkStatus: Boolean = true,
    @Column(updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    var createDateTime: LocalDateTime = LocalDateTime.now()
)