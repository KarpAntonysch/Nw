package com.example.nw.screens

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.nw.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FullScreenViewModel:ViewModel() {
     fun showWallPaper(context: Context, url:String?, view: ImageView){
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .into(view)
    }

    fun setWallPaper(context: Context, url:String?,fragmentManager: FragmentManager?){
        // glide автоматически делает запрос асинхронным
        Glide
            .with(context)
            .asBitmap()
            .load(url)
            .centerCrop()
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap>?,
                ) {
                    WallpaperManager.getInstance(context).setBitmap(resource)
                    Toast.makeText(context, R.string.setWallpaper, Toast.LENGTH_SHORT).show()// сохраняет старый значок приложения. Помогает презагрузка телефона
                    viewModelScope.launch {
                        delay(500)// для органичности работы UI
                        fragmentManager?.popBackStack()
                    }
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // вызывается, когда imageView очищается в зависимости от ЖЦ. нужно очистить Bitmap
                    //здесь, если мы ссылаемся на это изображение где то еще. Как я понимаю для защиты от утечки памяти
                }

            })
    }
}