// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import java.util.Map
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.RowId

interface MsgSpreadsheetBulkRowCommentCountGet : MsgVersion
{
  val rowIdCommentVersionMap: Map<RowId, String>
}