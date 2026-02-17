// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.nucleus.base.sig.Sig

interface SigPluginApiOutput : Sig
{
  val formValueRaw: FormValueRaw
  val outputFieldIdSet: Set<MetaIdField>?
}