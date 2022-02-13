package com.flaviosf.digitaldoctor.ui.search.doctor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.databinding.ItemSearchDoctorListBinding
import com.flaviosf.digitaldoctor.model.Doctor

class SearchDoctorStepListAdapter(private var _doctors: List<Doctor>) :
    RecyclerView.Adapter<SearchDoctorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDoctorViewHolder {
        val binding =
            ItemSearchDoctorListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchDoctorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchDoctorViewHolder, position: Int) {
        holder.bind(_doctors[position])
    }

    override fun getItemCount(): Int = _doctors.size

    fun updateList(doctors: List<Doctor>) {
        _doctors = doctors
        notifyDataSetChanged()
    }

}

class SearchDoctorViewHolder(private val binding: ItemSearchDoctorListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(doctor: Doctor) {
        binding.itemDoctorName.text = doctor.name
        if (doctor.isFavorite) {
            Glide.with(binding.root)
                .load(R.drawable.ic_favorite)
                .into(binding.itemDoctorFavorite)
        }
        binding.itemDoctorSpecialty.text = doctor.specialty
        binding.itemDoctorExperience.text = doctor.experience.toString()
    }
}