package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.ent.base.dto.DtoEntActionReport
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionSeal
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
sealed interface DtoEntActionReportSeal : DtoEntActionReport


@Serializable
data class DtoEntActionReportData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val description: String? = null,
    override val icon: String? = null,
    override val increaseAsideWidth: Boolean? = null,
    override val kind: EnumDefnKindAction,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val tooltip: String? = null,
    override val defaultValueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>? = null,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val outputFormContentLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm,
    @Serializable(with = MetaIdLayoutFormSer::class) override val outputFormTemplateLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport,
    override val reportKind: EnumDefnKindReport,
    override val sendMessageToInbox: Boolean? = null
) : DtoEntActionSeal, DtoEntActionReport
