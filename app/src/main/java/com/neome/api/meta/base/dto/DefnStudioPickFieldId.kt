// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm

open class DefnStudioPickFieldId : DefnFieldEditable()
{
  var compositeIdSet: Array<MetaIdComposite>? = null
  var excludeFieldIdSet: Array<MetaIdField>? = null
  var filterFieldTypeSet: Array<EnumDefnCompType>? = null
  lateinit var formId: MetaIdForm
  var includeFieldIdSet: Array<MetaIdField>? = null
  var includeOptionMap: DefnStudioMapOfDtoOption? = null
  var showCompositeName: Boolean? = null
}