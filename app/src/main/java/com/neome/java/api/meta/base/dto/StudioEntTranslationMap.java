// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdTranslation;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntTranslationMap extends StudioBase
{
  public MetaIdTranslation[] keys;

  public Map<MetaIdTranslation, StudioEntTranslation> map;

  @Nullable
  public Boolean usePublicLibrary;
}
