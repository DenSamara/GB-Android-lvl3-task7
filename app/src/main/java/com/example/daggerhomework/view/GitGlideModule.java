package com.example.daggerhomework.view;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;


@GlideModule
public class GitGlideModule extends AppGlideModule {
//    @Override
//    public void registerComponents(Context context, Glide glide, Registry registry) {
//        registry.append(Photo.class, InputStream.class, new FlickrModelLoader.Factory());
//    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
//        int bitmapPoolSizeBytes = 1024 * 1024 * 30; // 30mb
//        builder.setBitmapPool(new LruBitmapPool(bitmapPoolSizeBytes));

        MemorySizeCalculator calculator = new MemorySizeCalculator.Builder(context)
                .setBitmapPoolScreens(3)
                .build();
        builder.setBitmapPool(new LruBitmapPool(calculator.getBitmapPoolSize()));
    }
}
