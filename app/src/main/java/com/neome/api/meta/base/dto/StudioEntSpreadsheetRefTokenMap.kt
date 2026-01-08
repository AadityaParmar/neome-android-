// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.dto.StudioBase

interface StudioEntSpreadsheetRefTokenMap : StudioBase
{
  val refTokenMap: Map<MetaIdSpreadsheetRef, String>?
}