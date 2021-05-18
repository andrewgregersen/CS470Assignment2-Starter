package edu.bc.cs470assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.bc.cs470assignment2.databinding.FragmentTitleBinding


class titleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )

        binding.button2.setOnClickListener {
            this.findNavController()
                .navigate(titleFragmentDirections.actionTitleFragmentToFirstFragment())
        }

        return binding.root
    }

}