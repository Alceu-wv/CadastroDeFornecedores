package br.edu.infnet.tp1.database

import androidx.room.*

@Dao
interface ContatoDAO {

    @Insert
    fun inserir(contato: Contato)

    @Delete
    fun delete(contato: Contato)

    @Query("SELECT * FROM contato")
    fun getAll(): List<Contato>

}