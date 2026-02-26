package com.neome.feature.form.presentation.sample

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.ent.entDrawer.sig.SigEntCallerData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.feature.form.domain.util.FilterForm
import com.neome.feature.utils.JsonParser

/**
 * Provides lightweight sample DefnForm data for demos/tests.
 */
object FormSampleDataFactory {
    private var callerEntStr: String? = null

    fun createTextForm(): DefnFormUi {
        val jsonString = this.createSampleDefnForm()

        val defnForm = JsonParser.json.decodeFromString<DefnFormData>(jsonString)
        val callerEnt = getSampleCallerEnt()
        return FilterForm.prepareUiForm(defnForm, callerEnt)
    }

    fun getSampleCallerEnt(): SigEntCallerData {
        val jsonString = callerEntStr ?: this.createSampleCallerEnt()
        callerEntStr = jsonString
        return JsonParser.json.decodeFromString<SigEntCallerData>(jsonString)
    }


    fun createSampleDefnForm(): String {
        val formId = SysId.create<Types.MetaIdForm>("mf-pdPRpwtlFt")
        val callerEnt = getSampleCallerEnt()

        val defnFormData = callerEnt.formMap[formId]
        if (defnFormData != null) {
            return JsonParser.json.encodeToString(defnFormData)
        } else return ""
    }

    fun createSampleCallerEnt(): String {
        return this::class.java.classLoader!!
            .getResourceAsStream("SigEntCaller.json")!!
            .bufferedReader()
            .use { it.readText() }
    }
}
