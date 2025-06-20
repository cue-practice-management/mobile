package com.example.cue_practice_management_mobile.core.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.User

@Composable
fun AppUserAvatar(
    photoUrl: String?,
    contentDescription: String? = "User Avatar",
    size: Int = 40,
) {
    if (photoUrl.isNullOrBlank()) {
        Icon(
            imageVector = Lucide.User,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(size.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.background)
        )
    }
//    else {
//        Image(
//            painter = rememberAsyncImagePainter(photoUrl),
//            contentDescription = contentDescription,
//            modifier = Modifier
//                .size(size.dp)
//                .clip(CircleShape)
//        )
//    }
}