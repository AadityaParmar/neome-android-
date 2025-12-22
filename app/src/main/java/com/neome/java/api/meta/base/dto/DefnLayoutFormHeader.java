// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdHyperlink;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnLayoutFormHeader
{
  @Nullable
  public DefnDtoColor backgroundColor;

  @Nullable
  public DefnDtoColor backgroundColorVar;

  @Nullable
  public MetaIdLayoutForm formLayoutId;

  @Nullable
  public FieldDtoImage headerImage;

  @Nullable
  public Long headerImageHeight;

  @Nullable
  public FieldDtoImage headerImageVar;

  @Nullable
  public Map<MetaIdHyperlink, DefnDtoHyperLink> hyperLinkMap;

  @Nullable
  public MetaIdHyperlink[] hyperlinkKeys;

  @Nullable
  public Boolean showEnterprise;

  @Nullable
  public Boolean showSeparator;

  @Nullable
  public DefnDtoColor textColor;

  @Nullable
  public DefnDtoColor textColorVar;
}
