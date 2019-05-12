package sk.mholecy.meteorites.common.di.retention

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ApiUrl