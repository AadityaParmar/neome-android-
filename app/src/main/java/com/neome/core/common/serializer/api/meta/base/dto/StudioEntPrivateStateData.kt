package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPrivateState
import com.neome.api.meta.base.dto.StudioEntSpreadsheetRefTokenMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntSpreadsheetRefTokenMapData
import com.neome.core.common.serializer.sysId.GroupIdSer
import com.neome.core.common.serializer.sysId.KeySer
import com.neome.core.common.serializer.sysId.MetaIdAutomationSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SchedulerTaskIdSer
import com.neome.core.common.serializer.sysId.SheetIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPrivateStateData(
    override val cliSeedId: Long? = null,
    override val eventSchedulerTaskIdMapping: Map<@Serializable(with = KeySer::class) Types.Key, @Serializable(with = SchedulerTaskIdSer::class) Types.SchedulerTaskId>? = null,
    override val groupIdMappingMap: Map<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup, @Serializable(with = GroupIdSer::class) Types.GroupId>? = null,
    override val refTokenSet: List<String>? = null,
    override val schedulerTaskIdMappingMap: Map<@Serializable(with = MetaIdAutomationSer::class) Types.MetaIdAutomation, @Serializable(with = SchedulerTaskIdSer::class) Types.SchedulerTaskId>? = null,
    override val sheetIdMappingMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, @Serializable(with = SheetIdSer::class) Types.SheetId>? = null,
    override val spreadsheetRefTokenMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, StudioEntSpreadsheetRefTokenMapData>? = null
) : StudioEntPrivateState
