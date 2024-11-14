package org.api.springbootkotlinapi

import jakarta.persistence.*

@Entity
@Table(name = "\"user\"")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0;
    var name: String = "";
    var email: String = "";
}