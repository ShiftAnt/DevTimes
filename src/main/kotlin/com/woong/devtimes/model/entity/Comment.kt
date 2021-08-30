package com.woong.devtimes.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name = "comment")
@Entity
class Comment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Int,
    @ManyToOne
    @JoinColumn(name = "no")
    var board: Board,
    @ManyToOne
    @JoinColumn(name = "no")
    var member: Member,
    var content: String = "",
    var deleteStatus: Boolean = false,

    @OneToMany(mappedBy = "comment")
    val members: List<CommentLike> = ArrayList()
)