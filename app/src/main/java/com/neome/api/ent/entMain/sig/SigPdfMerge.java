// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.meta.base.Types.EnumDefnDocFileExt;
import com.neome.api.meta.base.Types.MediaId;
import com.neome.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigPdfMerge extends Sig
{
  public EnumDefnDocFileExt fileExt;

  public long fileLength;

  public String fileName;

  public MediaId mediaId;
}