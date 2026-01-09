package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldNumberData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSwitchData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldTextData
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
    override val disabledRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val disabledVar: Boolean? = null,
    override val hidden: Boolean? = null,
    override val hideDirtyIndicator: Boolean? = null,
    override val invisible: Boolean? = null,
    override val label: String? = null,
    override val maxWidth: Long? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pb: Long? = null,
    override val permissionMatrix: DefnDtoPermissionMatrix? = null,
    override val pl: Long? = null,
    override val pr: Long? = null,
    override val pt: Long? = null,
    override val readOnly: Boolean? = null,
    override val type: EnumDefnCompType
) : DefnComp

object DefnCompSerializer : JsonContentPolymorphicSerializer<DefnCompSeal>(
    DefnCompSeal::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DefnCompSeal> {
        val Type = element.jsonObject["Type"]?.jsonPrimitive?.content
        return when (Type) {
            EnumStudioCompType.bool.value -> DefnFieldSwitchData.serializer()
            EnumStudioCompType.date.value -> DefnCompSeal.serializer()
            EnumStudioCompType.decimal.value -> DefnCompSeal.serializer()
            EnumStudioCompType.logDecimal.value -> DefnCompSeal.serializer()
            EnumStudioCompType.image.value -> DefnCompSeal.serializer()
            EnumStudioCompType.label.value -> DefnCompSeal.serializer()
            EnumStudioCompType.number.value -> DefnFieldNumberData.serializer()
            EnumStudioCompType.logNumber.value -> DefnCompSeal.serializer()
            EnumStudioCompType.paragraph.value -> DefnCompSeal.serializer()
            EnumStudioCompType.text.value -> DefnFieldTextData.serializer()
            EnumStudioCompType.chipSet.value -> DefnCompSeal.serializer()
            EnumStudioCompType.chipSetDate.value -> DefnCompSeal.serializer()
            EnumStudioCompType.chipSetDateTime.value -> DefnCompSeal.serializer()
            EnumStudioCompType.chipSetDay.value -> DefnCompSeal.serializer()
            EnumStudioCompType.chipSetDeviceSize.value -> DefnCompSeal.serializer()
            EnumStudioCompType.chipSetDeviceType.value -> DefnCompSeal.serializer()
            EnumStudioCompType.chipSetTime.value -> DefnCompSeal.serializer()
            EnumStudioCompType.currency.value -> DefnCompSeal.serializer()
            EnumStudioCompType.icon.value -> DefnCompSeal.serializer()
            EnumStudioCompType.language.value -> DefnCompSeal.serializer()
            EnumStudioCompType.timeZone.value -> DefnCompSeal.serializer()
            EnumStudioCompType.pinShape.value -> DefnCompSeal.serializer()
            EnumStudioCompType.lineStroke.value -> DefnCompSeal.serializer()
            EnumStudioCompType.paymentStatus.value -> DefnCompSeal.serializer()
            EnumStudioCompType.month.value -> DefnCompSeal.serializer()
            EnumStudioCompType.quarter.value -> DefnCompSeal.serializer()
            EnumStudioCompType.textSize.value -> DefnCompSeal.serializer()
            EnumStudioCompType.messageKind.value -> DefnCompSeal.serializer()
            EnumStudioCompType.pickRole.value -> DefnCompSeal.serializer()
            EnumStudioCompType.pickText.value -> DefnCompSeal.serializer()
            EnumStudioCompType.pickTree.value -> DefnCompSeal.serializer()
            EnumStudioCompType.pickUser.value -> DefnCompSeal.serializer()
            EnumStudioCompType.pickGridRow.value -> DefnCompSeal.serializer()
            EnumStudioCompType.pickReportRow.value -> DefnCompSeal.serializer()
            EnumStudioCompType.setOfRole.value -> DefnCompSeal.serializer()
            EnumStudioCompType.setOfUser.value -> DefnCompSeal.serializer()
            EnumStudioCompType.setOfText.value -> DefnCompSeal.serializer()
            EnumStudioCompType.color.value -> DefnCompSeal.serializer()
            EnumStudioCompType.hyperlink.value -> DefnCompSeal.serializer()
            EnumStudioCompType.audio.value -> DefnCompSeal.serializer()
            EnumStudioCompType.camera.value -> DefnCompSeal.serializer()
            EnumStudioCompType.counter.value -> DefnCompSeal.serializer()
            EnumStudioCompType.logCounter.value -> DefnCompSeal.serializer()
            EnumStudioCompType.dateRange.value -> DefnCompSeal.serializer()
            EnumStudioCompType.dateTime.value -> DefnCompSeal.serializer()
            EnumStudioCompType.dateTimeRange.value -> DefnCompSeal.serializer()
            EnumStudioCompType.duration.value -> DefnCompSeal.serializer()
            EnumStudioCompType.email.value -> DefnCompSeal.serializer()
            EnumStudioCompType.handle.value -> DefnCompSeal.serializer()
            EnumStudioCompType.location.value -> DefnCompSeal.serializer()
            EnumStudioCompType.mobileNumber.value -> DefnCompSeal.serializer()
            EnumStudioCompType.rating.value -> DefnCompSeal.serializer()
            EnumStudioCompType.signature.value -> DefnCompSeal.serializer()
            EnumStudioCompType.slider.value -> DefnCompSeal.serializer()
            EnumStudioCompType.time.value -> DefnCompSeal.serializer()
            EnumStudioCompType.video.value -> DefnCompSeal.serializer()
            EnumStudioCompType.voice.value -> DefnCompSeal.serializer()
            EnumStudioCompType.geoPoint.value -> DefnCompSeal.serializer()
            EnumStudioCompType.rowId.value -> DefnCompSeal.serializer()
            EnumStudioCompType.symbol.value -> DefnCompSeal.serializer()
            EnumStudioCompType.schedulerId.value -> DefnCompSeal.serializer()
            EnumStudioCompType.spreadsheetId.value -> DefnCompSeal.serializer()
            EnumStudioCompType.button.value -> DefnCompSeal.serializer()
            EnumStudioCompType.divider.value -> DefnCompSeal.serializer()
            EnumStudioCompType.document.value -> DefnCompSeal.serializer()
            EnumStudioCompType.error.value -> DefnCompSeal.serializer()
            EnumStudioCompType.html.value -> DefnCompSeal.serializer()
            EnumStudioCompType.identifier.value -> DefnCompSeal.serializer()
            EnumStudioCompType.info.value -> DefnCompSeal.serializer()
            EnumStudioCompType.propertyMap.value -> DefnCompSeal.serializer()
            EnumStudioCompType.scanCode.value -> DefnCompSeal.serializer()
            EnumStudioCompType.setOfDocument.value -> DefnCompSeal.serializer()
            EnumStudioCompType.showCode.value -> DefnCompSeal.serializer()
            EnumStudioCompType.userId.value -> DefnCompSeal.serializer()
            EnumStudioCompType.dynamic.value -> DefnCompSeal.serializer()
            EnumStudioCompType.hyperlinkRow.value -> DefnCompSeal.serializer()
            EnumStudioCompType.password.value -> DefnCompSeal.serializer()
            EnumStudioCompType.ref.value -> DefnCompSeal.serializer()
            EnumStudioCompType.refSet.value -> DefnCompSeal.serializer()
            EnumStudioCompType.refUser.value -> DefnCompSeal.serializer()
            EnumStudioCompType.refReport.value -> DefnCompSeal.serializer()
            EnumStudioCompType.refTarget.value -> DefnCompSeal.serializer()
            EnumStudioCompType.refContact.value -> DefnCompSeal.serializer()
            EnumStudioCompType.grid.value -> DefnCompSeal.serializer()
            EnumStudioCompType.section.value -> DefnCompSeal.serializer()
            EnumStudioCompType.spreadsheetRef.value -> DefnCompSeal.serializer()
            else -> DefnCompSeal.serializer()
        }
    }
}
