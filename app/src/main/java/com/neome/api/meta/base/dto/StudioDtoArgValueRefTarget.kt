// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.dto.StudioDtoArgValueField

open class StudioDtoArgValueRefTarget : StudioDtoArgValueField()
{
  lateinit var spreadsheetId: MetaIdSpreadsheet
  lateinit var spreadsheetRefId: MetaIdSpreadsheetRef
}