// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdTranslation;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioEntTranslation;

@SuppressWarnings("unused")
public class StudioEntTranslationMap extends StudioBase
{
  public MetaIdTranslation[] keys;

  public Map<MetaIdTranslation, StudioEntTranslation> map;

  @Nullable
  public Boolean usePublicLibrary;
}
