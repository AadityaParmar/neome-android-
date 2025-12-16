package com.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldShowcase(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Text Fields", style = MaterialTheme.typography.headlineSmall)

        var text1 by remember { mutableStateOf("") }
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Filled TextField") },
            modifier = Modifier.fillMaxWidth()
        )

        var text2 by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Outlined TextField") },
            modifier = Modifier.fillMaxWidth()
        )

        var text3 by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text3,
            onValueChange = { text3 = it },
            label = { Text("With Leading Icon") },
            leadingIcon = {
                Icon(Icons.Filled.Person, contentDescription = null)
            },
            modifier = Modifier.fillMaxWidth()
        )

        var text4 by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text4,
            onValueChange = { text4 = it },
            label = { Text("With Trailing Icon") },
            trailingIcon = {
                IconButton(onClick = { text4 = "" }) {
                    Icon(Icons.Filled.Clear, contentDescription = "Clear")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        var errorText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = errorText,
            onValueChange = { errorText = it },
            label = { Text("Email") },
            isError = errorText.isNotEmpty() && !errorText.contains("@"),
            supportingText = {
                if (errorText.isNotEmpty() && !errorText.contains("@")) {
                    Text("Invalid email address")
                }
            },
            leadingIcon = {
                Icon(Icons.Filled.Email, contentDescription = null)
            },
            modifier = Modifier.fillMaxWidth()
        )

        var disabledText by remember { mutableStateOf("Disabled") }
        OutlinedTextField(
            value = disabledText,
            onValueChange = { disabledText = it },
            label = { Text("Disabled TextField") },
            enabled = false,
            modifier = Modifier.fillMaxWidth()
        )

        var multilineText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = multilineText,
            onValueChange = { multilineText = it },
            label = { Text("Multiline TextField") },
            minLines = 3,
            maxLines = 5,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldShowcasePreview() {
    MaterialTheme {
        TextFieldShowcase()
    }
}
