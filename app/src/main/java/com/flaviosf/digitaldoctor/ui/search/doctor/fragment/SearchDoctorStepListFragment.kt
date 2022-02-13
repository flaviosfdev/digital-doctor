package com.flaviosf.digitaldoctor.ui.search.doctor.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.data.MockDoctors
import com.flaviosf.digitaldoctor.ui.search.doctor.adapter.SearchDoctorStepListAdapter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SearchDoctorStepListFragment : Fragment(R.layout.fragment_search_doctor_step_list) {

    private lateinit var recycler: RecyclerView
    private lateinit var searchDoctorEditText: TextInputEditText
    private lateinit var searchDoctorLayout: TextInputLayout
    private lateinit var adapter: SearchDoctorStepListAdapter
    private lateinit var noResultFoundImage: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchDoctorLayout = view.findViewById(R.id.search_doctor_input_layout)
        noResultFoundImage = view.findViewById(R.id.no_result_found_image)

        val doctors = MockDoctors.getDoctors()
        adapter = SearchDoctorStepListAdapter(doctors)

        searchDoctorEditText = view.findViewById(R.id.search_doctor_edit_text)
        recycler = view.findViewById(R.id.search_doctor_recycler)

        recycler.adapter = adapter

        searchDoctorEditText.doAfterTextChanged {
            val filtered = doctors.filter { doctor ->
                doctor.name.contains(
                    searchDoctorEditText.text.toString(), ignoreCase = true
                )
            }
            noResultFoundImage.isVisible = filtered.isEmpty()

            adapter.updateList(filtered)
        }

        searchDoctorLayout.setEndIconOnClickListener {
            searchDoctorEditText.setText("")
            adapter.updateList(doctors)
        }


    }

}