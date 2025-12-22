// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.Key
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.SchedulerTaskId
import com.neome.api.meta.base.Types.SheetId

class StudioEntPrivateState : StudioBase() {
    var cliSeedId: number? = null
    var eventSchedulerTaskIdMapping: Record<Key, SchedulerTaskId>? = null
    var groupIdMappingMap: Record<MetaIdGroup, GroupId>? = null
    var refTokenSet: string[]? = null
    var schedulerTaskIdMappingMap: Record<MetaIdAutomation, SchedulerTaskId>? = null
    var sheetIdMappingMap: Record<MetaIdSpreadsheet, SheetId>? = null
    var spreadsheetRefTokenMap: Record<MetaIdSpreadsheet, StudioEntSpreadsheetRefTokenMap>? = null
}
