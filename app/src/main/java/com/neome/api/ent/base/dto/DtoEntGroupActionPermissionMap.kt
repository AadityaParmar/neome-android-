// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntActionPermission
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAction

interface DtoEntGroupActionPermissionMap
{
  val defaultActionId: MetaIdAction?
  val defaultPinnedActionIdSet: Array<MetaIdAction>?
  val hideActionMenu: Boolean?
  val keys: Array<MetaIdAction>
  val map: Map<MetaIdAction, DtoEntActionPermission>
  val mobilePinnedActionIdSet: Array<MetaIdAction>?
}