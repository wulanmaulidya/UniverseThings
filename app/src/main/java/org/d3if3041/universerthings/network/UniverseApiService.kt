package org.d3if3041.universerthings.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3041.universerthings.model.Universe
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/wulanmaulidya/gambaruniverse/main/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UniverseApiService {
    @GET("universe.json")
    suspend fun getUniverse(): List<Universe>
}

object UniverseApi {
    val service: UniverseApiService by lazy {
        retrofit.create(UniverseApiService::class.java)
    }
    fun getUniverseUrl(nama: String): String {
        return "$BASE_URL$nama"
    }
}
enum class ApiStatus { LOADING, SUCCESS, FAILED }
