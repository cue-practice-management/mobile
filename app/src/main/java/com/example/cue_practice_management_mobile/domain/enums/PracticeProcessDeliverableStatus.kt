package com.example.cue_practice_management_mobile.domain.enums

enum class PracticeProcessDeliverableStatus(statusValue: String) {
    SCHEDULED("scheduled"),
    PENDING("pending"),
    SUBMITTED("submitted"),
    SUBMITTED_LATE("submitted_late"),
    GRADED("graded");
}