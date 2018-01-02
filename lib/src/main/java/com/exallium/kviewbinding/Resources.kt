package com.exallium.kviewbinding

typealias BindResourceFn<I, O> = (I) -> O

internal fun <I, O> lazyBindResource(
        input: I, bindFn: BindResourceFn<I, O>,
        lazyThreadSafetyMode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED
) = lazy(lazyThreadSafetyMode) { bindFn(input) }

