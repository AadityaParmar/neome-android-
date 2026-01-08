// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.Types.EnumDefnKindActionUIUpdate
import com.neome.api.meta.base.Types.MetaIdGroup

interface DtoEntActionUIUpdate : DtoEntAction
{
  val groupId: MetaIdGroup?
  val updateKind: EnumDefnKindActionUIUpdate
}