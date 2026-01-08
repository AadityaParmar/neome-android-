// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.AnyEmailId
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldEmail : StudioFieldEditable
{
  val autoPickSelf: Boolean?
  val defaultFieldId: MetaIdField?
  val defaultValue: AnyEmailId?
  val defaultVarId: MetaIdVar?
  val invalidDomainVarId: MetaIdVar?
  val validDomainVarId: MetaIdVar?
}