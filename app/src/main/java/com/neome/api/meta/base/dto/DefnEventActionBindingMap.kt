// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnEventActionBinding
import com.neome.api.meta.base.Types.MetaIdFormEventActionBinding

interface DefnEventActionBindingMap
{
  val keys: List<MetaIdFormEventActionBinding>
  val map: Map<MetaIdFormEventActionBinding, DefnEventActionBinding>
}