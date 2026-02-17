// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntSpreadsheet

interface StudioEntSpreadsheetMap : StudioBase
{
  val keys: List<MetaIdSpreadsheet>
  val map: Map<MetaIdSpreadsheet, StudioEntSpreadsheet>
}