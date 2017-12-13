package cn.yzl.mvvmdemo.http.converter.fastjson

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.parser.Feature
import com.alibaba.fastjson.parser.ParserConfig

import java.io.IOException
import java.lang.reflect.Type

import okhttp3.ResponseBody
import retrofit2.Converter

internal class FastJsonResponseBodyConverter<T>(private val mType: Type, private val config: ParserConfig,
                                                private val featureValues: Int,
                                                vararg features: Feature) : Converter<ResponseBody, T> {
    private val features: Array<out Feature>?

    init {
        this.features = features
    }

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T {
        try {
            return JSON.parseObject(value.string(), mType, config, featureValues,
                    *features ?: EMPTY_SERIALIZER_FEATURES)
        } finally {
            value.close()
        }
    }

    companion object {

        private val EMPTY_SERIALIZER_FEATURES = arrayOfNulls<Feature>(0)
    }
}
