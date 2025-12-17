// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldHtml extends DefnField
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public DefnDtoParagraph defaultVar;

  @Nullable
  public String placeHolder;

  @Nullable
  public MetaIdField placeHolderFieldId;

  @Nullable
  public DefnDtoParagraph placeHolderVar;

  @Nullable
  public Boolean showCloseButton;
}
