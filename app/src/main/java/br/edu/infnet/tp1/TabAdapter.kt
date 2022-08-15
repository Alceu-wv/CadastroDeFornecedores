package br.edu.infnet.tp1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayOf(
        FornecedoresFragment(),
        ContatosFragment(),
        ProdutosFragment())

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        return fragments[position]
    }
}