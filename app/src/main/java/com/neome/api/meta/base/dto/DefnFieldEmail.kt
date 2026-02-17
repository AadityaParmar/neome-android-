// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.AnyEmailId
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldEmail : DefnFieldEditable
{
  val autoPickSelf: Boolean?
  val defaultFieldId: MetaIdField?
  val defaultValue: AnyEmailId?
  val defaultVar: AnyEmailId?
  val invalidDomainSetVar: List<String>?
  val validDomainSetVar: List<String>?
}