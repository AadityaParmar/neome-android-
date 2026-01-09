// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.task.sig

import kotlinx.serialization.json.JsonElement
import com.neome.api.core.base.Types.EnumTaskStatus
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig

interface SigTask : Sig
{
  val error: EnvValidationError?
  val progress: Long?
  val result: JsonElement?
  val status: EnumTaskStatus
}