package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi

/**
 * Factory that creates appropriate CompSchema based on component type.
 *
 * Routes each [EnumDefnCompType] to its corresponding CompSchema implementation.
 * Returns null for composite types (section, tab, etc.) and display-only
 * fields that don't require validation.
 */
object CompSchemaFactory {

    fun buildFormSchemas(defnForm: DefnFormUi): Map<MetaIdComp, CompSchema> {
        return defnForm.compMap
            .mapNotNull { (fieldId, defnComp) ->
                val schema = this.create(defnForm, defnComp)
                schema?.let { fieldId to it }
            }
            .toMap()
    }

    /**
     * Creates a CompSchema for the given component definition.
     *
     * @param defnComp The component definition to create schema for
     * @return CompSchema for validation, or null for composite/display-only types
     */
    private fun create(defnForm: DefnFormUi, defnComp: DefnCompSeal): CompSchema? {
        return when (defnComp.type) {
            // ═══════════════════════════════════════════════════════════════
            // TEXT-BASED FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.text -> FieldTextSchema(defnForm, defnComp)
            EnumDefnCompType.password,
            EnumDefnCompType.icon,
            EnumDefnCompType.info,
            EnumDefnCompType.identifier -> null

            EnumDefnCompType.paragraph -> FieldParagraphSchema(defnForm, defnComp)
            EnumDefnCompType.hyperlink -> FieldHyperlinkSchema(defnForm, defnComp)
            EnumDefnCompType.symbol -> FieldSymbolSchema(defnForm, defnComp)
            EnumDefnCompType.handle -> FieldHandleSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // EMAIL FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.email -> FieldEmailSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // MOBILE NUMBER FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.mobileNumber -> FieldMobileNumberSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // OTP FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.otp -> FieldOtpSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // NUMBER FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.number,
            EnumDefnCompType.logNumber -> FieldNumberSchema(defnForm, defnComp)

            EnumDefnCompType.counter,
            EnumDefnCompType.logCounter -> null

            EnumDefnCompType.rating -> null

            // ═══════════════════════════════════════════════════════════════
            // DECIMAL FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.decimal,
            EnumDefnCompType.logDecimal -> FieldDecimalSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // DATE/TIME FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.date -> FieldDateSchema(defnForm, defnComp)
            EnumDefnCompType.time -> FieldTimeSchema(defnForm, defnComp)
            EnumDefnCompType.dateTime -> FieldDateTimeSchema(defnForm, defnComp)
            EnumDefnCompType.dateRange,
            EnumDefnCompType.dateTimeRange -> FieldDateRangeSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // DURATION FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.duration -> FieldDurationSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // BOOLEAN FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.bool -> FieldBoolSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // PICK/SELECTION FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.pickText -> FieldPickTextSchema(defnForm, defnComp)
            EnumDefnCompType.currency,
            EnumDefnCompType.pickOption -> FieldCurrencySchema(defnForm, defnComp)
            EnumDefnCompType.textSize -> FieldCurrencySchema(defnForm, defnComp)
            EnumDefnCompType.pickTree -> FieldPickTreeSchema(defnForm, defnComp)
            EnumDefnCompType.pickUser -> FieldPickUserSchema(defnForm, defnComp)
            EnumDefnCompType.pickRole -> FieldPickRoleSchema(defnForm, defnComp)
            EnumDefnCompType.pickGridRow,
            EnumDefnCompType.pickReportRow -> FieldPickGridRowSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // SET FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.setOfText -> FieldSetOfTextSchema(defnForm, defnComp)
            EnumDefnCompType.setOfUser -> FieldSetOfUserSchema(defnForm, defnComp)
            EnumDefnCompType.setOfRole -> FieldSetOfRoleSchema(defnForm, defnComp)
            EnumDefnCompType.setOfDocument -> FieldSetOfDocumentSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // CHIPSET FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.chipSet,
            EnumDefnCompType.chipSetDate,
            EnumDefnCompType.chipSetDateTime,
            EnumDefnCompType.chipSetDay,
            EnumDefnCompType.chipSetTime,
            EnumDefnCompType.chipSetDeviceSize,
            EnumDefnCompType.chipSetDeviceType -> FieldChipSetSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // MEDIA FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.image -> FieldImageSchema(defnForm, defnComp)
            EnumDefnCompType.camera -> FieldCameraSchema(defnForm, defnComp)
            EnumDefnCompType.video -> FieldVideoSchema(defnForm, defnComp)
            EnumDefnCompType.audio -> FieldAudioSchema(defnForm, defnComp)
            EnumDefnCompType.voice -> FieldVoiceSchema(defnForm, defnComp)
            EnumDefnCompType.document -> FieldDocumentSchema(defnForm, defnComp)
            EnumDefnCompType.signature -> FieldSignatureSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // LOCATION FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.location -> FieldLocationSchema(defnForm, defnComp)
            EnumDefnCompType.geoPoint -> null // GeoPoint is typically display-only

            // ═══════════════════════════════════════════════════════════════
            // COLOR FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.color -> FieldColorSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // SLIDER FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.slider -> FieldSliderSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // SCANCODE FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.scanCode -> FieldScanCodeSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // GRID FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.grid -> FieldGridSchema(defnForm, defnComp)

            // ═══════════════════════════════════════════════════════════════
            // REFERENCE FIELDS (no validation, read-only displays)
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.ref,
            EnumDefnCompType.refSet,
            EnumDefnCompType.refUser,
            EnumDefnCompType.refReport,
            EnumDefnCompType.refTarget,
            EnumDefnCompType.refContact -> null

            // ═══════════════════════════════════════════════════════════════
            // DISPLAY-ONLY FIELDS (no validation needed)
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.label,
            EnumDefnCompType.divider,
            EnumDefnCompType.html,
            EnumDefnCompType.error,
            EnumDefnCompType.button,
            EnumDefnCompType.showCode,
            EnumDefnCompType.dynamic,
            EnumDefnCompType.hyperlinkRow,
            EnumDefnCompType.propertyMap -> null

            // ═══════════════════════════════════════════════════════════════
            // COMPOSITE TYPES (no FieldState, no validation)
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.section,
            EnumDefnCompType.tab,
            EnumDefnCompType.wizard,
            EnumDefnCompType.spreadsheetRef -> null

            // ═══════════════════════════════════════════════════════════════
            // ID FIELDS (typically read-only)
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.rowId,
            EnumDefnCompType.schedulerId,
            EnumDefnCompType.spreadsheetId,
            EnumDefnCompType.userId -> null

            // ═══════════════════════════════════════════════════════════════
            // PICKER FIELDS (enum pickers, typically studio fields)
            // These use simple string validation - required check only
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.currency,
            EnumDefnCompType.language,
            EnumDefnCompType.timeZone,
            EnumDefnCompType.month,
            EnumDefnCompType.quarter,
            EnumDefnCompType.pinShape,
            EnumDefnCompType.lineStroke,
            EnumDefnCompType.textSize,
            EnumDefnCompType.paymentStatus,
            EnumDefnCompType.messageKind,
            EnumDefnCompType.dateFormat,
            EnumDefnCompType.pickVarId,
            EnumDefnCompType.pickActionId,
            EnumDefnCompType.pickCompId,
            EnumDefnCompType.pickPluginCompId,
            EnumDefnCompType.pickFieldId,
            EnumDefnCompType.pickPluginFieldId,
            EnumDefnCompType.pickFormId,
            EnumDefnCompType.pickPluginFormId,
            EnumDefnCompType.pickGridId,
            EnumDefnCompType.pickImportPluginId,
            EnumDefnCompType.pickImportPluginApiId,
            EnumDefnCompType.pickLayoutFormContentId,
            EnumDefnCompType.pickLayoutGridId,
            EnumDefnCompType.pickSpreadsheetRefLayoutId,
            EnumDefnCompType.pickLayoutSpreadsheetId,
            EnumDefnCompType.pickPluginBundleId,
            EnumDefnCompType.pickPluginId,
            EnumDefnCompType.pickReportId,
            EnumDefnCompType.pickSectionId,
            EnumDefnCompType.pickSpreadsheetId,
            EnumDefnCompType.pickGroupId,
            EnumDefnCompType.pickDeeplinkId,
            EnumDefnCompType.pickPipelineVarId,
            EnumDefnCompType.pickDeployPaymentProviderId,
            EnumDefnCompType.pickAutomationId -> null // Simple required validation if needed

            // ═══════════════════════════════════════════════════════════════
            // STUDIO FIELDS (no validation in form context)
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.studioVarIdTextEditor,
            EnumDefnCompType.studioVarIdParagraphEditor,
            EnumDefnCompType.studioCodeEditor,
            EnumDefnCompType.studioBuildAllModules,
            EnumDefnCompType.studioBuildArgBinder,
            EnumDefnCompType.studioSetOfDate,
            EnumDefnCompType.studioBuildColor,
            EnumDefnCompType.studioBuildDate,
            EnumDefnCompType.studioBuildDateTime,
            EnumDefnCompType.studioBuildPermissionMatrix,
            EnumDefnCompType.studioBuildTree,
            EnumDefnCompType.studioBuildUserSetting,
            EnumDefnCompType.studioBuildActionPermission,
            EnumDefnCompType.studioBuildPropertyMap,
            EnumDefnCompType.studioBuildMapping,
            EnumDefnCompType.studioBuildVideoTimestampMap,
            EnumDefnCompType.studioBuildOptionPermissionMatrix,
            EnumDefnCompType.studioMapOfForwardRolePermission,
            EnumDefnCompType.studioMapOfCondition,
            EnumDefnCompType.studioMapOfFormula,
            EnumDefnCompType.studioMapOfFuncArg,
            EnumDefnCompType.studioMapOfJarFile,
            EnumDefnCompType.studioMapOfLayoutSpreadsheet,
            EnumDefnCompType.studioMapOfLayoutGrid,
            EnumDefnCompType.studioMapOfText,
            EnumDefnCompType.studioMapOfVisibilityCondition,
            EnumDefnCompType.studioMapOfVisibilityAction,
            EnumDefnCompType.studioMapOfPartition,
            EnumDefnCompType.studioMapOfForwardGroupPermission,
            EnumDefnCompType.studioMapOfDynamicRule,
            EnumDefnCompType.studioMapOfPipelineVariable,
            EnumDefnCompType.studioMapOfDynamicCondition,
            EnumDefnCompType.studioMapOfUserCondition,
            EnumDefnCompType.studioMapOfLayoutDriveSpreadsheet,
            EnumDefnCompType.studioFieldMappingTree,
            EnumDefnCompType.studioGridMappingTree,
            EnumDefnCompType.studioMapOfArgBinder,
            EnumDefnCompType.studioMapOfRefTargetSpreadsheet,
            EnumDefnCompType.studioSetOfDocFileExt,
            EnumDefnCompType.studioSetOfStoreItemCategory,
            EnumDefnCompType.studioSetOfModule,
            EnumDefnCompType.studioSetOfNumber,
            EnumDefnCompType.studioSetOfAdminDoNotOption,
            EnumDefnCompType.studioSetOfPluginSecurityAccess,
            EnumDefnCompType.studioSetOfRowAuditTrail,
            EnumDefnCompType.studioSetOfMonth,
            EnumDefnCompType.studioSetOfBorder,
            EnumDefnCompType.studioSetOfBorderRadius,
            EnumDefnCompType.studioSetOfCompId -> null

            // ═══════════════════════════════════════════════════════════════
            // ENUM FIELDS (typically studio/admin fields)
            // ═══════════════════════════════════════════════════════════════
            else -> null
        }
    }
}
