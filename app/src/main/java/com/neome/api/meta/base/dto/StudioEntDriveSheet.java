// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnDataExportKind;
import com.neome.api.meta.base.Types.EnumDefnDataPartitionPeriod;
import com.neome.api.meta.base.Types.MetaIdDriveSheet;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntDriveSheet extends StudioBase
{
  @Nullable
  public MetaIdRole[] attachmentRoleIdSet;

  @Nullable
  public EnumDefnDataPartitionPeriod dataPartitionPeriod;

  @Nullable
  public FieldDtoDuration dataRetentionDuration;

  @Nullable
  public EnumDefnDataExportKind[] exportKindSet;

  @Nullable
  public StudioMapOfLayoutDriveSheet layoutMap;

  public MetaIdDriveSheet metaId;

  @Nullable
  public StudioModuleSelection modules;

  @Nullable
  public Symbol name;

  public boolean partitionedData;

  @Nullable
  public MetaIdRole[] roleIdSet;

  public MetaIdSpreadsheet spreadsheetId;
}
