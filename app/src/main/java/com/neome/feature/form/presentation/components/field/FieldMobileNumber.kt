package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueMobileData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

// ============================================================================
// Country Code Data
// ============================================================================

/**
 * Represents a country with its timezone label and dialing code.
 */
data class CountryCode(
    val label: String,
    val code: String
)

/**
 * List of all supported country codes.
 * Organized by region for easier maintenance.
 */
private val COUNTRY_CODES: List<CountryCode> = listOf(
    // Africa
    CountryCode("Africa/Abidjan", "+225"),
    CountryCode("Africa/Accra", "+233"),
    CountryCode("Africa/Addis_Ababa", "+251"),
    CountryCode("Africa/Algiers", "+213"),
    CountryCode("Africa/Cairo", "+20"),
    CountryCode("Africa/Casablanca", "+212"),
    CountryCode("Africa/Dakar", "+221"),
    CountryCode("Africa/Douala", "+237"),
    CountryCode("Africa/Johannesburg", "+27"),
    CountryCode("Africa/Kampala", "+256"),
    CountryCode("Africa/Khartoum", "+249"),
    CountryCode("Africa/Lagos", "+234"),
    CountryCode("Africa/Luanda", "+244"),
    CountryCode("Africa/Nairobi", "+254"),
    CountryCode("Africa/Zambia", "+260"),

    // America
    CountryCode("America/Asuncion", "+595"),
    CountryCode("America/Belize", "+501"),
    CountryCode("America/Bogota", "+57"),
    CountryCode("America/Buenos_Aires", "+54"),
    CountryCode("America/Caracas", "+58"),
    CountryCode("America/Chicago", "+1"),
    CountryCode("America/Costa_Rica", "+506"),
    CountryCode("America/Denver", "+1"),
    CountryCode("America/El_Salvador", "+503"),
    CountryCode("America/Guatemala", "+502"),
    CountryCode("America/Guayaquil", "+593"),
    CountryCode("America/La_Paz", "+591"),
    CountryCode("America/Lima", "+51"),
    CountryCode("America/Los_Angeles", "+1"),
    CountryCode("America/Managua", "+505"),
    CountryCode("America/Mexico_City", "+52"),
    CountryCode("America/Montevideo", "+598"),
    CountryCode("America/New_York", "+1"),
    CountryCode("America/Nuuk", "+299"),
    CountryCode("America/Panama", "+507"),
    CountryCode("America/Puerto_Rico", "+1"),
    CountryCode("America/Santiago", "+56"),
    CountryCode("America/Santo_Domingo", "+1"),
    CountryCode("America/Sao_Paulo", "+55"),
    CountryCode("America/Tegucigalpa", "+504"),
    CountryCode("America/Toronto", "+1"),
    CountryCode("America/Vancouver", "+1"),

    // Asia
    CountryCode("Asia/Almaty", "+7"),
    CountryCode("Asia/Ashgabat", "+993"),
    CountryCode("Asia/Baghdad", "+964"),
    CountryCode("Asia/Baku", "+994"),
    CountryCode("Asia/Bangkok", "+66"),
    CountryCode("Asia/Bishkek", "+996"),
    CountryCode("Asia/Calcutta", "+91"),
    CountryCode("Asia/Dubai", "+971"),
    CountryCode("Asia/Dushanbe", "+992"),
    CountryCode("Asia/Ho_Chi_Minh", "+84"),
    CountryCode("Asia/Hong_Kong", "+852"),
    CountryCode("Asia/Jakarta", "+62"),
    CountryCode("Asia/Jerusalem", "+972"),
    CountryCode("Asia/Karachi", "+92"),
    CountryCode("Asia/Kolkata", "+91"),
    CountryCode("Asia/Kuala_Lumpur", "+60"),
    CountryCode("Asia/Manila", "+63"),
    CountryCode("Asia/Nicosia", "+357"),
    CountryCode("Asia/Riyadh", "+966"),
    CountryCode("Asia/Seoul", "+82"),
    CountryCode("Asia/Shanghai", "+86"),
    CountryCode("Asia/Singapore", "+65"),
    CountryCode("Asia/Taipei", "+886"),
    CountryCode("Asia/Tashkent", "+998"),
    CountryCode("Asia/Tbilisi", "+995"),
    CountryCode("Asia/Tokyo", "+81"),
    CountryCode("Asia/Yerevan", "+374"),

    // Atlantic
    CountryCode("Atlantic/Faroe", "+298"),
    CountryCode("Atlantic/Reykjavik", "+354"),

    // Australia
    CountryCode("Australia/Sydney", "+61"),

    // Europe
    CountryCode("Europe/Amsterdam", "+31"),
    CountryCode("Europe/Athens", "+30"),
    CountryCode("Europe/Belgrade", "+381"),
    CountryCode("Europe/Berlin", "+49"),
    CountryCode("Europe/Bratislava", "+421"),
    CountryCode("Europe/Brussels", "+32"),
    CountryCode("Europe/Bucharest", "+40"),
    CountryCode("Europe/Budapest", "+36"),
    CountryCode("Europe/Chisinau", "+373"),
    CountryCode("Europe/Copenhagen", "+45"),
    CountryCode("Europe/Dublin", "+353"),
    CountryCode("Europe/Gibraltar", "+350"),
    CountryCode("Europe/Helsinki", "+358"),
    CountryCode("Europe/Istanbul", "+90"),
    CountryCode("Europe/Kiev", "+380"),
    CountryCode("Europe/Lisbon", "+351"),
    CountryCode("Europe/Ljubljana", "+386"),
    CountryCode("Europe/London", "+44"),
    CountryCode("Europe/Luxembourg", "+352"),
    CountryCode("Europe/Madrid", "+34"),
    CountryCode("Europe/Malta", "+356"),
    CountryCode("Europe/Minsk", "+375"),
    CountryCode("Europe/Monaco", "+377"),
    CountryCode("Europe/Moscow", "+7"),
    CountryCode("Europe/Oslo", "+47"),
    CountryCode("Europe/Paris", "+33"),
    CountryCode("Europe/Prague", "+420"),
    CountryCode("Europe/Riga", "+371"),
    CountryCode("Europe/Rome", "+39"),
    CountryCode("Europe/Sofia", "+359"),
    CountryCode("Europe/Stockholm", "+46"),
    CountryCode("Europe/Tallinn", "+372"),
    CountryCode("Europe/Vatican", "+379"),
    CountryCode("Europe/Vienna", "+43"),
    CountryCode("Europe/Vilnius", "+370"),
    CountryCode("Europe/Warsaw", "+48"),
    CountryCode("Europe/Zagreb", "+385"),
    CountryCode("Europe/Zurich", "+41"),

    // Indian
    CountryCode("Indian/Antananarivo", "+261"),
    CountryCode("Indian/Mahe", "+248"),
    CountryCode("Indian/Maldives", "+960"),
    CountryCode("Indian/Mauritius", "+230"),

    // Pacific
    CountryCode("Pacific/Apia", "+685"),
    CountryCode("Pacific/Auckland", "+64"),
    CountryCode("Pacific/Chuuk", "+691"),
    CountryCode("Pacific/Efate", "+678"),
    CountryCode("Pacific/Fiji", "+679"),
    CountryCode("Pacific/Funafuti", "+688"),
    CountryCode("Pacific/Guadalcanal", "+677"),
    CountryCode("Pacific/Majuro", "+692"),
    CountryCode("Pacific/Nauru", "+674"),
    CountryCode("Pacific/Noumea", "+687"),
    CountryCode("Pacific/Palau", "+680"),
    CountryCode("Pacific/Port_Moresby", "+675"),
    CountryCode("Pacific/Tarawa", "+686"),
    CountryCode("Pacific/Tongatapu", "+676")
)

/**
 * Default country code (India).
 */
private val DEFAULT_COUNTRY_CODE = COUNTRY_CODES.find { it.code == "+91" } ?: COUNTRY_CODES.first()

// ============================================================================
// Validation
// ============================================================================

private const val DEFAULT_MOBILE_LENGTH = 10

/**
 * Validates the mobile number.
 *
 * @param mobileNumber The mobile number to validate (without country code)
 * @param expectedLength Expected length of mobile number
 * @return Error message if invalid, null if valid
 */
private fun validateMobileNumber(mobileNumber: String, expectedLength: Int = DEFAULT_MOBILE_LENGTH): String? {
    if (mobileNumber.isEmpty()) return null // Empty is valid (handled by required check)

    // Check for non-digit characters
    if (!mobileNumber.all { it.isDigit() }) {
        return "Mobile number must contain only digits"
    }

    // Check length
    if (mobileNumber.length != expectedLength) {
        return "Mobile number must be $expectedLength digits"
    }

    return null
}

/**
 * Filters input to only allow digits.
 */
private fun filterDigitsOnly(input: String): String {
    return input.filter { it.isDigit() }
}

/**
 * Parses a stored value into country code and mobile number.
 * Stored format: "+<code> <number>" or "+<code><number>"
 *
 * @param value The stored value
 * @return Pair of (country code string, mobile number)
 */
private fun parseStoredValue(value: String?): Pair<String, String> {
    if (value.isNullOrBlank()) return Pair(DEFAULT_COUNTRY_CODE.code, "")

    val trimmed = value.trim()
    if (!trimmed.startsWith("+")) return Pair(DEFAULT_COUNTRY_CODE.code, trimmed)

    // Try to find matching country code
    for (country in COUNTRY_CODES.sortedByDescending { it.code.length }) {
        if (trimmed.startsWith(country.code)) {
            val remaining = trimmed.removePrefix(country.code).trim()
            return Pair(country.code, remaining)
        }
    }

    // If no match, try to extract code and number
    val spaceIndex = trimmed.indexOf(' ')
    return if (spaceIndex > 0) {
        Pair(trimmed.substring(0, spaceIndex), trimmed.substring(spaceIndex + 1))
    } else {
        Pair(DEFAULT_COUNTRY_CODE.code, trimmed.removePrefix("+"))
    }
}

/**
 * Combines country code and mobile number into stored format.
 *
 * @param countryCode The country code (e.g., "+91")
 * @param mobileNumber The mobile number
 * @return Combined value in format "+<code> <number>"
 */
private fun combineValue(countryCode: String, mobileNumber: String): String {
    return if (mobileNumber.isEmpty()) "" else "$countryCode$mobileNumber"
}

// ============================================================================
// Main Component
// ============================================================================

/**
 * Mobile field component for form.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController, so this composable
 * must be called inside a Form composable tree.
 *
 * A composite field with a country code dropdown and mobile number input.
 * Looks like a single cohesive field with two coordinated parts.
 *
 * Key Features (reused from FieldText):
 * - Same state handling pattern and properties
 * - Same validation UI mechanism
 * - Same disabled/readOnly logic
 *
 * Mobile-specific Features:
 * - Country code dropdown with 100+ country options
 * - Digits-only input for mobile number
 * - Length validation (default 10 digits)
 * - Combined storage format: "+<code> <number>"
 *
 * Supported Properties:
 * - required
 * - disabled
 * - placeholder
 * - helperText (supportingText)
 * - defaultValue
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldMobile(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // ========== REUSED FROM FieldText: Field Controller Setup ==========
    val fieldController = rememberFieldController<FieldValueMobileData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // ========== REUSED FROM FieldText: Early Returns ==========
    if (fieldController.fieldId == null) return

    // ========== REUSED FROM FieldText: Reactive Properties ==========
    val properties by fieldController.fieldPropertiesFlow.collectAsStateWithLifecycle()

    if (properties.hidden) return

    // ========== Mobile-specific: Parse Current Value ==========
    val currentValue = fieldController.fieldValue?.value ?: ""
    val (initialCountryCode, initialMobileNumber) = remember(currentValue) {
        parseStoredValue(currentValue)
    }

    // ========== Mobile-specific: Local State ==========
    var selectedCountryCode by remember(initialCountryCode) {
        mutableStateOf(COUNTRY_CODES.find { it.code == initialCountryCode } ?: DEFAULT_COUNTRY_CODE)
    }
    var mobileNumber by remember(initialMobileNumber) { mutableStateOf(initialMobileNumber) }
    var isDropdownExpanded by remember { mutableStateOf(false) }

    // ========== Mobile-specific: Validation ==========
    val validationError = validateMobileNumber(mobileNumber)
    val isError = validationError != null

    // ========== Mobile-specific: Value Change Handlers ==========
    fun emitCombinedValue() {
        val combined = combineValue(selectedCountryCode.code, mobileNumber)
        val fieldValue = if (combined.isEmpty()) null else FieldValueMobileData(combined)
        fieldController.onChange(fieldValue)
    }

    fun onCountryCodeSelected(country: CountryCode) {
        selectedCountryCode = country
        isDropdownExpanded = false
        emitCombinedValue()
    }

    fun onMobileNumberChange(newValue: String) {
        // Filter to digits only and limit length
        val filtered = filterDigitsOnly(newValue).take(DEFAULT_MOBILE_LENGTH)
        mobileNumber = filtered
        emitCombinedValue()
    }

    // ========== REUSED FROM FieldText: FieldBase Wrapper ==========
    FieldBase(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            // ========== Left Section: Country Code Dropdown ==========
            ExposedDropdownMenuBox(
                expanded = isDropdownExpanded && !properties.disabled,
                onExpandedChange = { if (!properties.disabled) isDropdownExpanded = it },
                modifier = Modifier.width(140.dp)
            ) {
                OutlinedTextField(
                    value = selectedCountryCode.code,
                    onValueChange = { /* Read-only */ },
                    readOnly = true,
                    enabled = !properties.disabled,
                    isError = isError,
                    label = { Text("Country code") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded)
                    },
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                    modifier = Modifier.menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable),
                    singleLine = true
                )

                ExposedDropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false }
                ) {
                    COUNTRY_CODES.forEach { country ->
                        DropdownMenuItem(
                            text = {
                                Text("${country.code}")
                            },
                            onClick = { onCountryCodeSelected(country) },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // ========== Right Section: Mobile Number Input ==========
            OutlinedTextField(
                value = mobileNumber,
                onValueChange = ::onMobileNumberChange,
                label = properties.label?.let { { Text(it) } },
                placeholder = properties.placeholder?.let { { Text(it) } },
                supportingText = {
                    when {
                        validationError != null -> {
                            Text(
                                text = validationError,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                        properties.helperText != null -> {
                            Text(properties.helperText!!)
                        }
                    }
                },
                isError = isError,
                enabled = !properties.disabled,
                readOnly = properties.readOnly,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
