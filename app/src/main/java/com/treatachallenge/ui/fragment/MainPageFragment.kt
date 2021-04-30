package com.treatachallenge.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.treatachallenge.R
import com.treatachallenge.databinding.FragmentMainPageBinding
import com.treatachallenge.ui.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainPageFragment : Fragment(R.layout.fragment_main_page){
    private var _binding: FragmentMainPageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
         _binding = FragmentMainPageBinding.bind(view)
        addTabs()
        setViewPager()
    }

    private fun addTabs() {
        val tabIcons = intArrayOf(
            R.drawable.ic_baseline_movie_24,
            R.drawable.ic_baseline_favorite_24,
        )
        binding.apply {
            tabLayout.addTab(
                tabLayout.newTab().setIcon(tabIcons[0])
                    .setText(getString(R.string.all_movie))
            )
            tabLayout.addTab(
                tabLayout.newTab().setIcon(tabIcons[1])
                    .setText(getString(R.string.favorite))
            )
            tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.setCurrentItem(tab.position)
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })

        }
    }

    private fun setViewPager() {
        val fragments: MutableList<Fragment> = ArrayList()
        fragments.add(MovieListFragment())
        fragments.add(FavoriteMovieFragment())
        val viewPagerAdapter = ViewPagerAdapter(
            childFragmentManager,
            lifecycle, fragments, this
        )
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.tabLayout.getTabAt(0)?.select()
                    1 -> binding.tabLayout.getTabAt(1)?.select()
                }
            }
        })
    }

}