// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem
import java.util.Set
import com.neome.api.nucleus.base.sig.Sig

open class SigStoreAdminCaller : Sig()
{
  lateinit var adminId: AdminId
  var doNotEditOptionSet: Array<EnumDefnAdminDoNotOptionStoreItem>? = null
  var doNotShowOptionSet: Array<EnumDefnAdminDoNotOptionStoreItem>? = null
  var hasLock: Boolean? = null
  lateinit var nickName: String
}