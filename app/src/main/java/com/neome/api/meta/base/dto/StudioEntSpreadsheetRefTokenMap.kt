// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import java.util.Map

open class StudioEntSpreadsheetRefTokenMap : StudioBase() {
    var refTokenMap: Map<MetaIdSpreadsheetRef, String>? = null
}
