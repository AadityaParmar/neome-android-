// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.meta.base.Types.HandleKey
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

interface SigAgentEntUserImport : Sig
{
  val errorMap: Map<HandleKey, EnvValidationError>
}