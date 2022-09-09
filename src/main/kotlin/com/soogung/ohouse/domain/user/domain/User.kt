package com.soogung.ohouse.domain.user.domain

import com.soogung.ohouse.domain.user.domain.type.UserGrade
import com.soogung.ohouse.global.entity.BaseTimeEntity
import javax.persistence.*


@Entity
@Table(name = "user_tbl")
class User(
    @Column(length = 50, nullable = false)
    var email: String,

    @Column(length = 60, nullable = false)
    var password: String,

    @Column(length = 20, nullable = false)
    var nickname: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    var grade: UserGrade,

    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
): BaseTimeEntity() {
}