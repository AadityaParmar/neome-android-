// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVideoTimestamp

interface DefnDtoVideoTimestamp
{
  val metaId: MetaIdVideoTimestamp?
  val startTimeMinutes: Long?
  val startTimeSeconds: Long?
  val style: String?
  val title: String?
}