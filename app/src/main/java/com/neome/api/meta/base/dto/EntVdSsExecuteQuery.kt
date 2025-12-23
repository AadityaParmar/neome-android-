// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioValueCodeNeoQL

open class EntVdSsExecuteQuery : EntVdAutoStepWithOutput()
{
  var neoQL: StudioValueCodeNeoQL? = null
  var outputForm: FormRefKey? = null
  var spreadsheetIdSet: Array<MetaIdSpreadsheet>? = null
}