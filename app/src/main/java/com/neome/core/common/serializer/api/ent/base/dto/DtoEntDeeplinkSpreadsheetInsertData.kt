package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntDeeplink
import com.neome.api.ent.base.dto.DtoEntDeeplinkSpreadsheetInsert
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindDeeplink
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleSelectionData
import com.neome.core.common.serializer.sysId.MetaIdDeeplinkSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntDeeplinkSpreadsheetInsertData(
    @Serializable(with = MetaIdDeeplinkSer::class) override val deepLinkId: Types.MetaIdDeeplink,
    override val description: String? = null,
    override val kind: EnumDefnKindDeeplink,
    override val modules: StudioModuleSelectionData? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formEditorLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val mobileFormEditorLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null,
    @Serializable(with = MetaIdDeeplinkSer::class) override val successDeeplinkId: Types.MetaIdDeeplink? = null
) : DtoEntDeeplinkSpreadsheetInsert
