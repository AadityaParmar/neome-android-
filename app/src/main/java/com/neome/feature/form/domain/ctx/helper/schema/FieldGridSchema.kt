package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnGrid
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueGridData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldGrid.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - minRows: number of rows must be >= minRowsVar (from DefnGrid)
 * - maxRows: number of rows must be <= maxRowsVar (from DefnGrid)
 */
class FieldGridSchema(
    override val defnForm: DefnFormData,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnGrid

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            // For grid, null value means 0 rows
            return validateRowCount(0)
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueGridData.serializer(),
                fieldValue
            )
        } catch (e: Exception) {
            null
        }

        val rowCount = typedValue?.keys?.size ?: 0

        val validation = buildValidation()
        val result = validation(rowCount)

        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun validateRowCount(rowCount: Int): String? {
        val validation = buildValidation()
        val result = validation(rowCount)
        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun buildValidation(): Validation<Int> {
        return Validation {
            // Min rows validation
            defnField.minRowsVar?.let { minRows ->
                constrain("Rows can't be less than $minRows") { count ->
                    count >= minRows
                }
            }

            // Max rows validation
            defnField.maxRowsVar?.let { maxRows ->
                constrain("Rows can't be more than $maxRows") { count ->
                    count <= maxRows
                }
            }
        }
    }
}
