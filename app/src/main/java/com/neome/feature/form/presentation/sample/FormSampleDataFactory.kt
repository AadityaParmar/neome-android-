package com.neome.feature.form.presentation.sample

import com.neome.api.meta.base.AnyValue
import com.neome.api.meta.base.Symbol
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.utils.JsonParser

/**
 * Provides lightweight sample DefnForm data for demos/tests.
 */
object FormSampleDataFactory {

    fun createTextForm(): DefnFormData {
        val jsonString = this.createSampleDefnForm()
        return JsonParser.json.decodeFromString<DefnFormData>(jsonString)
    }

    private fun symbol(value: String): Symbol {
        return AnyValue.create(value, Symbol::class.java)!!
    }

    fun createSampleDefnForm(): String {
        return """
{
      "metaId": "${'$'}FormSearch",
      "name": "SysFormSearch",
      "compMap": {
        "mtb-Tab": {
          "metaId": "mtb-Tab",
          "tabIdSet": [
            "msc-Details",
            "mgr-ResultGrid"
          ],
          "name": "SysFormSearch",
          "type": "tab",
          "disabled": false
        },
        "mfd-SearchText": {
          "metaId": "mfd-SearchText",
          "name": "SearchText",
          "type": "text",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        },
        "msc-Details": {
          "metaId": "msc-Details",
          "fieldIdSet": [
            "mfd-SearchText"
          ],
          "flexGrow": false,
          "name": "Details",
          "type": "section",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        },
        "mfd-SpreadsheetId": {
          "metaId": "mfd-SpreadsheetId",
          "name": "SpreadsheetId",
          "type": "spreadsheetId",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        },
        "mfd-RowId": {
          "metaId": "mfd-RowId",
          "name": "RowId",
          "type": "rowId",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        },
        "mgr-ResultGrid": {
          "metaId": "mgr-ResultGrid",
          "fieldIdSet": [
            "mfd-SpreadsheetId",
            "mfd-RowId"
          ],
          "name": "ResultGrid",
          "type": "grid",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        }
      },
      "displayCompositeId": "mtb-Tab",
      "permissionMatrix": {
        "keys": [],
        "map": {}
      },
      "layoutMap": {
        "keys": [],
        "map": {}
      },
      "visibilityRuleMap": {
        "keys": [],
        "map": {}
      },
      "formulaFieldIdSet": [],
      "gridLookupMap": {}
    }
        """.trimIndent()
    }
}
