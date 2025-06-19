package com.example.cue_practice_management_mobile.core.ui.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppUserAvatar(
    photoUrl: String?,
    contentDescription: String? = "User Avatar",
    size: Int = 40,
) {
    if (photoUrl.isNullOrBlank()) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(size.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
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