// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnDataExportKind;
import com.neome.api.meta.base.Types.EnumDefnMonth;
import com.neome.api.meta.base.Types.EnumDefnSyncMode;
import com.neome.api.meta.base.Types.MetaIdDriveSheet;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntDriveSheetMap extends StudioBase
{
  @Nullable
  public EnumDefnDataExportKind[] addressBookExportKindSet;

  @Nullable
  public EnumDefnMonth beginningOfTheYear;

  @Nullable
  public Symbol driveFolderName;

  public MetaIdDriveSheet[] keys;

  @Nullable
  public Boolean manageAdmins;

  @Nullable
  public Boolean manageUsers;

  public Map<MetaIdDriveSheet, StudioEntDriveSheet> map;

  @Nullable
  public EnumDefnSyncMode syncMode;
}
