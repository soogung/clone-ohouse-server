package com.soogung.ohouse.domain.user.domain.repository

import com.soogung.ohouse.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository: JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    fun findUserById(id: Long): User?

    @Query("SELECT u FROM User u WHERE u.email = :email")
    fun findUserByEmail(email: String): User?

    @Query("SELECT count(u) > 0 FROM User u WHERE u.email = :email")
    fun existsUserByEmail(email: String): Boolean
}