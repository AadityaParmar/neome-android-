// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.dto.EnvValidationError
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.main.sig.SigMessage

interface SigMessageBulk : Sig
{
  val errorMap: Map<Number, EnvValidationError>
  val messageMap: Map<Number, SigMessage>
}