// neome.ai API - do not change
//

package com.neome.api.home.aside.sig;

import com.neome.api.home.base.dto.DtoReceipt;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigMessageReceiptMap extends Sig
{
  public Map<EntUserId, DtoReceipt> entUserReceiptMap;
}
