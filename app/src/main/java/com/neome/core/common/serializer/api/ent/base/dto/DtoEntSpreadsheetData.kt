package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntSpreadsheet
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutGridMapData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetRefSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntSpreadsheetData(
    override val canClear: Boolean,
    override val canExpire: Boolean,
    override val forwardRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val hasPartition: Boolean,
    override val insertRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val label: String? = null,
    override val layoutMap: DefnLayoutGridMapData? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val removeRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val sheetIdHash: String,
    @Serializable(with = MetaIdFormSer::class) override val spreadsheetFormId: Types.MetaIdForm,
    override val spreadsheetRefTokenMap: Map<@Serializable(with = MetaIdSpreadsheetRefSer::class) Types.MetaIdSpreadsheetRef, String>? = null,
    override val supportOffline: Boolean,
    override val updateRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null
) : DtoEntSpreadsheet
