// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioEntDeeplinkWithHeader

interface StudioEntDeeplinkSpreadsheetEditor : StudioEntDeeplinkWithHeader
{
  val layoutSpreadsheetId: MetaIdLayoutGrid?
  val spreadsheetId: MetaIdSpreadsheet?
}