package com.neome.feature.form.domain.ctx.base

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption

/**
 * Optional Form API context.
 * Provides APIs that field components can call for external data fetching.
 */
interface FormCtxApiCtx {
    /**
     * Callback-based API to fetch options for a given field.
     * The map of options will be provided to the callback when available.
     *
     * @param fieldId The field requesting options
     * @param cb Callback invoked with options or null if unavailable
     */
    fun onGetFieldOptions(fieldId: MetaIdField, cb: (DefnStudioMapOfDtoOption?) -> Unit)
}
