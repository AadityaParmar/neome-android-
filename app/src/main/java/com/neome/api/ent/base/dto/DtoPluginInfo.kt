// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAuthMethodInfo
import com.neome.api.meta.base.Types.MetaIdAuthMethod

interface DtoPluginInfo
{
  val authMethodMap: Map<MetaIdAuthMethod, DtoAuthMethodInfo>?
  val name: String?
}