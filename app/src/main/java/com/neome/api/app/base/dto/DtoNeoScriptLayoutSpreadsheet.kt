// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoNeoScriptLayoutSpreadsheet : DtoNeoScript
{
  val spreadsheetId: MetaIdSpreadsheet?
  val spreadsheetLayoutId: MetaIdLayoutGrid?
}