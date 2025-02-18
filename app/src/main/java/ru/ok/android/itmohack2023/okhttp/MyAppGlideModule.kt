package ru.ok.android.itmohack2023.okhttp

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.Excludes
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import ru.ok.android.itmohack2023.okhttp.BaseClient.Companion.getBaseOkHttpClient
import java.io.InputStream


@GlideModule
@Excludes(OkHttpLibraryGlideModule::class) // initialize OkHttp manually
class MyAppGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(
            GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(
                getBaseOkHttpClient()
            )
        )
    }
}