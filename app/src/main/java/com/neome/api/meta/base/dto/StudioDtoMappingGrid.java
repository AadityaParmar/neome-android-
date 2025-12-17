// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnEmptyFieldVariant;
import com.neome.api.meta.base.Types.EnumDefnInsertVariant;
import com.neome.api.meta.base.Types.EnumDefnRemoveVariant;
import com.neome.api.meta.base.Types.EnumDefnUpdateVariant;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdMapping;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoMappingGrid extends StudioBase
{
  @Nullable
  public EnumDefnEmptyFieldVariant emptyFieldVariant;

  @Nullable
  public StudioDtoMappingFieldMapBase fieldMappingMap;

  @Nullable
  public MetaIdGrid fromGridId;

  @Nullable
  public MetaIdField fromGridKey;

  @Nullable
  public EnumDefnInsertVariant insertVariant;

  public MetaIdMapping metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public EnumDefnRemoveVariant removeVariant;

  @Nullable
  public MetaIdGrid toGridId;

  @Nullable
  public MetaIdField toGridKey;

  @Nullable
  public EnumDefnUpdateVariant updateVariant;
}
