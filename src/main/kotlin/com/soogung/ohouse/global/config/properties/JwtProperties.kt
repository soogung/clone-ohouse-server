package com.soogung.ohouse.global.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("jwt")
data class JwtProperties(
    val accessTokenValidTime: Long,
    val prefix: String,
    val header: String,
    val secretKey: String,
)