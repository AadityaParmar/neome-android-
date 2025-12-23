// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.dto.StudioBase

open class StudioEntSpreadsheetRefTokenMap : StudioBase()
{
  var refTokenMap: Map<MetaIdSpreadsheetRef, String>? = null
}