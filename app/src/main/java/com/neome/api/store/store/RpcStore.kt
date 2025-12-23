// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.studio.studioMain.msg.MsgAdminId
import com.neome.api.studio.studioMain.msg.MsgAdminInvite
import com.neome.api.store.store.msg.MsgStoreAdminAdd
import com.neome.api.store.studioMain.msg.MsgStoreAdminUpdate
import com.neome.api.store.store.msg.MsgStoreFilters
import com.neome.api.store.store.msg.MsgStoreItemCreate
import com.neome.api.store.store.msg.MsgStoreItemId
import com.neome.api.store.store.msg.MsgStoreItemProvision
import com.neome.api.store.store.msg.MsgStoreSearch
import com.neome.api.store.store.msg.MsgStudioEntMerge
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.studio.studioMain.sig.SigAdminEditLockDetail
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.store.store.sig.SigStoreAdminCaller
import com.neome.api.store.store.sig.SigStoreAdminList
import com.neome.api.store.store.sig.SigStoreFilterList
import com.neome.api.store.store.sig.SigStoreItem
import com.neome.api.store.store.sig.SigStoreItemAvatar
import com.neome.api.store.store.sig.SigStoreItemListGet
import com.neome.api.store.store.sig.SigStoreSearch
import com.neome.api.store.store.sig.SigStudioEntMerge
import com.neome.api.meta.base.Types.StoreItemId

class RpcStore
{
  companion object
  {
    val SN: ServiceName = ServiceName.store

      fun storeAdminAdd(storeItemId: StoreItemId, msg: MsgStoreAdminAdd, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, storeItemId, SN, "storeAdminAdd")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun storeAdminCallerGet(storeItemId: StoreItemId, sigAcceptor: ISigAcceptor<SigStoreAdminCaller>)
          {
            CallFactory.rpc.create(SigStoreAdminCaller::class.java, storeItemId, SN, "storeAdminCallerGet")
              .sendBearerToken()
              .get(null, sigAcceptor)
          }

      fun storeAdminEditLockDetailGet(storeItemId: StoreItemId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigAdminEditLockDetail>)
          {
            CallFactory.rpc.create(SigAdminEditLockDetail::class.java, storeItemId, SN, "storeAdminEditLockDetailGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun storeAdminEditLockTransfer(storeItemId: StoreItemId, msg: MsgAdminId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, storeItemId, SN, "storeAdminEditLockTransfer")
              .sendBearerToken()
              .put(msg, sigAcceptor)
          }

      fun storeAdminExit(storeItemId: StoreItemId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, storeItemId, SN, "storeAdminExit")
              .sendBearerToken()
              .delete(null, sigAcceptor)
          }

      fun storeAdminInvite(storeItemId: StoreItemId, msg: MsgAdminInvite, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, storeItemId, SN, "storeAdminInvite")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun storeAdminListGet(msg: MsgStoreItemId, sigAcceptor: ISigAcceptor<SigStoreAdminList>)
          {
            CallFactory.rpc.create(SigStoreAdminList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeAdminListGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun storeAdminRemove(storeItemId: StoreItemId, msg: MsgAdminId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, storeItemId, SN, "storeAdminRemove")
              .sendBearerToken()
              .delete(msg, sigAcceptor)
          }

      fun storeAdminUpdate(storeItemId: StoreItemId, msg: MsgStoreAdminUpdate, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, storeItemId, SN, "storeAdminUpdate")
              .sendBearerToken()
              .put(msg, sigAcceptor)
          }

      fun storeFilterListGet(msg: MsgVersion, sigAcceptor: ISigAcceptor<SigStoreFilterList>)
          {
            CallFactory.rpc.create(SigStoreFilterList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeFilterListGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun storeItemAvatarGet(msg: MsgStoreItemId, sigAcceptor: ISigAcceptor<SigStoreItemAvatar>)
          {
            CallFactory.rpc.create(SigStoreItemAvatar::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeItemAvatarGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun storeItemCreate(artifactId: ArtifactId, msg: MsgStoreItemCreate, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, artifactId, SN, "storeItemCreate")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun storeItemEntMerge(msg: MsgStudioEntMerge, sigAcceptor: ISigAcceptor<SigStudioEntMerge>)
          {
            CallFactory.rpc.create(SigStudioEntMerge::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeItemEntMerge")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun storeItemGet(msg: MsgStoreItemId, sigAcceptor: ISigAcceptor<SigStoreItem>)
          {
            CallFactory.rpc.create(SigStoreItem::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeItemGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun storeItemListGet(msg: MsgStoreFilters, sigAcceptor: ISigAcceptor<SigStoreItemListGet>)
          {
            CallFactory.rpc.create(SigStoreItemListGet::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeItemListGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun storeItemProvision(msg: MsgStoreItemProvision, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeItemProvision")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun storeItemRemove(storeItemId: StoreItemId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, storeItemId, SN, "storeItemRemove")
              .sendBearerToken()
              .delete(null, sigAcceptor)
          }

      fun storeSearch(msg: MsgStoreSearch, sigAcceptor: ISigAcceptor<SigStoreSearch>)
          {
            CallFactory.rpc.create(SigStoreSearch::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "storeSearch")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }
  }
}