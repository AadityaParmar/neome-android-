// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEmptyFieldVariant
import com.neome.api.meta.base.Types.EnumDefnInsertVariant
import com.neome.api.meta.base.Types.EnumDefnRemoveVariant
import com.neome.api.meta.base.Types.EnumDefnUpdateVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMapBase

interface StudioDtoMappingFieldMap : StudioDtoMappingFieldMapBase
{
  val emptyFieldVariant: EnumDefnEmptyFieldVariant?
  val fromKey: MetaIdField?
  val insertVariant: EnumDefnInsertVariant?
  val removeVariant: EnumDefnRemoveVariant?
  val toKey: MetaIdField?
  val updateVariant: EnumDefnUpdateVariant?
}