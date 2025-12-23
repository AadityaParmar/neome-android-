// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.meta.base.Types.EnumStoreLabel
import java.util.Set
import com.neome.api.nucleus.base.sig.SigVersion

open class SigStoreFilterList : SigVersion()
{
  lateinit var storeFilterSet: Array<EnumStoreLabel>
}