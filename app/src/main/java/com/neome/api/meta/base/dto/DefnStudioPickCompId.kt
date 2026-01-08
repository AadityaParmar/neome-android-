// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdForm

interface DefnStudioPickCompId : DefnFieldEditable
{
  val excludeCompositeIdSet: Array<MetaIdComposite>?
  val filterCompTypeSet: Array<EnumDefnCompType>?
  val formId: MetaIdForm
}