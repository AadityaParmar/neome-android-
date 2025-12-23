// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntSpreadsheet

open class StudioEntSpreadsheetMap : StudioBase()
{
  lateinit var keys: Array<MetaIdSpreadsheet>
  lateinit var map: Map<MetaIdSpreadsheet, StudioEntSpreadsheet>
}