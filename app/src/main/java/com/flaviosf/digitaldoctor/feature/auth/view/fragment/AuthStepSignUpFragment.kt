package com.flaviosf.digitaldoctor.feature.auth.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.flaviosf.digitaldoctor.feature.auth.view.IAuthCallbacks
import com.flaviosf.digitaldoctor.databinding.FragmentAuthStepSignUpBinding

class AuthStepSignUpFragment : Fragment() {

    private lateinit var binding: FragmentAuthStepSignUpBinding
    private lateinit var callback: IAuthCallbacks

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            !is IAuthCallbacks -> {
                throw RuntimeException("Interface ILoginCallbacks não foi implementada em LoginActivity")
            }
            else -> callback = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthStepSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.haveAnAccountButton.setOnClickListener {
            //callback.goToLoginFragment()
            findNavController().popBackStack()
        }
    }

}