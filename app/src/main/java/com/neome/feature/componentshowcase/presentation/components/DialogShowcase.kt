package com.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogShowcase(
    modifier: Modifier = Modifier
) {
    var showAlertDialog by remember { mutableStateOf(false) }
    var showBasicDialog by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Dialogs & Sheets", style = MaterialTheme.typography.headlineSmall)

        Button(
            onClick = { showAlertDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Alert Dialog")
        }

        Button(
            onClick = { showBasicDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Basic Dialog")
        }

        Button(
            onClick = { showBottomSheet = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Bottom Sheet")
        }
    }

    // Alert Dialog
    if (showAlertDialog) {
        AlertDialog(
            onDismissRequest = { showAlertDialog = false },
            icon = { Icon(Icons.Filled.Info, contentDescription = null) },
            title = { Text("Alert Dialog Title") },
            text = { Text("This is an alert dialog with icon, title, text, and action buttons.") },
            confirmButton = {
                TextButton(onClick = { showAlertDialog = false }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAlertDialog = false }) {
                    Text("Dismiss")
                }
            }
        )
    }

    // Basic Dialog
    if (showBasicDialog) {
        BasicAlertDialog(
            onDismissRequest = { showBasicDialog = false }
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(
                        "Basic Dialog",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "This is a basic dialog that allows for more customization. You can add any content here.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { showBasicDialog = false }) {
                            Text("OK")
                        }
                    }
                }
            }
        }
    }

    // Bottom Sheet
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false }
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Bottom Sheet",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "This is a modal bottom sheet. It slides up from the bottom of the screen and can contain any content.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(16.dp))

                repeat(3) { index ->
                    ListItem(
                        headlineContent = { Text("Item ${index + 1}") },
                        supportingContent = { Text("Supporting text for item ${index + 1}") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { showBottomSheet = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Close")
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DialogShowcasePreview() {
    MaterialTheme {
        DialogShowcase()
    }
}
