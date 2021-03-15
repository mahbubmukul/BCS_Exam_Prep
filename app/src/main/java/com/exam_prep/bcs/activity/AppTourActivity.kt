package com.exam_prep.bcs.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.exam_prep.bcs.R
import com.exam_prep.bcs.customview.PagerIndicator
import com.exam_prep.bcs.databinding.ActivityAppTourBinding
import com.exam_prep.bcs.util.CommonConstants
import com.exam_prep.bcs.viewmodel.AppTourViewModel
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

class AppTourActivity : BCSActivity() {

    private lateinit var appTourViewModel: AppTourViewModel


    private val TOTAL_TOUR_PAGE_COUNT = 4
    private var mPagerIndicator: PagerIndicator? = null

    private lateinit var binding: ActivityAppTourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_app_tour)
        appTourViewModel = getViewModel()

        if(intent.hasExtra("is_logout")) {
            Snackbar.make(this.window.decorView.rootView, "You need to login again!" , Snackbar.LENGTH_LONG).show();
        }

        val tourPageAdapter = TourPagerAdapter(supportFragmentManager)
        binding.tourPager.adapter = tourPageAdapter

        binding.letsGoButton.setOnClickListener {
//            val intent = Intent(this@AppTourActivity, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
        }

        binding.pagerIndicator.setup(
            R.drawable.pager_indicator_selected,
            R.drawable.pager_indicator_unselected,4
        )

        binding.tourPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                binding.pagerIndicator!!.setSelectedPosition(position)
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })
    }

    override fun createPriyoViewModel() =
        ViewModelProviders.of(this)[AppTourViewModel::class.java]


    class TourFragment : Fragment() {
        @Nullable
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return try {
                if (getArguments() != null) {
                    val layoutResId: Int = requireArguments().getInt(RES_ID)
                    if (layoutResId != 0) inflater.inflate(
                        layoutResId,
                        container,
                        false
                    ) else View(getContext())
                } else View(getContext())
            } catch (e: Exception) {
                View(getContext())
            }
        }

        companion object {
            const val RES_ID = "RES_ID"
            fun newInstance(@LayoutRes layoutResId: Int): Fragment {
                val tourFragment = TourFragment()
                val bundle = Bundle()
                bundle.putInt(RES_ID, layoutResId)
                tourFragment.setArguments(bundle)
                return tourFragment
            }
        }
    }


    private class TourPagerAdapter internal constructor(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> TourFragment.newInstance(
                    R.layout.tour_first_page
                )
                1 -> TourFragment.newInstance(
                    R.layout.tour_second_page
                )
                2 -> TourFragment.newInstance(
                    R.layout.tour_third_page
                )
                else -> TourFragment()
            } as Fragment
        }

        override fun getCount(): Int {
            return 3
        }
    }
}