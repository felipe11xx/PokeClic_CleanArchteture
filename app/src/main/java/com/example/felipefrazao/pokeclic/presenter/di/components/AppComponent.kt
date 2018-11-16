package com.example.felipefrazao.pokeclic.presenter.di.components


import com.example.felipefrazao.pokeclic.presenter.Ciclic
import com.example.felipefrazao.pokeclic.presenter.di.AppModule
import com.example.felipefrazao.pokeclic.presenter.di.module.presentation.UiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (UiModule::class)]
)
interface AppComponent : AndroidInjector<Ciclic> {

  @Component.Builder
  interface Builder {
    @BindsInstance fun application(application: Ciclic): Builder
    fun appModule(appModule: AppModule): Builder
    fun build(): AppComponent
  }

  override fun inject(app: Ciclic)

}