package com.uteev.mafiaproject.presentation.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.uteev.mafiaproject.R
import com.uteev.mafiaproject.databinding.StartGameFBinding

class StartFragment : Fragment() {


    private val viewModel : StartViewModel by viewModels()
    private var _binding : StartGameFBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = StartGameFBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val clickAnimation = AnimationUtils.loadAnimation(context, R.anim.button_click)
        val controller = findNavController()
        binding.sgfStartGame.setOnClickListener {
            it.startAnimation(clickAnimation)
            controller.navigate(R.id.gameFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}