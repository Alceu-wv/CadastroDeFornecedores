package br.edu.infnet.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        var viewPager = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager.adapter = TabAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->

            viewPager.setCurrentItem(tab.position, true)
            if(position ==2 ) tab.setText("Produtos")
            if(position ==1 ) tab.setText("Contatos")
            if(position ==0 ) tab.setText("Fornecedores")
        }.attach()

    }
}