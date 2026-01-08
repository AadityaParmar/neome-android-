// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioPluginBundleBase
import com.neome.api.meta.base.dto.StudioPluginDraft

interface StudioPluginBundle : StudioPluginBundleBase
{
  val draft: StudioPluginDraft?
}