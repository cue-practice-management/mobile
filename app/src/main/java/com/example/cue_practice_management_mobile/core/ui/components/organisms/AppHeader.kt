package com.example.cue_practice_management_mobile.core.ui.components.organisms

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.LogOut
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppLogo
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppLogoSize
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppUserAvatar
import com.example.cue_practice_management_mobile.domain.models.User
import com.composables.icons.lucide.Lucide

@Composable
fun AppHeader(
    user: User,
    onLogout: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppUserAvatar(
            photoUrl = user.photoUrl,
            size = 40
        )
        Spacer(modifier = Modifier.weight(1f))
        AppLogo(size = AppLogoSize.ExtraLarge)
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = onLogout,
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                imageVector = Lucide.LogOut,
                contentDescription = "Logout",
                modifier = Modifier.size(36.dp)
            )
        }
    }
}