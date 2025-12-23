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
import java.util.Map

open class StudioEntPrivateState : StudioBase() {
    var cliSeedId: Number? = null
    var eventSchedulerTaskIdMapping: Map<Key, SchedulerTaskId>? = null
    var groupIdMappingMap: Map<MetaIdGroup, GroupId>? = null
    var refTokenSet: Array<String>? = null
    var schedulerTaskIdMappingMap: Map<MetaIdAutomation, SchedulerTaskId>? = null
    var sheetIdMappingMap: Map<MetaIdSpreadsheet, SheetId>? = null
    var spreadsheetRefTokenMap: Map<MetaIdSpreadsheet, StudioEntSpreadsheetRefTokenMap>? = null
}
