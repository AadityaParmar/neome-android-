// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class FieldDtoTreeNode extends StudioBase
{
  public String[] keys;

  public Map<String, FieldDtoTreeNode> map;

  public String metaId;

  @Nullable
  public String value;
}
