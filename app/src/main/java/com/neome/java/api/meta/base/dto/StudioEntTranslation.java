// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnKindTranslation;
import com.neome.java.api.meta.base.Types.LanguageKey;
import com.neome.java.api.meta.base.Types.MetaIdTranslation;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

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
