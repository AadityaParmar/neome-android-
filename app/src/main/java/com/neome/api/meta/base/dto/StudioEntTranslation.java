// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EnumDefnKindTranslation;
import com.neome.api.meta.base.Types.LanguageKey;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdTranslation;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.Symbol;

@SuppressWarnings("unused")
public class StudioEntTranslation extends StudioBase
{
  @Nullable
  public Boolean doNotShareWithPublicLibrary;

  public MetaIdTranslation metaId;

  @Nullable
  public Symbol name;

  public String phrase;

  @Nullable
  public Map<LanguageKey, String> translationMap;

  public EnumDefnKindTranslation type;
}
