// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntActionPermission
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAction

open class DtoEntGroupActionPermissionMap
{
  var defaultActionId: MetaIdAction? = null
  var defaultPinnedActionIdSet: Array<MetaIdAction>? = null
  var hideActionMenu: Boolean? = null
  lateinit var keys: Array<MetaIdAction>
  lateinit var map: Map<MetaIdAction, DtoEntActionPermission>
  var mobilePinnedActionIdSet: Array<MetaIdAction>? = null
}