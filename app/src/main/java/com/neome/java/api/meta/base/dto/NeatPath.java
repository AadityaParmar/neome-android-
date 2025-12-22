// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumNeatPathCaption;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class NeatPath
{
  @Nullable
  public EnumNeatPathCaption caption;

  @Nullable
  public String[] primary;

  @Nullable
  public String secondary;
}
