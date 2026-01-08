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
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntSpreadsheetRefTokenMap

interface StudioEntPrivateState : StudioBase
{
  val cliSeedId: Long?
  val eventSchedulerTaskIdMapping: Map<Key, SchedulerTaskId>?
  val groupIdMappingMap: Map<MetaIdGroup, GroupId>?
  val refTokenSet: Array<String>?
  val schedulerTaskIdMappingMap: Map<MetaIdAutomation, SchedulerTaskId>?
  val sheetIdMappingMap: Map<MetaIdSpreadsheet, SheetId>?
  val spreadsheetRefTokenMap: Map<MetaIdSpreadsheet, StudioEntSpreadsheetRefTokenMap>?
}