package br.edu.infnet.tp1.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Fornecedor::class, Contato::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun obterFornecedorDAO(): FornecedorDAO

    abstract fun obterContatoDAO(): ContatoDAO

}