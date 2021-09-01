package com.woong.devtimes.model.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name = "board")
@Entity
class Board (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Int,
    @ManyToOne
    @JoinColumn(name = "board_group_no")
    var boardGroup: BoardGroup,

    @ManyToOne
    @JoinColumn(name = "member_no")
    var member: Member,
    var title: String = "",
    var content: String = "",
    var hit: Int = 0,
    var updateDateTime: LocalDateTime? = null,
    @Column(updatable = false)
    var createDateTime: LocalDateTime,

    @OneToMany(mappedBy = "board")
    var likes: List<BoardLike> = ArrayList(),
    @OneToMany(mappedBy = "board")
    var comments: List<Comment> = ArrayList()
)