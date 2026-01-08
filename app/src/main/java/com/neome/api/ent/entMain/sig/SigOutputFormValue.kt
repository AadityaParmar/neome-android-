// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.ent.entMain.sig.SigFormValue

interface SigOutputFormValue : SigFormValue
{
  val outputFieldIdSet: Array<MetaIdField>?
}