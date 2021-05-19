package edu.bc.cs470assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.bc.cs470assignment2.R
import edu.bc.cs470assignment2.Timer
import edu.bc.cs470assignment2.databinding.FragmentFirstBinding
import timber.log.Timber


class FirstFragment : Fragment() {

    private lateinit var timer: Timer
    private lateinit var binding: FragmentFirstBinding
    private var second = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentFirstBinding>(
            inflater,
            R.layout.fragment_first, container, false
        )
        

        runTimer()




        binding.button.setOnClickListener {
            timer.stopTimer()
            this.findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToSecondFragment().setSecond(second)
            )
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            this@FirstFragment.findNavController()
                .navigate(R.id.action_firstFragment_to_titleFragment)
        }
        callback.isEnabled = true


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
        Timber.i("RunTimerCalled")
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