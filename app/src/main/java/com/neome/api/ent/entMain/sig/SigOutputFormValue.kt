// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.MetaIdField
import java.util.Set
import com.neome.api.ent.entMain.sig.SigFormValue

open class SigOutputFormValue : SigFormValue()
{
  var outputFieldIdSet: Array<MetaIdField>? = null
}