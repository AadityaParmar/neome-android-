// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.EnumFormExportType;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgEntFormExport extends Msg
{
  public MetaIdLayoutForm contentLayoutId;

  public EntId entId;

  public EnumFormExportType exportType;

  public MetaIdForm formId;

  public FormValueRaw formValueRaw;

  @Nullable
  public Long height;

  @Nullable
  public MetaIdLayoutForm templateLayoutId;

  @Nullable
  public Long width;
}
