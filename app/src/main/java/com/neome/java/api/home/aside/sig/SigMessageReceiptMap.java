// neome.ai API - do not change
//

package com.neome.java.api.home.aside.sig;

import com.neome.java.api.home.base.dto.DtoReceipt;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigMessageReceiptMap extends Sig
{
  public Map<EntUserId, DtoReceipt> entUserReceiptMap;
}
