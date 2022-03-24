package com.flaviosf.digitaldoctor.feature.doctor.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.flaviosf.digitaldoctor.feature.auth.model.data.MockDoctors
import com.flaviosf.digitaldoctor.databinding.FragmentDoctorSearchListStepBinding
import com.flaviosf.digitaldoctor.feature.doctor.view.adapter.SearchDoctorStepListAdapter

class SearchDoctorStepListFragment : Fragment() {
    private lateinit var binding: FragmentDoctorSearchListStepBinding
    private val doctorStepListAdapter: SearchDoctorStepListAdapter = SearchDoctorStepListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoctorSearchListStepBinding.inflate(inflater, container, false)
        binding.searchDoctorRecycler.apply {
            adapter = doctorStepListAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val doctors = MockDoctors.getDoctors()
        doctorStepListAdapter.updateList(doctors = doctors)

        with(binding) {

            searchDoctorEditText.doAfterTextChanged {
                val filtered = doctors.filter { doctor ->
                    doctor.name.contains(
                        other = binding.searchDoctorEditText.text.toString(),
                        ignoreCase = true
                    )
                }
                noResultFoundImage.isVisible = filtered.isEmpty()
                doctorStepListAdapter.updateList(doctors = filtered)
            }

            searchDoctorInputLayout.setEndIconOnClickListener {
                searchDoctorEditText.setText("")
                doctorStepListAdapter.updateList(doctors = doctors)
            }

        }
    }

}