package mmazzola.moneyminder.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import mmazzola.moneyminder.MoneyMinderApplication
import javax.inject.Singleton

@Module
class AppModule{

    @Singleton
    @Provides
    fun provideContext(app : MoneyMinderApplication) : Context = app.applicationContext
}