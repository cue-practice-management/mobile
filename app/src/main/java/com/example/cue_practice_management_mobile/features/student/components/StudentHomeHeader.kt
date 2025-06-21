package com.example.cue_practice_management_mobile.features.student.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.CircleUserRound
import com.composables.icons.lucide.Lucide
import com.example.cue_practice_management_mobile.domain.models.Student
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun StudentHomeHeader(student: Student) {
    val currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale("es", "ES")))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Column {
            Text(
                text = currentDate.replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "¡Bienvenido, ${student.firstName}!",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Tu portal de prácticas empresariales",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
        Icon(
            imageVector = Lucide.CircleUserRound,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(40.dp)
                .alpha(0.2f),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}