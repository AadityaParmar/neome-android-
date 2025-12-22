// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnEmptyFieldVariant;
import com.neome.java.api.meta.base.Types.EnumDefnInsertVariant;
import com.neome.java.api.meta.base.Types.EnumDefnRemoveVariant;
import com.neome.java.api.meta.base.Types.EnumDefnUpdateVariant;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoMappingFieldMap extends StudioDtoMappingFieldMapBase
{
  @Nullable
  public EnumDefnEmptyFieldVariant emptyFieldVariant;

  @Nullable
  public MetaIdField fromKey;

  @Nullable
  public EnumDefnInsertVariant insertVariant;

  @Nullable
  public EnumDefnRemoveVariant removeVariant;

  @Nullable
  public MetaIdField toKey;

  @Nullable
  public EnumDefnUpdateVariant updateVariant;
}
