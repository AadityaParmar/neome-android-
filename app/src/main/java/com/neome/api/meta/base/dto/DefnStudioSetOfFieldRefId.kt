// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DefnStudioSetOfFieldRefId : DefnField
{
  val showCompositeName: Boolean?
  val spreadsheetId: MetaIdSpreadsheet
}