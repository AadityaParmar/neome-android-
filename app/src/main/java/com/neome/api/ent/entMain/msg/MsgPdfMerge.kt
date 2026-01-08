// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MediaId
import com.neome.api.nucleus.base.msg.Msg

interface MsgPdfMerge : Msg
{
  val fileName: String?
  val pdfMediaIdSet: Array<MediaId>
}