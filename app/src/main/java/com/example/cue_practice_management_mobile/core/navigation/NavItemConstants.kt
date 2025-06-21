package com.example.cue_practice_management_mobile.core.navigation

import com.composables.icons.lucide.BellRing
import com.composables.icons.lucide.Building2
import com.composables.icons.lucide.House
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Rocket
import com.example.cue_practice_management_mobile.core.models.NavItem


object NAV_ITEMS {
    val STUDENT_HOME = NavItem(Routes.STUDENT_HOME, Lucide.House, "Inicio")
    val PROFESSOR_HOME = NavItem(Routes.PROFESSOR_HOME, Lucide.House, "Inicio Profesor")
    val COMPANIES = NavItem("companies", Lucide.Building2, "Empresas")
    val EXPLORE = NavItem("explore", Lucide.Rocket, "Explorar")
    val NOTIFICATIONS = NavItem("notifications", Lucide.BellRing, "Notificaciones")

    val STUDENT_BOTTOM_NAV_ITEMS = listOf(STUDENT_HOME, COMPANIES, EXPLORE, NOTIFICATIONS)
    val PROFESSOR_BOTTOM_NAV_ITEMS = listOf(PROFESSOR_HOME, COMPANIES, EXPLORE, NOTIFICATIONS)
}

