// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.ent.base.Types.EnumLogType
import com.neome.api.nucleus.base.dto.EnvError
import com.neome.api.meta.base.dto.FormValueRaw

interface DtoDebuggerLogEntry
{
  val caller: String?
  val dateTime: String?
  val envError: EnvError?
  val inputForm: DefnForm?
  val inputFormLogTree: DtoLogTree?
  val inputFormValue: FormValueRaw?
  val logType: EnumLogType?
  val name: String?
  val outputForm: DefnForm?
  val outputFormLogTree: DtoLogTree?
  val outputFormValue: FormValueRaw?
  val summary: JsonElement?
}