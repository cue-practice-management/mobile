package com.example.cue_practice_management_mobile.domain.models

import com.example.cue_practice_management_mobile.domain.enums.CompanySize
import java.util.Date

data class Company (
    val _id: String,
    val name: String,
    val logoUrl: String?,
    val corporateName: String,
    val nit: String,
    val phone: String,
    val websiteUrl: String,
    val address: String,
    val size: CompanySize,
    val city: City,
    val country: Country,
    val associatedAcademicPrograms: List<AcademicProgram>?,
    val createdAt: Date,
    val updatedAt: Date,
)

data class CompanyBasicInfo(
    val _id: String,
    val name: String,
    val logoUrl: String?,
    val corporateName: String,
    val nit: String,
    val phone: String,
    val websiteUrl: String,
    val address: String,
    val size: CompanySize,
) {
}
