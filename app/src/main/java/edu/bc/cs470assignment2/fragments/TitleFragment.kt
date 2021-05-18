package edu.bc.cs470assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import edu.bc.cs470assignment2.R
import edu.bc.cs470assignment2.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )
        binding.button2.setOnClickListener {
            it.findNavController().navigate(R.id.action_titleFragment_to_firstFragment)
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            this@TitleFragment.findNavController()
                .navigate(R.id.action_secondFragment_to_titleFragment)
        }
        callback.isEnabled = true
        return binding.root

    }


}