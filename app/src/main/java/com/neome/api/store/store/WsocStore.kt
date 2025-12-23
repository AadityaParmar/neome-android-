// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.store.store.msg.MsgStoreItemId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.store.store.sig.SigStoreItemAvatar

class WsocStore
{
  companion object
  {
    val SN: ServiceName = ServiceName.store

      fun storeItemAvatarGet(msg: MsgStoreItemId, sigAcceptor: ISigAcceptor<SigStoreItemAvatar>)
          {
            CallFactory.wsoc.create(SigStoreItemAvatar::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeItemAvatarGet")
              .get(msg, sigAcceptor)
          }
  }
}