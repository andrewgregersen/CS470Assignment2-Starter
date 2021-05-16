package edu.bc.cs470assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import edu.bc.cs470assignment2.R
import edu.bc.cs470assignment2.Timer
import edu.bc.cs470assignment2.databinding.FragmentThirdBinding
import timber.log.Timber

class ThirdFragment : Fragment() {

    private lateinit var timer: Timer
    private lateinit var binding: FragmentThirdBinding
    private var second = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentThirdBinding>(
            inflater,
            R.layout.fragment_third, container, false
        )

        runTimer()


        return binding.root
    }

    override fun onPause() {
        super.onPause()
        timer.stopTimer()
    }

    override fun onResume() {
        super.onResume()
        runTimer()
    }

    private fun runTimer() {
        timer = Timer("SecondFrag Timer")
        timer.startTimer {
            second++
            if (second == 60) {
                second = 0
            }

            binding.progBar.progress = second.toFloat()
            Timber.i("one second.")
        }
    }

}