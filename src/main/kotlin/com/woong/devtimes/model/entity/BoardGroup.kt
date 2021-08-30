package com.woong.devtimes.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name = "board_group")
@Entity
class BoardGroup (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Int,
    var name: String,
    var order: Int,
    @OneToMany(mappedBy = "boardGroup")
    var boards: List<Board> = ArrayList<Board>()
)