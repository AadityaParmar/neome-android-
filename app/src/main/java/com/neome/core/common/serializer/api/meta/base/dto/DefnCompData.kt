package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumStudioCompType
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
            EnumStudioCompType.bool.value -> DefnFieldSwitchData.serializer()
            EnumStudioCompType.date.value -> DefnFieldDateData.serializer()
            EnumStudioCompType.decimal.value -> DefnFieldDecimalData.serializer()
            EnumStudioCompType.logDecimal.value -> DefnFieldLogDecimalData.serializer()
            EnumStudioCompType.image.value -> DefnFieldImageData.serializer()
            EnumStudioCompType.label.value -> DefnFieldLabelData.serializer()
            EnumStudioCompType.number.value -> DefnFieldNumberData.serializer()
            EnumStudioCompType.logNumber.value -> DefnFieldLogNumberData.serializer()
            EnumStudioCompType.paragraph.value -> DefnFieldParagraphData.serializer()
            EnumStudioCompType.text.value -> DefnFieldTextData.serializer()
            EnumStudioCompType.chipSet.value -> DefnFieldChipSetData.serializer()
            EnumStudioCompType.chipSetDate.value -> DefnFieldChipSetDateData.serializer()
            EnumStudioCompType.chipSetDateTime.value -> DefnFieldChipSetDateTimeData.serializer()
            EnumStudioCompType.chipSetDay.value -> DefnFieldChipSetDayData.serializer()
            EnumStudioCompType.chipSetDeviceSize.value -> DefnFieldChipSetDeviceSizeData.serializer()
            EnumStudioCompType.chipSetDeviceType.value -> DefnFieldChipSetDeviceTypeData.serializer()
            EnumStudioCompType.chipSetTime.value -> DefnFieldChipSetTimeData.serializer()
            EnumStudioCompType.currency.value -> DefnFieldCurrencyData.serializer()
            EnumStudioCompType.icon.value -> DefnFieldIconData.serializer()
            EnumStudioCompType.language.value -> DefnFieldLanguageData.serializer()
            EnumStudioCompType.timeZone.value -> DefnFieldTimeZoneData.serializer()
            EnumStudioCompType.pinShape.value -> DefnFieldPinShapeData.serializer()
            EnumStudioCompType.lineStroke.value -> DefnFieldLineStrokeData.serializer()
            EnumStudioCompType.paymentStatus.value -> DefnFieldPaymentStatusData.serializer()
            EnumStudioCompType.month.value -> DefnFieldMonthData.serializer()
            EnumStudioCompType.quarter.value -> DefnFieldQuarterData.serializer()
            EnumStudioCompType.textSize.value -> DefnFieldTextSizeData.serializer()
            EnumStudioCompType.messageKind.value -> DefnFieldMessageTypeData.serializer()
            EnumStudioCompType.pickRole.value -> DefnFieldPickRoleData.serializer()
            EnumStudioCompType.pickText.value -> DefnFieldPickTextData.serializer()
            EnumStudioCompType.pickTree.value -> DefnFieldPickTreeData.serializer()
            EnumStudioCompType.pickUser.value -> DefnFieldPickUserData.serializer()
            EnumStudioCompType.pickGridRow.value -> DefnFieldPickGridRowData.serializer()
            EnumStudioCompType.pickReportRow.value -> DefnFieldPickReportRowData.serializer()
            EnumStudioCompType.setOfRole.value -> DefnFieldSetOfRoleData.serializer()
            EnumStudioCompType.setOfUser.value -> DefnFieldSetOfUserData.serializer()
            EnumStudioCompType.setOfText.value -> DefnFieldSetOfTextData.serializer()
            EnumStudioCompType.color.value -> DefnFieldColorData.serializer()
            EnumStudioCompType.hyperlink.value -> DefnFieldHyperlinkData.serializer()
            EnumStudioCompType.audio.value -> DefnFieldAudioData.serializer()
            EnumStudioCompType.camera.value -> DefnFieldCameraData.serializer()
            EnumStudioCompType.counter.value -> DefnFieldCounterData.serializer()
            EnumStudioCompType.logCounter.value -> DefnFieldLogCounterData.serializer()
            EnumStudioCompType.dateRange.value -> DefnFieldDateRangeData.serializer()
            EnumStudioCompType.dateTime.value -> DefnFieldDateTimeData.serializer()
            EnumStudioCompType.dateTimeRange.value -> DefnFieldDateTimeRangeData.serializer()
            EnumStudioCompType.duration.value -> DefnFieldDurationData.serializer()
            EnumStudioCompType.email.value -> DefnFieldEmailData.serializer()
            EnumStudioCompType.handle.value -> DefnFieldHandleData.serializer()
            EnumStudioCompType.location.value -> DefnFieldLocationData.serializer()
            EnumStudioCompType.mobileNumber.value -> DefnFieldMobileNumberData.serializer()
            EnumStudioCompType.rating.value -> DefnFieldRatingData.serializer()
            EnumStudioCompType.signature.value -> DefnFieldSignatureData.serializer()
            EnumStudioCompType.slider.value -> DefnFieldSliderData.serializer()
            EnumStudioCompType.time.value -> DefnFieldTimeData.serializer()
            EnumStudioCompType.video.value -> DefnFieldVideoData.serializer()
            EnumStudioCompType.voice.value -> DefnFieldVoiceData.serializer()
            EnumStudioCompType.geoPoint.value -> DefnFieldGeoPointData.serializer()
            EnumStudioCompType.rowId.value -> DefnFieldRowIdData.serializer()
            EnumStudioCompType.symbol.value -> DefnFieldSymbolData.serializer()
            EnumStudioCompType.schedulerId.value -> DefnFieldSchedulerIdData.serializer()
            EnumStudioCompType.spreadsheetId.value -> DefnCompData.serializer()
            EnumStudioCompType.button.value -> DefnFieldButtonData.serializer()
            EnumStudioCompType.divider.value -> DefnFieldDividerData.serializer()
            EnumStudioCompType.document.value -> DefnFieldDocumentData.serializer()
            EnumStudioCompType.error.value -> DefnFieldErrorData.serializer()
            EnumStudioCompType.html.value -> DefnFieldHtmlData.serializer()
            EnumStudioCompType.identifier.value -> DefnFieldIdentifierData.serializer()
            EnumStudioCompType.info.value -> DefnFieldInfoData.serializer()
            EnumStudioCompType.propertyMap.value -> DefnFieldPropertyMapData.serializer()
            EnumStudioCompType.scanCode.value -> DefnFieldScanCodeData.serializer()
            EnumStudioCompType.setOfDocument.value -> DefnFieldSetOfDocumentData.serializer()
            EnumStudioCompType.showCode.value -> DefnFieldShowCodeData.serializer()
            EnumStudioCompType.userId.value -> DefnFieldUserIdData.serializer()
            EnumStudioCompType.dynamic.value -> DefnFieldDynamicData.serializer()
            EnumStudioCompType.hyperlinkRow.value -> DefnFieldHyperlinkRowData.serializer()
            EnumStudioCompType.password.value -> DefnFieldPasswordData.serializer()
            EnumStudioCompType.ref.value -> DefnFieldRefData.serializer()
            EnumStudioCompType.refSet.value -> DefnFieldRefSetData.serializer()
            EnumStudioCompType.refUser.value -> DefnFieldRefUserData.serializer()
            EnumStudioCompType.refReport.value -> DefnFieldRefReportData.serializer()
            EnumStudioCompType.refTarget.value -> DefnFieldRefTargetData.serializer()
            EnumStudioCompType.refContact.value -> DefnFieldRefContactData.serializer()
            EnumStudioCompType.grid.value -> DefnGridData.serializer()
            EnumStudioCompType.section.value -> DefnSectionData.serializer()
            EnumStudioCompType.spreadsheetRef.value -> DefnSpreadsheetRefData.serializer()
            else -> DefnCompData.serializer()
        }
    }
}
