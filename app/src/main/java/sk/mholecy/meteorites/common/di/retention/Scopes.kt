package sk.mholecy.meteorites.common.di.retention

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class FragmentScope
