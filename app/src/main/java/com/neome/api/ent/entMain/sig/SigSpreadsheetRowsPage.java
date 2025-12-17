// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.ent.base.dto.DtoFieldFilter;
import com.neome.api.home.main.sig.SigSpreadsheetRow;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.DefnForm;
import com.neome.api.meta.base.dto.DefnLayoutGridMap;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigSpreadsheetRowsPage extends Sig
{
  public DtoFieldFilter[] filterList;

  public boolean hasMoreRows;

  public DefnForm outputForm;

  public SigSpreadsheetRow[] rowList;

  @Nullable
  public DefnLayoutGridMap spreadSheetLayoutMap;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
