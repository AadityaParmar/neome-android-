// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.LanguageKey;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldLanguage extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public LanguageKey defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;
}
