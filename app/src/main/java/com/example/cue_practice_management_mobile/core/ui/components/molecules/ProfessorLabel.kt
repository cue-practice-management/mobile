package com.example.cue_practice_management_mobile.core.ui.components.molecules

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.Files.append

@Composable
fun ProfessorLabel(professorName: String, modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Docente Asesor: ")
            }
            append(professorName)
        },
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier
    )
}