package com.uteev.mafiaproject.presentation.screens.classic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.uteev.mafiaproject.R
import com.uteev.mafiaproject.databinding.ClassicGameFBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment() {
    private var _binding: ClassicGameFBinding? = null
    private val binding get() = _binding!!

    private val vm by viewModel<ClassicViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ClassicGameFBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        binding.backButton.setOnClickListener {
            controller.navigate(R.id.startFragment)
        }
        binding.cgfSaveLogin.setOnClickListener {
            val loginText = binding.cgfLoginSchool21.text.toString()
            lifecycleScope.launch {
                vm.saveUserLogin(paramEditText = loginText)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


