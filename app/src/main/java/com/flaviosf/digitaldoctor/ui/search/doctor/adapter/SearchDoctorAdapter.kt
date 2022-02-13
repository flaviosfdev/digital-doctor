package com.flaviosf.digitaldoctor.ui.search.doctor.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.databinding.ItemSearchDoctorBinding
import com.flaviosf.digitaldoctor.model.Doctor

class SearchDoctorAdapter(private var _doctors: List<Doctor>) :
    RecyclerView.Adapter<SearchDoctorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDoctorViewHolder {
        val binding =
            ItemSearchDoctorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

class SearchDoctorViewHolder(private val binding: ItemSearchDoctorBinding) :
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