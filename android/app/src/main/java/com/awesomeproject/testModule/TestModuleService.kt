package com.awesomeproject.testModule

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.WritableMap

import org.json.JSONObject

class TestModuleService(private val reactContext:ReactApplicationContext):ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
       return "TestModule"
    }

    @ReactMethod
    fun getDetails(jsonData:String,promise:Promise){
        try {
    println(jsonData)
            val data = JSONObject(jsonData)
            val resultMap = mutableMapOf<String, Any>()
            resultMap["key1"] = data.getString("first_name")
            resultMap["key2"] = data.getString("last_name")
            println(data)
            val writableMap: WritableMap = Arguments.createMap()
            for ((key, value) in resultMap) {
                writableMap.putString(key, value.toString())
            }

            promise.resolve(writableMap)
        }catch(e:Exception){
            promise.reject("ERROR_CODE", e.message, e)
        }
    }
}