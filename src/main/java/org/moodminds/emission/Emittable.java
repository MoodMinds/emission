package org.moodminds.emission;

import org.moodminds.elemental.Association;
import org.moodminds.elemental.KeyValue;
import org.moodminds.reactive.SubscribeSupport;
import org.moodminds.reactive.SubscribeSupportException;
import org.moodminds.function.Executable1Throwing2;
import org.moodminds.function.Executable1Throwing3;
import org.moodminds.traverse.TraverseSupport;
import org.moodminds.traverse.TraverseSupportException;

import static java.util.Objects.requireNonNull;

/**
 * An item emission definition interface, both the {@link TraverseSupport} and {@link SubscribeSupport} mixin,
 * supporting the emission of items, whether through traversals (synchronous) or subscriptions (asynchronous),
 * depending on the nature of the implementation.
 *
 * @param <V> the type of item values
 * @param <E> the type of potential exceptions
 */
public interface Emittable<V, E extends Exception> extends TraverseSupport<V, E>, SubscribeSupport<V, E> {

    /**
     * Return the specified {@link TraverseSupport} as an {@link Emittable}.
     *
     * @param traverseSupport the specified {@link TraverseSupport}
     * @return the specified {@link TraverseSupport} as an {@link Emittable}
     * @param <V> the type of item values
     * @param <E> the type of potential exceptions
     */
    static <V, E extends Exception> Emittable<V, E> emittable(TraverseSupport<? extends V, ? extends E> traverseSupport) {
        return new Emittable<V, E>() {
            @Override public void subscribe(Subscriber<? super V, ? super E> subscriber, KeyValue<?, ?>... ctx) {
                requireNonNull(subscriber); throw new SubscribeSupportException("Synchronous traversal only."); }
            @Override public void subscribe(Subscriber<? super V, ? super E> subscriber, Association<?, ?, ?> ctx) {
                requireNonNull(subscriber); requireNonNull(ctx); throw new SubscribeSupportException("Synchronous traversal only."); }
            @Override public void subscribe(org.reactivestreams.Subscriber<? super V> subscriber, KeyValue<?, ?>... ctx) {
                requireNonNull(subscriber); throw new SubscribeSupportException("Synchronous traversal only."); }
            @Override public void subscribe(org.reactivestreams.Subscriber<? super V> subscriber, Association<?, ?, ?> ctx) {
                requireNonNull(subscriber); requireNonNull(ctx); throw new SubscribeSupportException("Synchronous traversal only."); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean sequence(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2 {
                return traverseSupport.sequence(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean sequence(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, Association<?, ?, ?> ctx) throws E, H1, H2 {
                return traverseSupport.sequence(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean traverse(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2 {
                return traverseSupport.traverse(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean traverse(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, Association<?, ?, ?> ctx) throws E, H1, H2 {
                return traverseSupport.traverse(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean parallel(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2 {
                return traverseSupport.parallel(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean parallel(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, Association<?, ?, ?> ctx) throws E, H1, H2 {
                return traverseSupport.parallel(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean sequence(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2, H3 {
                return traverseSupport.sequence(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean sequence(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, Association<?, ?, ?> ctx) throws E, H1, H2, H3 {
                return traverseSupport.sequence(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean traverse(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2, H3 {
                return traverseSupport.traverse(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean traverse(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, Association<?, ?, ?> ctx) throws E, H1, H2, H3 {
                return traverseSupport.traverse(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean parallel(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2, H3 {
                return traverseSupport.parallel(traverse, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean parallel(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, Association<?, ?, ?> ctx) throws E, H1, H2, H3 {
                return traverseSupport.parallel(traverse, ctx); }
        };
    }

    /**
     * Return the specified {@link SubscribeSupport} as an {@link Emittable}.
     *
     * @param subscribeSupport the specified {@link TraverseSupport}
     * @return the specified {@link SubscribeSupport} as an {@link Emittable}
     * @param <V> the type of item values
     * @param <E> the type of potential exceptions
     */
    static <V, E extends Exception> Emittable<V, E> emittable(SubscribeSupport<? extends V, ? extends E> subscribeSupport) {
        return new Emittable<V, E>() {
            @Override public void subscribe(Subscriber<? super V, ? super E> subscriber, KeyValue<?, ?>... ctx) {
                subscribeSupport.subscribe(subscriber, ctx); }
            @Override public void subscribe(Subscriber<? super V, ? super E> subscriber, Association<?, ?, ?> ctx) {
                subscribeSupport.subscribe(subscriber, ctx); }
            @Override public void subscribe(org.reactivestreams.Subscriber<? super V> subscriber, KeyValue<?, ?>... ctx) {
                subscribeSupport.subscribe(subscriber, ctx); }
            @Override public void subscribe(org.reactivestreams.Subscriber<? super V> subscriber, Association<?, ?, ?> ctx) {
                subscribeSupport.subscribe(subscriber, ctx); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean sequence(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2 {
                requireNonNull(traverse); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean sequence(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, Association<?, ?, ?> ctx) throws E, H1, H2 {
                requireNonNull(traverse); requireNonNull(ctx); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean traverse(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2 {
                requireNonNull(traverse); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean traverse(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, Association<?, ?, ?> ctx) throws E, H1, H2 {
                requireNonNull(traverse); requireNonNull(ctx); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean parallel(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2 {
                requireNonNull(traverse); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception> boolean parallel(Executable1Throwing2<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2> traverse, Association<?, ?, ?> ctx) throws E, H1, H2 {
                requireNonNull(traverse); requireNonNull(ctx); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean sequence(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2, H3 {
                requireNonNull(traverse); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean sequence(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, Association<?, ?, ?> ctx) throws E, H1, H2, H3 {
                requireNonNull(traverse); requireNonNull(ctx); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean traverse(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2, H3 {
                requireNonNull(traverse); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean traverse(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, Association<?, ?, ?> ctx) throws E, H1, H2, H3 {
                requireNonNull(traverse); requireNonNull(ctx); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean parallel(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, KeyValue<?, ?>... ctx) throws E, H1, H2, H3 {
                requireNonNull(traverse); throw new TraverseSupportException("Asynchronous subscription only."); }
            @Override public <H1 extends Exception, H2 extends Exception, H3 extends Exception> boolean parallel(Executable1Throwing3<? super Traverser<? extends V, ? extends E>, ? extends H1, ? extends H2, ? extends H3> traverse, Association<?, ?, ?> ctx) throws E, H1, H2, H3 {
                requireNonNull(traverse); requireNonNull(ctx); throw new TraverseSupportException("Asynchronous subscription only."); }
        };
    }
}
