package com.example.cue_practice_management_mobile.domain.enums

enum class PracticeProcessStatus(statusName: String) {
    PENDING("pending"),
    IN_PROGRESS("in_progress"),
    COMPLETED("completed"),
    CANCELLED("cancelled");
}