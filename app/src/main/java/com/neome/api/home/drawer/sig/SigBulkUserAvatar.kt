// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.drawer.sig.SigUserAvatar

interface SigBulkUserAvatar : Sig
{
  val errorMap: Map<EntUserId, EnvValidationError>?
  val resultMap: Map<EntUserId, SigUserAvatar>?
}