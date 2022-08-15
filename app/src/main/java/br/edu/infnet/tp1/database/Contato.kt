package br.edu.infnet.tp1.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Contato (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val idForncededor: Int,
    val nome: String,
    val email: String,
    val fone: String
)