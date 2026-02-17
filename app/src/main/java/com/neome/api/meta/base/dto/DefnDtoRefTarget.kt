// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DefnDtoRefTarget
{
  val displayFieldIdSet: List<MetaIdField>
  val metaId: MetaIdSpreadsheet
  val overrideLayoutSpreadsheet: DefnLayoutGrid
}