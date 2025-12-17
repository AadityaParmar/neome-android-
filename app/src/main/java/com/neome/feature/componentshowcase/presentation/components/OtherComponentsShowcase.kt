package com.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherComponentsShowcase(
    modifier: Modifier = Modifier
) {
    var showSnackbar by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            snackbarHostState.showSnackbar(
                message = "This is a snackbar message",
                actionLabel = "Action",
                duration = SnackbarDuration.Short
            )
            showSnackbar = false
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Other Components", style = MaterialTheme.typography.headlineSmall)

            HorizontalDivider()
            Text("Badges", style = MaterialTheme.typography.titleMedium)

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BadgedBox(badge = { Badge { Text("3") } }) {
                    Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                }

                BadgedBox(badge = { Badge() }) {
                    Icon(Icons.Filled.Email, contentDescription = "Email")
                }

                BadgedBox(badge = { Badge { Text("99+") } }) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart")
                }
            }

            HorizontalDivider()
            Text("Chips", style = MaterialTheme.typography.titleMedium)

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                AssistChip(
                    onClick = {},
                    label = { Text("Assist") },
                    leadingIcon = {
                        Icon(Icons.Filled.Settings, contentDescription = null)
                    }
                )

                FilterChip(
                    selected = true,
                    onClick = {},
                    label = { Text("Filter") },
                    leadingIcon = {
                        Icon(Icons.Filled.Done, contentDescription = null)
                    }
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                InputChip(
                    selected = false,
                    onClick = {},
                    label = { Text("Input") }
                )

                SuggestionChip(
                    onClick = {},
                    label = { Text("Suggestion") }
                )
            }

            var selectedChip by remember { mutableStateOf(false) }
            ElevatedFilterChip(
                selected = selectedChip,
                onClick = { selectedChip = !selectedChip },
                label = { Text("Elevated Filter") },
                leadingIcon = if (selectedChip) {
                    { Icon(Icons.Filled.Done, contentDescription = null) }
                } else null
            )

            HorizontalDivider()
            Text("Dividers", style = MaterialTheme.typography.titleMedium)

            HorizontalDivider()
            HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.primary)

            HorizontalDivider()
            Text("List Items", style = MaterialTheme.typography.titleMedium)

            ListItem(
                headlineContent = { Text("One line list item") }
            )

            ListItem(
                headlineContent = { Text("Two line list item") },
                supportingContent = { Text("Supporting text") }
            )

            ListItem(
                headlineContent = { Text("List item with icon") },
                supportingContent = { Text("Supporting text") },
                leadingContent = {
                    Icon(Icons.Filled.Person, contentDescription = null)
                }
            )

            ListItem(
                headlineContent = { Text("List item with trailing") },
                supportingContent = { Text("Supporting text") },
                leadingContent = {
                    Icon(Icons.Filled.Person, contentDescription = null)
                },
                trailingContent = {
                    Icon(Icons.Filled.ChevronRight, contentDescription = null)
                }
            )

            HorizontalDivider()
            Text("Snackbar", style = MaterialTheme.typography.titleMedium)

            Button(
                onClick = { showSnackbar = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Show Snackbar")
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OtherComponentsShowcasePreview() {
    MaterialTheme {
        OtherComponentsShowcase()
    }
}
