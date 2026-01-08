// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoDebuggerLogEntry
import com.neome.api.nucleus.base.sig.Sig

interface SigDebuggerLogsGet : Sig
{
  val logList: Array<DtoDebuggerLogEntry>?
}