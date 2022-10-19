package com.soogung.ohouse.domain.user.domain.repository

import com.soogung.ohouse.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface UserRepository: JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    fun findUserById(id: Long): User?

    @Query("SELECT u FROM User u WHERE u.email = :email")
    fun findUserByEmail(email: String): User?

    @Query("SELECT count(u) > 0 FROM User u WHERE u.email = :email")
    fun existsUserByEmail(email: String): Boolean

    @Modifying
    @Transactional
    @Query("INSERT INTO tbl_user (email, password, nickname, grade) VALUES (:#{#u.email},:#{#u.password},:#{#u.nickname},:#{#u.grade.toString()})", nativeQuery = true)
    fun save(@Param("u") user: User)
}