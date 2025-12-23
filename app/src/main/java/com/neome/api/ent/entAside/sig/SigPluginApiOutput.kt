// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdField
import java.util.Set
import com.neome.api.nucleus.base.sig.Sig

open class SigPluginApiOutput : Sig()
{
  lateinit var formValueRaw: FormValueRaw
  var outputFieldIdSet: Array<MetaIdField>? = null
}