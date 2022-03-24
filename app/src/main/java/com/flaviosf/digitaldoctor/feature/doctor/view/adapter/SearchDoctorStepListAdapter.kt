package com.flaviosf.digitaldoctor.feature.doctor.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.common.domain.model.doctor.Doctor
import com.flaviosf.digitaldoctor.databinding.ItemDoctorSearchListBinding

class SearchDoctorStepListAdapter : RecyclerView.Adapter<SearchDoctorViewHolder>() {

    private var _doctors: List<Doctor> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDoctorViewHolder =
        SearchDoctorViewHolder(
            ItemDoctorSearchListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SearchDoctorViewHolder, position: Int) {
        holder.bind(_doctors[position])
    }

    override fun getItemCount(): Int = _doctors.size

    fun updateList(doctors: List<Doctor>) {
        _doctors = doctors
        notifyDataSetChanged()
    }
}

class SearchDoctorViewHolder(private val binding: ItemDoctorSearchListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(doctor: Doctor) {

        with(binding) {
            itemDoctorName.text = doctor.name
            itemDoctorSpecialty.text = doctor.specialty
            itemDoctorExperience.text = doctor.experience

            if (doctor.isFavorite) {
                Glide.with(binding.root)
                    .load(R.drawable.ic_favorite)
                    .into(binding.itemDoctorFavorite)
            }

            Glide.with(binding.root)
                .load(R.drawable.ic_logo)
                .into(binding.itemDoctorPhoto)
        }
    }
}