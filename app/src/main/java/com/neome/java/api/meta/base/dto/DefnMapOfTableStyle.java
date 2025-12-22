// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdTableStyle;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnMapOfTableStyle
{
  @Nullable
  public MetaIdTableStyle[] keys;

  public Map<MetaIdTableStyle, DefnDtoTableStyle> map;
}
