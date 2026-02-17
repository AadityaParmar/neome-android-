package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.ent.base.dto.DtoEntActionRowInsert
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.EnumDefnKindFormRenderingMode
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionSeal
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
sealed interface DtoEntActionRowInsertSeal : DtoEntActionRowInsert


@Serializable
data class DtoEntActionRowInsertData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val description: String? = null,
    override val icon: String? = null,
    override val increaseAsideWidth: Boolean? = null,
    override val kind: EnumDefnKindAction,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val tooltip: String? = null,
    override val defaultValueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formEditorLayoutId: Types.MetaIdLayoutForm? = null,
    override val formRenderingModeKind: EnumDefnKindFormRenderingMode? = null,
    override val hasPartitions: Boolean? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val mobileFormEditorLayoutId: Types.MetaIdLayoutForm? = null,
    override val sendMessageToInbox: Boolean? = null,
    @Serializable(with = MetaIdFormSer::class) override val spreadsheetFormId: Types.MetaIdForm,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet
) : DtoEntActionSeal, DtoEntActionRowInsert
