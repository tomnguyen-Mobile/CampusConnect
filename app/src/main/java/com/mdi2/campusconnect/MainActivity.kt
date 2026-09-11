package com.mdi2.campusconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

data class CampusResource(
    @param:StringRes val nameRes: Int,
    @param:StringRes val categoryRes: Int,
    @param:StringRes val hoursRes: Int,
    val lastUpdatedDate: LocalDate,
    val reviewCount: Int,
    val capacity: Int,
    val fee: Double,

)

val sampleResources = listOf(
    CampusResource(
        nameRes = R.string.resource_intl_office_name,
        categoryRes = R.string.resource_intl_office_category,
        hoursRes = R.string.resource_intl_office_hours,
        lastUpdatedDate = LocalDate.of(2026,8,3),
        reviewCount = 1,
        capacity = 15,
        fee = 0.0,
    ),
    CampusResource(
        nameRes = R.string.resource_library_name,
        categoryRes = R.string.resource_library_category,
        hoursRes = R.string.resource_library_hours,
        lastUpdatedDate = LocalDate.of(2026,10,8),
        reviewCount = 24,
        capacity = 15,
        fee = 0.0,
    ),
    CampusResource(
        nameRes = R.string.resource_veterans_name,
        categoryRes = R.string.resource_veterans_category,
        hoursRes = R.string.resource_veterans_hours,
        lastUpdatedDate = LocalDate.of(2026,8,15),
        reviewCount = 1,
        capacity = 30,
        fee = 0.0,
    ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CampusConnectScreen()

            }
        }
    }
}

@Composable
fun CampusConnectScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp),
    ) {
        Text(
            stringResource(R.string.app_title),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            stringResource(R.string.app_subtitle),
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(sampleResources) { resource ->
                ResourceCard(resource)
                Spacer(modifier = Modifier.height(8.dp))
            }
        } // end of LazyColumn
    } // end of column
}

@Composable
fun ResourceCard(resource: CampusResource) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                stringResource(resource.nameRes),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                stringResource(resource.categoryRes),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                stringResource(
                    R.string.hours_label,
                    stringResource(resource.hoursRes),
                )
            )
            Text(
                stringResource(
                    R.string.last_updated_label,
                    resource.lastUpdatedDate
                ),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}