package zebaszp.ejercicio4hs.application

import com.facebook.stetho.Stetho

class Application : android.app.Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}