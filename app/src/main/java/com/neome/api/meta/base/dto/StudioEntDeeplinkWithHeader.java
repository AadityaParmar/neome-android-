// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntDeeplinkWithHeader extends StudioEntDeeplink
{
  @Nullable
  public MetaIdVar[] hyperlinkVarIdSet;

  @Nullable
  public Boolean showEnterprise;

  @Nullable
  public Boolean showHeader;

  @Nullable
  public Boolean transparentHeader;
}
