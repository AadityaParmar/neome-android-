// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.Types.EnumDefnEjectionPolicy
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DefnFieldRefSet : DefnFieldEditable
{
  val allowDuplicateValues: Boolean?
  val displayFieldId: MetaIdField?
  val ejectionPolicy: EnumDefnEjectionPolicy?
  val layoutSpreadsheet: DefnLayoutGrid?
  val maxSize: Long?
  val spreadsheetId: MetaIdSpreadsheet
}