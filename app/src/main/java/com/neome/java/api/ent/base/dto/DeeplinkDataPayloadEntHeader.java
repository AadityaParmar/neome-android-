// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.dto.DefnDtoHyperLink;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DeeplinkDataPayloadEntHeader
{
  @Nullable
  public DefnDtoHyperLink[] hyperLinkSet;

  @Nullable
  public Boolean showEnterprise;

  @Nullable
  public Boolean showHeader;

  @Nullable
  public Boolean showSeparator;
}
