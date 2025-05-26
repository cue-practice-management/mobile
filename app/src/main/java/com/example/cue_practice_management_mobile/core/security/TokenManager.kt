package com.example.cue_practice_management_mobile.core.security

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_prefs")

    private val ACCESS_TOKEN = stringPreferencesKey("access_token")

    suspend fun saveToken(token: String) {
        context.dataStore.edit { it[ACCESS_TOKEN] = token }
    }

    val token: Flow<String?> = context.dataStore.data.map { it[ACCESS_TOKEN] }

    suspend fun clear() {
        context.dataStore.edit { it.clear() }
    }

}
