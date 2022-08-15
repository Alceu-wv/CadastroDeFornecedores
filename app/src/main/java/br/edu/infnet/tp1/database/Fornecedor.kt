package br.edu.infnet.tp1.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Fornecedor(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val razaoSocial: String,
    val cnpj: String
    )

