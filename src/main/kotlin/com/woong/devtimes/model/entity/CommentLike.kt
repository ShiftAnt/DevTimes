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

@Table(name = "comment_like")
@Entity
class CommentLike (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Int,
    @ManyToOne
    @JoinColumn(name = "comment_no")
    var comment: Comment,
    @ManyToOne
    @JoinColumn(name = "member_no")
    var member: Member,
    @Column(nullable = false)
    var checkStatus: Boolean,
    @Column(updatable = false)
    var createDateTime: LocalDateTime = LocalDateTime.now()

        )