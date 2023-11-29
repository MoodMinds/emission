package org.moodminds.emission;

import org.moodminds.function.Evaluable1Throwing1;

/**
 * This object represents a resource that supports both synchronous and asynchronous execution, as indicated
 * by {@link Emittable}. It must be either handled or explicitly refused to release the underlying resource.
 * The emitted values may act as proxying accessors to the underlying resource's values and may remain alive
 * only during their handling, becoming disposable afterward. Consequently, the designated handler is responsible
 * for consuming and transforming the emitted values and should refrain from re-emitting them externally.
 *
 * @param <R> the type of the emitting values
 * @param <E> the type of possible exception that might be emitted by resource
 *
 * @see Emittable
 */
public interface Resource<R, E extends Exception> {

    /**
     * Return the resource's event processing by the given items' and exception handlers.
     *
     * @param handler the given resource item handler
     * @param catcher the given resource exception handler
     * @param <V> the type of the handling result values
     * @param <H> the type of possible exception that might be thrown
     * @return the given resource handler execution result
     */
    <V, H extends Exception> Emittable<V, H> handle(Evaluable1Throwing1<? super R, ? extends Emittable<? extends V, ? extends H>, ? extends H> handler,
                                                    Evaluable1Throwing1<? super Throwable, ? extends Emittable<? extends V, ? extends H>, ? extends H> catcher);

    /**
     * Return the resource refusal processing.
     *
     * @return the resource refusal processing
     */
    Emittable<Void, E> refuse();
}
