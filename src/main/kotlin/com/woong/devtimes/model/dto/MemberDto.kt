package com.woong.devtimes.model.dto

import com.woong.devtimes.model.entity.Board
import com.woong.devtimes.model.entity.Comment
import com.woong.devtimes.model.entity.CommentLike
import java.time.LocalDateTime


data class MemberDto (
    var no: Int = 0,
    var id: String = "",
    var pw: String = "",
    var name: String = "",
    var phone: String = "",
    var address: String = "",
    var intro: String = "",
    var description: String = "",
    var authStatus: Char = 'N',
    var authDatetime: LocalDateTime? = null,
    var createDateTime: LocalDateTime = LocalDateTime.now(),
    var boards: List<Board> = ArrayList(),
    var comments: List<Comment> = ArrayList(),
    var commentLikes: List<CommentLike> = ArrayList(),
)