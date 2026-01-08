// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoChatMessageListMap
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.dto.FormValue
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import java.util.Set
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.home.drawer.sig.SigUserAvatar

interface SigDrawerSearch : Sig
{
  val auditRecordMap: Map<EntId, Map<MetaIdSpreadsheet, Array<FormValue>>>?
  val groupAvatarList: Array<SigGroupAvatar>?
  val latestMessageMap: Map<EntId, DtoChatMessageListMap>?
  val spreadsheetRowMap: Map<EntId, Map<MetaIdSpreadsheet, Array<RowId>>>?
  val totalMessageCount: Long?
  val userAvatarList: Array<SigUserAvatar>?
}