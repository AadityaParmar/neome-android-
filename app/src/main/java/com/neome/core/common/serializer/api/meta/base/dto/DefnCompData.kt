package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldAudioData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldAvtarData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldButtonData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldCameraData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldCarouselData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetDateData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetDateTimeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetDayData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetDeviceSizeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetDeviceTypeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldChipSetTimeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldColorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldCounterData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldCurrencyData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDateData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDateRangeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDateTimeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDateTimeRangeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDecimalData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDividerData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDocumentData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDurationData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldDynamicData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldEditableData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldEmailData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldErrorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldFormListData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldFormListItemData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldGeoPointData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldHandleData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldHtmlData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldHyperlinkData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldHyperlinkRowData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldIconData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldIdentifierData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldImageData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldInfoData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLabelData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLanguageData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLineStrokeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLocationData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLogCounterData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLogDecimalData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLogNumberData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldMessageTypeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldMobileNumberData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldMonthData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldNumberData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldOtpData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPasswordData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPaymentStatusData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickEnumData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickGridRowData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickReportRowData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickRoleData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickTreeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickUserData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPinShapeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPropertyMapData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldQuarterData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldRatingData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldRefContactData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldRefData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldRefReportData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldRefSetData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldRefTargetData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldRefUserData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldRowIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldScanCodeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSchedulerIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSetOfDocumentData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSetOfRoleData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSetOfTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSetOfUserData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldShowCodeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSignatureData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSliderData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSwitchData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSymbolData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldTextSizeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldTimeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldTimeZoneData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldVideoData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldVoiceData
import com.neome.core.common.serializer.api.meta.base.dto.DefnGridData
import com.neome.core.common.serializer.api.meta.base.dto.DefnSectionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnSpreadsheetRefData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildActionPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildAllModulesData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildArgBinderData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildColorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildDateData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildDateTimeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildMappingData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildOptionPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildPropertyMapData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildRefTargetSpreadsheetData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildTreeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioBuildUserSettingData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioCodeEditorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioCompArrayData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfArgBinderData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfConditionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDynamicConditionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDynamicRuleData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfFormulaData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfForwardGroupPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfForwardRolePermissionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfFuncArgData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfJarFileData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfLayoutDriveSheetData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfLayoutGridData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfLayoutSpreadsheetData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfMappingData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfPartitionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfPipelineVariableData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfUserConditionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfVisibilityActionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfVisibilityConditionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickActionIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickAutomationIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickCompIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickDeeplinkIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickFieldIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickFormIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickGridIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickGroupIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickImportPluginApiIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickImportPluginIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickLayoutFormContentIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickLayoutGridIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickLayoutSpreadsheetIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickPipelineVarIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickPluginBundleIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickPluginCompIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickPluginFieldIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickPluginFormIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickPluginIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickReportIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickSectionIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickSpreadsheetIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickSpreadsheetRefLayoutIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioPickVarIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfActionIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfAdminDoNotOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfDateData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfDocFileExtData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfFieldRefIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfLayoutFormContentIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfLayoutGridIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfModuleData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfMonthData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfNumberData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfPluginSecurityAccessData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfReportIdData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfRowAuditTrailData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioSetOfStoreItemCategoryData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioVarIdParagraphEditorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioVarIdTextEditorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnTabData
import com.neome.core.common.serializer.api.meta.base.dto.DefnWizardData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive


@Serializable(with = DefnCompSerializer::class)
sealed interface DefnCompSeal : DefnComp


@Serializable
data class DefnCompData(
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val disabledVar: Boolean? = null,
    override val hidden: Boolean? = null,
    override val hideDirtyIndicator: Boolean? = null,
    override val invisible: Boolean? = null,
    override val label: String? = null,
    override val maxWidth: Long? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pb: Long? = null,
    override val permissionMatrix: DefnDtoPermissionMatrixData? = null,
    override val pl: Long? = null,
    override val pr: Long? = null,
    override val pt: Long? = null,
    override val readOnly: Boolean? = null,
    override val type: EnumDefnCompType
) : DefnCompSeal, DefnComp

object DefnCompSerializer : JsonContentPolymorphicSerializer<DefnCompSeal>(
    DefnCompSeal::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DefnCompSeal> {
        val type = element.jsonObject["type"]?.jsonPrimitive?.content
        return when (type) {
            EnumDefnCompType.bool.value -> DefnFieldSwitchData.serializer()
            EnumDefnCompType.date.value -> DefnFieldDateData.serializer()
            EnumDefnCompType.decimal.value -> DefnFieldDecimalData.serializer()
            EnumDefnCompType.logDecimal.value -> DefnFieldLogDecimalData.serializer()
            EnumDefnCompType.image.value -> DefnFieldImageData.serializer()
            EnumDefnCompType.label.value -> DefnFieldLabelData.serializer()
            EnumDefnCompType.number.value -> DefnFieldNumberData.serializer()
            EnumDefnCompType.logNumber.value -> DefnFieldLogNumberData.serializer()
            EnumDefnCompType.paragraph.value -> DefnFieldParagraphData.serializer()
            EnumDefnCompType.text.value -> DefnFieldTextData.serializer()
            EnumDefnCompType.enumAdminDoNotOptionEnt.value -> DefnFieldPickEnumData.serializer()
            EnumDefnCompType.enumAdminDoNotOptionPlugin.value -> DefnCompData.serializer()
            EnumDefnCompType.enumAudioFormat.value -> DefnCompData.serializer()
            EnumDefnCompType.enumAutomationSource.value -> DefnCompData.serializer()
            EnumDefnCompType.enumCaptureValueKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumCodeEditorLanguage.value -> DefnCompData.serializer()
            EnumDefnCompType.enumConditionOperator.value -> DefnCompData.serializer()
            EnumDefnCompType.enumConjunction.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDataPartitionPeriod.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDate.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDay.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDeeplinkConstraints.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDeployVar.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDeviceSize.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDeviceType.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDocFileExt.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDriveStatus.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDurationUnit.value -> DefnCompData.serializer()
            EnumDefnCompType.enumEntLockBehavior.value -> DefnCompData.serializer()
            EnumDefnCompType.enumEntLockReason.value -> DefnCompData.serializer()
            EnumDefnCompType.enumFields.value -> DefnCompData.serializer()
            EnumDefnCompType.enumFuncArgs.value -> DefnCompData.serializer()
            EnumDefnCompType.enumMapPinShape.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPaymentMethod.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPaymentPlan.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPermission.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPluginApiMethod.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPluginAuthMethod.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPluginResources.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPluginSecurityAccess.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPromptAction.value -> DefnCompData.serializer()
            EnumDefnCompType.enumRoles.value -> DefnCompData.serializer()
            EnumDefnCompType.enumRowAuditTrail.value -> DefnCompData.serializer()
            EnumDefnCompType.enumSetupKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumUserSettingOptions.value -> DefnCompData.serializer()
            EnumDefnCompType.enumUserSettingValue.value -> DefnCompData.serializer()
            EnumDefnCompType.enumVideoFormat.value -> DefnCompData.serializer()
            EnumDefnCompType.enumVisibilityOperator.value -> DefnCompData.serializer()
            EnumDefnCompType.enumMonth.value -> DefnCompData.serializer()
            EnumDefnCompType.enumQuarter.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDeeplinkExpiry.value -> DefnCompData.serializer()
            EnumDefnCompType.enumForms.value -> DefnCompData.serializer()
            EnumDefnCompType.enumLogOperationKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumCodeType.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPosition.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDateOccurrence.value -> DefnCompData.serializer()
            EnumDefnCompType.enumFrequencyKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumRenderingKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumInsertVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumUpdateVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumRemoveVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumEmptyFieldVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumTableLayoutStyle.value -> DefnCompData.serializer()
            EnumDefnCompType.enumUserProperty.value -> DefnCompData.serializer()
            EnumDefnCompType.enumRowProperty.value -> DefnCompData.serializer()
            EnumDefnCompType.enumStoreItem.value -> DefnCompData.serializer()
            EnumDefnCompType.enumCaptureMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumLockOperation.value -> DefnCompData.serializer()
            EnumDefnCompType.enumRefreshOn.value -> DefnCompData.serializer()
            EnumDefnCompType.enumEditorLayoutRenderingMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumFormLayoutType.value -> DefnCompData.serializer()
            EnumDefnCompType.enumSetOfUserKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumUserContext.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDynamicOperator.value -> DefnCompData.serializer()
            EnumDefnCompType.enumTargetType.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDriveSheetLayoutFor.value -> DefnCompData.serializer()
            EnumDefnCompType.enumDriveSheetFieldLayoutOn.value -> DefnCompData.serializer()
            EnumDefnCompType.enumTextStyle.value -> DefnCompData.serializer()
            EnumDefnCompType.enumContentAlignment.value -> DefnCompData.serializer()
            EnumDefnCompType.enumUserProps.value -> DefnCompData.serializer()
            EnumDefnCompType.enumGridRenderingMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPaymentMethodKind.value -> DefnFieldEditableData.serializer()
            EnumDefnCompType.enumSortOrder.value -> DefnCompData.serializer()
            EnumDefnCompType.enumTextValidationPattern.value -> DefnCompData.serializer()
            EnumDefnCompType.enumSyncMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPluginMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumMapRenderingMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumCalculateFormulaMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumEjectionPolicy.value -> DefnCompData.serializer()
            EnumDefnCompType.enumRefSetOperationKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumEntStage.value -> DefnCompData.serializer()
            EnumDefnCompType.enumFreezeAvatarKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumTableLayoutTheme.value -> DefnCompData.serializer()
            EnumDefnCompType.enumChartRenderingMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeImageRenderingMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPromptAttachmentFormat.value -> DefnCompData.serializer()
            EnumDefnCompType.enumLocationCapturingMode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumArgBinderContext.value -> DefnCompData.serializer()
            EnumDefnCompType.enumArgBinder.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindAction.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindActionUIUpdate.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindAutomation.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindButton.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindDeeplink.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindFormComposite.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindHyperlink.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindImport.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindRating.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindReport.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindScheduledEvent.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindAutomationStep.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindSpreadsheetEvent.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindPluginWebhookEvent.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindWebhookEvent.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindTranslation.value -> DefnCompData.serializer()
            EnumDefnCompType.enumTerminateSetting.value -> DefnCompData.serializer()
            EnumDefnCompType.enumAutomationWebhookKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumLocationAccuracy.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindAutoEdge.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindAutoNode.value -> DefnCompData.serializer()
            EnumDefnCompType.enumKindSpreadsheetUniqueness.value -> DefnCompData.serializer()
            EnumDefnCompType.enumLayoutCardFilterKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumLayoutGridKind.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeButtonSize.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeButtonVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeColor.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeColorShade.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeDirection.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeDividerThickness.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeFieldMargin.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeFieldSize.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeFieldVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeFormVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeImageCorner.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemePickVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemePickMultiVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumPlacement.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeSectionVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeStroke.value -> DefnCompData.serializer()
            EnumDefnCompType.enumThemeTabVariant.value -> DefnCompData.serializer()
            EnumDefnCompType.enumVisibilityAction.value -> DefnCompData.serializer()
            EnumDefnCompType.enumVisibilityActionOn.value -> DefnCompData.serializer()
            EnumDefnCompType.enumWizardNavigationMode.value -> DefnCompData.serializer()
            EnumDefnCompType.currency.value -> DefnFieldCurrencyData.serializer()
            EnumDefnCompType.icon.value -> DefnFieldIconData.serializer()
            EnumDefnCompType.language.value -> DefnFieldLanguageData.serializer()
            EnumDefnCompType.timeZone.value -> DefnFieldTimeZoneData.serializer()
            EnumDefnCompType.pinShape.value -> DefnFieldPinShapeData.serializer()
            EnumDefnCompType.lineStroke.value -> DefnFieldLineStrokeData.serializer()
            EnumDefnCompType.month.value -> DefnFieldMonthData.serializer()
            EnumDefnCompType.quarter.value -> DefnFieldQuarterData.serializer()
            EnumDefnCompType.textSize.value -> DefnFieldTextSizeData.serializer()
            EnumDefnCompType.paymentStatus.value -> DefnFieldPaymentStatusData.serializer()
            EnumDefnCompType.messageKind.value -> DefnFieldMessageTypeData.serializer()
            EnumDefnCompType.chipSet.value -> DefnFieldChipSetData.serializer()
            EnumDefnCompType.chipSetDate.value -> DefnFieldChipSetDateData.serializer()
            EnumDefnCompType.chipSetDateTime.value -> DefnFieldChipSetDateTimeData.serializer()
            EnumDefnCompType.chipSetDay.value -> DefnFieldChipSetDayData.serializer()
            EnumDefnCompType.chipSetDeviceSize.value -> DefnFieldChipSetDeviceSizeData.serializer()
            EnumDefnCompType.chipSetDeviceType.value -> DefnFieldChipSetDeviceTypeData.serializer()
            EnumDefnCompType.chipSetTime.value -> DefnFieldChipSetTimeData.serializer()
            EnumDefnCompType.pickRole.value -> DefnFieldPickRoleData.serializer()
            EnumDefnCompType.pickText.value -> DefnFieldPickTextData.serializer()
            EnumDefnCompType.pickTree.value -> DefnFieldPickTreeData.serializer()
            EnumDefnCompType.pickUser.value -> DefnFieldPickUserData.serializer()
            EnumDefnCompType.pickGridRow.value -> DefnFieldPickGridRowData.serializer()
            EnumDefnCompType.pickReportRow.value -> DefnFieldPickReportRowData.serializer()
            EnumDefnCompType.setOfRole.value -> DefnFieldSetOfRoleData.serializer()
            EnumDefnCompType.setOfUser.value -> DefnFieldSetOfUserData.serializer()
            EnumDefnCompType.setOfText.value -> DefnFieldSetOfTextData.serializer()
            EnumDefnCompType.color.value -> DefnFieldColorData.serializer()
            EnumDefnCompType.hyperlink.value -> DefnFieldHyperlinkData.serializer()
            EnumDefnCompType.audio.value -> DefnFieldAudioData.serializer()
            EnumDefnCompType.camera.value -> DefnFieldCameraData.serializer()
            EnumDefnCompType.counter.value -> DefnFieldCounterData.serializer()
            EnumDefnCompType.logCounter.value -> DefnFieldLogCounterData.serializer()
            EnumDefnCompType.dateRange.value -> DefnFieldDateRangeData.serializer()
            EnumDefnCompType.dateTime.value -> DefnFieldDateTimeData.serializer()
            EnumDefnCompType.dateTimeRange.value -> DefnFieldDateTimeRangeData.serializer()
            EnumDefnCompType.duration.value -> DefnFieldDurationData.serializer()
            EnumDefnCompType.email.value -> DefnFieldEmailData.serializer()
            EnumDefnCompType.handle.value -> DefnFieldHandleData.serializer()
            EnumDefnCompType.location.value -> DefnFieldLocationData.serializer()
            EnumDefnCompType.mobileNumber.value -> DefnFieldMobileNumberData.serializer()
            EnumDefnCompType.rating.value -> DefnFieldRatingData.serializer()
            EnumDefnCompType.signature.value -> DefnFieldSignatureData.serializer()
            EnumDefnCompType.slider.value -> DefnFieldSliderData.serializer()
            EnumDefnCompType.time.value -> DefnFieldTimeData.serializer()
            EnumDefnCompType.video.value -> DefnFieldVideoData.serializer()
            EnumDefnCompType.voice.value -> DefnFieldVoiceData.serializer()
            EnumDefnCompType.geoPoint.value -> DefnFieldGeoPointData.serializer()
            EnumDefnCompType.rowId.value -> DefnFieldRowIdData.serializer()
            EnumDefnCompType.symbol.value -> DefnFieldSymbolData.serializer()
            EnumDefnCompType.schedulerId.value -> DefnFieldSchedulerIdData.serializer()
            EnumDefnCompType.spreadsheetId.value -> DefnCompData.serializer()
            EnumDefnCompType.button.value -> DefnFieldButtonData.serializer()
            EnumDefnCompType.divider.value -> DefnFieldDividerData.serializer()
            EnumDefnCompType.document.value -> DefnFieldDocumentData.serializer()
            EnumDefnCompType.error.value -> DefnFieldErrorData.serializer()
            EnumDefnCompType.html.value -> DefnFieldHtmlData.serializer()
            EnumDefnCompType.identifier.value -> DefnFieldIdentifierData.serializer()
            EnumDefnCompType.info.value -> DefnFieldInfoData.serializer()
            EnumDefnCompType.propertyMap.value -> DefnFieldPropertyMapData.serializer()
            EnumDefnCompType.scanCode.value -> DefnFieldScanCodeData.serializer()
            EnumDefnCompType.setOfDocument.value -> DefnFieldSetOfDocumentData.serializer()
            EnumDefnCompType.showCode.value -> DefnFieldShowCodeData.serializer()
            EnumDefnCompType.userId.value -> DefnFieldUserIdData.serializer()
            EnumDefnCompType.dynamic.value -> DefnFieldDynamicData.serializer()
            EnumDefnCompType.hyperlinkRow.value -> DefnFieldHyperlinkRowData.serializer()
            EnumDefnCompType.password.value -> DefnFieldPasswordData.serializer()
            EnumDefnCompType.ref.value -> DefnFieldRefData.serializer()
            EnumDefnCompType.refSet.value -> DefnFieldRefSetData.serializer()
            EnumDefnCompType.refUser.value -> DefnFieldRefUserData.serializer()
            EnumDefnCompType.refReport.value -> DefnFieldRefReportData.serializer()
            EnumDefnCompType.refTarget.value -> DefnFieldRefTargetData.serializer()
            EnumDefnCompType.refContact.value -> DefnFieldRefContactData.serializer()
            EnumDefnCompType.grid.value -> DefnGridData.serializer()
            EnumDefnCompType.section.value -> DefnSectionData.serializer()
            EnumDefnCompType.spreadsheetRef.value -> DefnSpreadsheetRefData.serializer()
            EnumDefnCompType.tab.value -> DefnTabData.serializer()
            EnumDefnCompType.wizard.value -> DefnWizardData.serializer()
            EnumDefnCompType.dateFormat.value -> DefnCompData.serializer()
            EnumDefnCompType.studioVarIdTextEditor.value -> DefnStudioVarIdTextEditorData.serializer()
            EnumDefnCompType.studioVarIdParagraphEditor.value -> DefnStudioVarIdParagraphEditorData.serializer()
            EnumDefnCompType.studioCodeEditor.value -> DefnStudioCodeEditorData.serializer()
            EnumDefnCompType.pickActionId.value -> DefnStudioPickActionIdData.serializer()
            EnumDefnCompType.pickCompId.value -> DefnStudioPickCompIdData.serializer()
            EnumDefnCompType.pickPluginCompId.value -> DefnStudioPickPluginCompIdData.serializer()
            EnumDefnCompType.pickFieldId.value -> DefnStudioPickFieldIdData.serializer()
            EnumDefnCompType.pickPluginFieldId.value -> DefnStudioPickPluginFieldIdData.serializer()
            EnumDefnCompType.pickFormId.value -> DefnStudioPickFormIdData.serializer()
            EnumDefnCompType.pickPluginFormId.value -> DefnStudioPickPluginFormIdData.serializer()
            EnumDefnCompType.pickGridId.value -> DefnStudioPickGridIdData.serializer()
            EnumDefnCompType.pickImportPluginId.value -> DefnStudioPickImportPluginIdData.serializer()
            EnumDefnCompType.pickImportPluginApiId.value -> DefnStudioPickImportPluginApiIdData.serializer()
            EnumDefnCompType.pickLayoutFormContentId.value -> DefnStudioPickLayoutFormContentIdData.serializer()
            EnumDefnCompType.pickLayoutGridId.value -> DefnStudioPickLayoutGridIdData.serializer()
            EnumDefnCompType.pickSpreadsheetRefLayoutId.value -> DefnStudioPickSpreadsheetRefLayoutIdData.serializer()
            EnumDefnCompType.pickLayoutSpreadsheetId.value -> DefnStudioPickLayoutSpreadsheetIdData.serializer()
            EnumDefnCompType.pickPluginBundleId.value -> DefnStudioPickPluginBundleIdData.serializer()
            EnumDefnCompType.pickPluginId.value -> DefnStudioPickPluginIdData.serializer()
            EnumDefnCompType.pickReportId.value -> DefnStudioPickReportIdData.serializer()
            EnumDefnCompType.pickSectionId.value -> DefnStudioPickSectionIdData.serializer()
            EnumDefnCompType.pickSpreadsheetId.value -> DefnStudioPickSpreadsheetIdData.serializer()
            EnumDefnCompType.pickVarId.value -> DefnStudioPickVarIdData.serializer()
            EnumDefnCompType.pickGroupId.value -> DefnStudioPickGroupIdData.serializer()
            EnumDefnCompType.pickDeeplinkId.value -> DefnStudioPickDeeplinkIdData.serializer()
            EnumDefnCompType.pickPipelineVarId.value -> DefnStudioPickPipelineVarIdData.serializer()
            EnumDefnCompType.pickDeployPaymentProviderId.value -> DefnCompData.serializer()
            EnumDefnCompType.pickAutomationId.value -> DefnStudioPickAutomationIdData.serializer()
            EnumDefnCompType.studioBuildAllModules.value -> DefnStudioBuildAllModulesData.serializer()
            EnumDefnCompType.studioBuildArgBinder.value -> DefnStudioBuildArgBinderData.serializer()
            EnumDefnCompType.studioSetOfDate.value -> DefnStudioSetOfDateData.serializer()
            EnumDefnCompType.studioBuildColor.value -> DefnStudioBuildColorData.serializer()
            EnumDefnCompType.studioBuildDate.value -> DefnStudioBuildDateData.serializer()
            EnumDefnCompType.studioBuildDateTime.value -> DefnStudioBuildDateTimeData.serializer()
            EnumDefnCompType.studioBuildPermissionMatrix.value -> DefnStudioBuildPermissionMatrixData.serializer()
            EnumDefnCompType.studioBuildTree.value -> DefnStudioBuildTreeData.serializer()
            EnumDefnCompType.studioBuildUserSetting.value -> DefnStudioBuildUserSettingData.serializer()
            EnumDefnCompType.studioBuildActionPermission.value -> DefnStudioBuildActionPermissionData.serializer()
            EnumDefnCompType.studioBuildPropertyMap.value -> DefnStudioBuildPropertyMapData.serializer()
            EnumDefnCompType.studioBuildMapping.value -> DefnStudioBuildMappingData.serializer()
            EnumDefnCompType.studioBuildVideoTimestampMap.value -> DefnCompData.serializer()
            EnumDefnCompType.studioBuildOptionPermissionMatrix.value -> DefnStudioBuildOptionPermissionMatrixData.serializer()
            EnumDefnCompType.studioMapOfForwardRolePermission.value -> DefnStudioMapOfForwardRolePermissionData.serializer()
            EnumDefnCompType.studioMapOfCondition.value -> DefnStudioMapOfConditionData.serializer()
            EnumDefnCompType.studioMapOfFormula.value -> DefnStudioMapOfFormulaData.serializer()
            EnumDefnCompType.studioMapOfFuncArg.value -> DefnStudioMapOfFuncArgData.serializer()
            EnumDefnCompType.studioMapOfJarFile.value -> DefnStudioMapOfJarFileData.serializer()
            EnumDefnCompType.studioMapOfLayoutSpreadsheet.value -> DefnStudioMapOfLayoutSpreadsheetData.serializer()
            EnumDefnCompType.studioMapOfLayoutGrid.value -> DefnStudioMapOfLayoutGridData.serializer()
            EnumDefnCompType.studioMapOfText.value -> DefnStudioMapOfTextData.serializer()
            EnumDefnCompType.studioMapOfVisibilityCondition.value -> DefnStudioMapOfVisibilityConditionData.serializer()
            EnumDefnCompType.studioMapOfVisibilityAction.value -> DefnStudioMapOfVisibilityActionData.serializer()
            EnumDefnCompType.studioMapOfPartition.value -> DefnStudioMapOfPartitionData.serializer()
            EnumDefnCompType.studioMapOfForwardGroupPermission.value -> DefnStudioMapOfForwardGroupPermissionData.serializer()
            EnumDefnCompType.studioMapOfDynamicRule.value -> DefnStudioMapOfDynamicRuleData.serializer()
            EnumDefnCompType.studioMapOfPipelineVariable.value -> DefnStudioMapOfPipelineVariableData.serializer()
            EnumDefnCompType.studioMapOfDynamicCondition.value -> DefnStudioMapOfDynamicConditionData.serializer()
            EnumDefnCompType.studioMapOfUserCondition.value -> DefnStudioMapOfUserConditionData.serializer()
            EnumDefnCompType.studioMapOfLayoutDriveSpreadsheet.value -> DefnStudioMapOfLayoutDriveSheetData.serializer()
            EnumDefnCompType.studioFieldMappingTree.value -> DefnStudioMapOfMappingData.serializer()
            EnumDefnCompType.studioGridMappingTree.value -> DefnCompData.serializer()
            EnumDefnCompType.studioMapOfArgBinder.value -> DefnStudioMapOfArgBinderData.serializer()
            EnumDefnCompType.studioMapOfRefTargetSpreadsheet.value -> DefnStudioBuildRefTargetSpreadsheetData.serializer()
            EnumDefnCompType.studioSetOfDocFileExt.value -> DefnStudioSetOfDocFileExtData.serializer()
            EnumDefnCompType.studioSetOfStoreItemCategory.value -> DefnStudioSetOfStoreItemCategoryData.serializer()
            EnumDefnCompType.studioSetOfModule.value -> DefnStudioSetOfModuleData.serializer()
            EnumDefnCompType.studioSetOfNumber.value -> DefnStudioSetOfNumberData.serializer()
            EnumDefnCompType.studioSetOfAdminDoNotOption.value -> DefnStudioSetOfAdminDoNotOptionData.serializer()
            EnumDefnCompType.studioSetOfPluginSecurityAccess.value -> DefnStudioSetOfPluginSecurityAccessData.serializer()
            EnumDefnCompType.studioSetOfRowAuditTrail.value -> DefnStudioSetOfRowAuditTrailData.serializer()
            EnumDefnCompType.studioSetOfMonth.value -> DefnStudioSetOfMonthData.serializer()
            EnumDefnCompType.studioSetOfBorder.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfBorderRadius.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfCompId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfDataExportKind.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfLanguageKeys.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfActionId.value -> DefnStudioSetOfActionIdData.serializer()
            EnumDefnCompType.studioSetOfFieldId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfPluginFieldId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfFieldRefId.value -> DefnStudioSetOfFieldRefIdData.serializer()
            EnumDefnCompType.studioSetOfFormId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfGridId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfGroupId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfLayoutFormContentId.value -> DefnStudioSetOfLayoutFormContentIdData.serializer()
            EnumDefnCompType.studioSetOfLayoutGridId.value -> DefnStudioSetOfLayoutGridIdData.serializer()
            EnumDefnCompType.studioSetOfLayoutSpreadsheetId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfReportId.value -> DefnStudioSetOfReportIdData.serializer()
            EnumDefnCompType.studioSetOfSectionId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfSpreadsheetId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioSetOfVarId.value -> DefnCompData.serializer()
            EnumDefnCompType.studioCompArray.value -> DefnStudioCompArrayData.serializer()
            EnumDefnCompType.otp.value -> DefnFieldOtpData.serializer()
            EnumDefnCompType.avtar.value -> DefnFieldAvtarData.serializer()
            EnumDefnCompType.carousel.value -> DefnFieldCarouselData.serializer()
            EnumDefnCompType.formList.value -> DefnFieldFormListData.serializer()
            EnumDefnCompType.formListItem.value -> DefnFieldFormListItemData.serializer()
            EnumDefnCompType.pickKeychain.value -> DefnCompData.serializer()
            EnumDefnCompType.pickOption.value -> DefnFieldPickOptionData.serializer()
            EnumDefnCompType.wallpaper.value -> DefnCompData.serializer()
            else -> DefnCompData.serializer()
        }
    }
}
