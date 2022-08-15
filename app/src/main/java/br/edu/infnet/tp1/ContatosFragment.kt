package br.edu.infnet.tp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.room.Room
import br.edu.infnet.tp1.database.AppDatabase
import br.edu.infnet.tp1.database.Contato
import br.edu.infnet.tp1.database.ContatoDAO
import br.edu.infnet.tp1.database.FornecedorDAO


class ContatosFragment : Fragment() {

    private lateinit var fornecedorDAO: FornecedorDAO
    private lateinit var contatoDAO: ContatoDAO
    private lateinit var fornecedoresIds: ArrayList<Int>
    private var idEmEdicao: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contatos, container, false)

        val appDatabase = Room.databaseBuilder(
            this.requireActivity(),
            AppDatabase::class.java,
            "room_extra.db"
        ).allowMainThreadQueries().build()
        fornecedorDAO = appDatabase.obterFornecedorDAO()
        contatoDAO = appDatabase.obterContatoDAO()

        val btnSalvaroContato = view.findViewById<Button>(R.id.btnSalvarContato)
        btnSalvaroContato.setOnClickListener {

            val spnFornecedores = view.findViewById<Spinner>(R.id.spnFornecedores)
            val txtNome = view.findViewById<EditText>(R.id.editTextTextPersonName)
            val txtEmail = view.findViewById<EditText>(R.id.editTextEmail)
            val txtFone = view.findViewById<EditText>(R.id.editTextPhone)
            val contato = Contato(
                null,
                fornecedoresIds.get(spnFornecedores.selectedItemPosition),
                txtNome.text.toString(),
                txtEmail.text.toString(),
                txtFone.text.toString()
            )
            contatoDAO.inserir(contato)
            txtNome.setText(null)
            txtEmail.setText(null)
            txtFone.setText(null)
            this.atualizarFornecedores()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        atualizarFornecedores()
    }

    private fun atualizarFornecedores() {
        val fornecedores = fornecedorDAO.listar()
        val titulos = ArrayList<String>()
        for(fornecedor in fornecedores) {
            titulos.add(fornecedor.razaoSocial)
            fornecedoresIds.add(fornecedor.id!!)
        }
        val spnFornecedores = this.requireView().findViewById<Spinner>(R.id.spnFornecedores)
        val adapter = ArrayAdapter<String>(this.requireActivity(), android.R.layout.simple_spinner_item, titulos)
        spnFornecedores.adapter = adapter
    }
}