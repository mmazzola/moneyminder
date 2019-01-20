package mmazzola.moneyminder.dagger

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import mmazzola.moneyminder.MoneyMinderApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class,BuildersModule::class])
interface AppComponent {

    fun inject (app : MoneyMinderApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app:MoneyMinderApplication) : Builder
        fun build() : AppComponent
    }

}