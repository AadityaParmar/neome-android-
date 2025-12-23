// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.store.base.dto.DtoStoreAdmin
import com.neome.api.nucleus.base.sig.Sig

open class SigStoreAdminList : Sig()
{
  lateinit var storeAdminList: Array<DtoStoreAdmin>
}