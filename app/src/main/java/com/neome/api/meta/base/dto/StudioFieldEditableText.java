// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldEditableText extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public StudioValueVarIdText defaultVarId;
}
