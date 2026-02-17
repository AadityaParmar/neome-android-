// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdAudio

interface FieldValueAudio
{
  val durationMs: Long
  val fileName: String
  val fileSize: Long
  val mediaIdAudio: MediaIdAudio
}