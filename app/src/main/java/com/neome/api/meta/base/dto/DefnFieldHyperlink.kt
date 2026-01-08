// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldHyperlink : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultVar: DefnDtoHyperLink?
}