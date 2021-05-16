package edu.bc.cs470assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import edu.bc.cs470assignment2.R
import edu.bc.cs470assignment2.Timer
import edu.bc.cs470assignment2.databinding.FragmentFirstBinding
import timber.log.Timber


class FirstFragment : Fragment() {

    private lateinit var timer: Timer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFirstBinding>(
            inflater,
            R.layout.fragment_first, container, false
        )

        var second = 0
        timer = Timer("SecondFrag Timer")
        timer.startTimer {
            second++
            if (second == 60) {
                second = 0
            }

            binding.progBar.progress = second.toFloat()
            Timber.i("one second.")
        }


        return binding.root
    }

    override fun onPause() {
        super.onPause()
        timer.stopTimer()
    }

    override fun onResume() {
        super.onResume()
        timer.stopTimer()
    }

}