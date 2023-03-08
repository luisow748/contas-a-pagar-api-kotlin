package com.luisow748.contasapg.domain

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "_user")
class User(
    @Id
    @GeneratedValue
    private val id: Int? = -1,
    private val firstName: String? = null,
    private val lastName: String? = null,
    @Column(unique = true)
    private val email: String? = null,
    private val password: String? = null,
    @Enumerated(EnumType.STRING)
    private val role: Role? = null,
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return listOf(SimpleGrantedAuthority(role?.name))
    }

    override fun getPassword(): String {
        return password!!
    }

    override fun getUsername(): String {
        return email!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
