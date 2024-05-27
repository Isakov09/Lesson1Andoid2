package com.example.lesson1andoid2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson1andoid2.R
import com.example.lesson1andoid2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToFragment()

    }

    private fun goToFragment() = with(binding) {
        binding.btnSignUp.setOnClickListener{
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            val bundle = Bundle().apply {
                putString(NAME, name)
                putString(EMAIL, email)
                putString(PASSWORD,password)
            }
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.root
    }

    companion object{
        const val NAME = "name"
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }
}