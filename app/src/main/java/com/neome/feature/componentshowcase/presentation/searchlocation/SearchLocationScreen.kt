package com.neome.feature.componentshowcase.presentation.searchlocation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchLocationScreen(
    onDismiss: () -> Unit,
    onRetryLocation: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = modifier,
        dragHandle = null
    ) {
        RealSearchLocationComponent(
            onCancel = onDismiss,
            onRetryLocation = onRetryLocation,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.90f)
        )
    }
}
