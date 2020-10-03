package app.babachan.trypalette

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sky)


        Palette.generateAsync(bitmap, object : Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette?) {
                if (palette != null) {
                    // VibrantSwatch
                    val vibrantSwatch = findViewById<TextView>(R.id.vibrant_swatch)
                    if (vibrantSwatch != null) {
                        vibrantSwatch.setBackgroundColor(palette.vibrantSwatch!!.rgb)
                        vibrantSwatch.setTextColor(palette.getVibrantSwatch()!!.getTitleTextColor())
                        val darkVibrantSwatch = findViewById<TextView>(R.id.dark_vibrant_swatch)
                        darkVibrantSwatch.setBackgroundColor(
                            palette.getDarkVibrantSwatch()!!.getRgb()
                        )
                        vibrantSwatch.setTextColor(
                            palette.getDarkVibrantSwatch()!!.getTitleTextColor()
                        )
                        val lightVibrantSwatch = findViewById<TextView>(R.id.light_vibrant_swatch)
                        lightVibrantSwatch.setBackgroundColor(
                            palette.getLightVibrantSwatch()!!.getRgb()
                        )
                        lightVibrantSwatch.setTextColor(
                            palette.getLightVibrantSwatch()!!.getTitleTextColor()
                        )

                        //MutedSwatch
                        val mutedSwatch = findViewById<TextView>(R.id.muted_swatch)
                        mutedSwatch.setBackgroundColor(palette.getMutedSwatch()!!.getRgb())
                        mutedSwatch.setTextColor(palette.getMutedSwatch()!!.getTitleTextColor())
                        val darkMutedSwatch = findViewById<TextView>(R.id.dark_muted_swatch)
                        darkMutedSwatch.setBackgroundColor(palette.getDarkMutedSwatch()!!.getRgb())
                        darkMutedSwatch.setTextColor(
                            palette.getDarkMutedSwatch()!!.getTitleTextColor()
                        )
                        val lightMutedSwatch = findViewById<TextView>(R.id.light_muted_swatch)
                        lightMutedSwatch.setBackgroundColor(palette.getLightMutedSwatch()!!.getRgb())
                        lightMutedSwatch.setTextColor(
                            palette.getLightMutedSwatch()!!.getTitleTextColor()
                        )
                    }
                }
            }
        })
    }
}