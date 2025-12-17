// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.ent.base.dto.DtoEntFormExportExcel;
import com.neome.api.ent.base.dto.DtoEntSpreadsheetExportExcel;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgEntExportExcel extends Msg
{
  public EntId entId;

  @Nullable
  public DtoEntFormExportExcel formExportConfig;

  @Nullable
  public DtoEntSpreadsheetExportExcel spreadsheetExportConfig;
}
