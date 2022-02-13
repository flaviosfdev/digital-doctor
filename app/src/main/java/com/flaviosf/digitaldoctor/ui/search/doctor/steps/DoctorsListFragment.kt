package com.flaviosf.digitaldoctor.ui.search.doctor.steps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.ui.search.doctor.MockDoctors
import com.flaviosf.digitaldoctor.ui.search.doctor.adapter.SearchDoctorAdapter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class DoctorsListFragment : Fragment(R.layout.fragment_doctors_list) {

    private lateinit var recycler: RecyclerView
    private lateinit var searchDoctorEditText: TextInputEditText
    private lateinit var searchDoctorLayout: TextInputLayout
    private lateinit var adapter: SearchDoctorAdapter
    private lateinit var noResultFoundImage: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchDoctorLayout = view.findViewById(R.id.search_doctor_input_layout)
        noResultFoundImage = view.findViewById(R.id.no_result_found_image)

        val doctors = MockDoctors.getDoctors()
        adapter = SearchDoctorAdapter(doctors)

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