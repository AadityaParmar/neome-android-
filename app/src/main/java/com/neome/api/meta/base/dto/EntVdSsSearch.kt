// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioBuildArgBinder

interface EntVdSsSearch : EntVdAutoStepWithOutput
{
  val maxResultCount: Long?
  val searchSpreadsheetIdSet: List<MetaIdSpreadsheet>?
  val searchText: StudioBuildArgBinder?
}