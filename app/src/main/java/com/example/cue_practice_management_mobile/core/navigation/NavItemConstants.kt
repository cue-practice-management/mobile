package com.example.cue_practice_management_mobile.core.navigation

import com.composables.icons.lucide.BellRing
import com.composables.icons.lucide.Building2
import com.composables.icons.lucide.House
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Rocket
import com.example.cue_practice_management_mobile.core.models.NavItem


//TODO: Change the routes to the constants when the view is created
object NAV_ITEMS {
    val HOME = NavItem(Routes.STUDENT_HOME, Lucide.House, "Inicio")
    val COMPANIES = NavItem("companies", Lucide.Building2, "Empresas")
    val EXPLORE = NavItem("explore", Lucide.Rocket, "Explorar")
    val NOTIFICATIONS = NavItem("notifications", Lucide.BellRing, "Notificaciones")

    val BOTTOM_NAV_ITEMS = listOf(HOME, COMPANIES, EXPLORE, NOTIFICATIONS)
}

