// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MediaId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgPdfMerge extends Msg
{
  @Nullable
  public String fileName;

  public MediaId[] pdfMediaIdSet;
}
