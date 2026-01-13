package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionExecuteWorkflowData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionReportData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionRowInsertData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionRowUpdateData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionSeal
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionSpreadsheetEditorData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionSpreadsheetHistoryData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionUIUpdateData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionUserData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive


@Serializable(with = DtoEntActionSerializer::class)
sealed interface DtoEntActionSeal : DtoEntAction


@Serializable
data class DtoEntActionData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val description: String? = null,
    override val icon: String? = null,
    override val increaseAsideWidth: Boolean? = null,
    override val kind: EnumDefnKindAction,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val tooltip: String? = null
) : DtoEntActionSeal, DtoEntAction

object DtoEntActionSerializer : JsonContentPolymorphicSerializer<DtoEntActionSeal>(
    DtoEntActionSeal::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DtoEntActionSeal> {
        val kind = element.jsonObject["kind"]?.jsonPrimitive?.content
        return when (kind) {
            EnumDefnKindAction.executeCallable.value -> DtoEntActionExecuteWorkflowData.serializer()
            EnumDefnKindAction.report.value -> DtoEntActionReportData.serializer()
            EnumDefnKindAction.rowInsert.value -> DtoEntActionRowInsertData.serializer()
            EnumDefnKindAction.rowUpdate.value -> DtoEntActionRowUpdateData.serializer()
            EnumDefnKindAction.spreadsheetEditor.value -> DtoEntActionSpreadsheetEditorData.serializer()
            EnumDefnKindAction.spreadsheetHistory.value -> DtoEntActionSpreadsheetHistoryData.serializer()
            EnumDefnKindAction.uiUpdate.value -> DtoEntActionUIUpdateData.serializer()
            EnumDefnKindAction.user.value -> DtoEntActionUserData.serializer()
            else -> DtoEntActionData.serializer()
        }
    }
}
