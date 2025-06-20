package com.example.cue_practice_management_mobile.core.data.api;

import com.example.cue_practice_management_mobile.domain.models.Professor;

import retrofit2.http.GET;

public interface ProfessorService {

    @GET("/professors/me")
    Professor meProfessor();
}
