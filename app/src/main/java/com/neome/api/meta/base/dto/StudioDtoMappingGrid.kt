// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEmptyFieldVariant
import com.neome.api.meta.base.Types.EnumDefnInsertVariant
import com.neome.api.meta.base.Types.EnumDefnRemoveVariant
import com.neome.api.meta.base.Types.EnumDefnUpdateVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdMapping
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMapBase
import com.neome.api.meta.base.Symbol

open class StudioDtoMappingGrid : StudioBase()
{
  var emptyFieldVariant: EnumDefnEmptyFieldVariant? = null
  var fieldMappingMap: StudioDtoMappingFieldMapBase? = null
  var fromGridId: MetaIdGrid? = null
  var fromGridKey: MetaIdField? = null
  var insertVariant: EnumDefnInsertVariant? = null
  lateinit var metaId: MetaIdMapping
  var name: Symbol? = null
  var removeVariant: EnumDefnRemoveVariant? = null
  var toGridId: MetaIdGrid? = null
  var toGridKey: MetaIdField? = null
  var updateVariant: EnumDefnUpdateVariant? = null
}