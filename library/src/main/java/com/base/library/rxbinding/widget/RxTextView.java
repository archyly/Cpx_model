package com.base.library.rxbinding.widget;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.base.library.rxbinding.InitialValueObservable;
import com.base.library.rxbinding.internal.Preconditions;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


/**
 * Static factory methods for creating {@linkplain Observable observables} and {@linkplain Consumer
 * actions} for {@link TextView}.
 */
public final class RxTextView {


  /**
   * Create an observable of character sequences for text changes on {@code view}.
   * <p>
   * <em>Warning:</em> Values emitted by this observable are <b>mutable</b> and owned by the host
   * {@code TextView} and thus are <b>not safe</b> to cache or delay reading (such as by observing
   * on a different thread). If you want to cache or delay reading the items emitted then you must
   * map values through a function which calls {@link String#valueOf} or
   * {@link CharSequence#toString() .toString()} to create a copy.
   * <p>
   * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
   * to free this reference.
   * <p>
   * <em>Note:</em> A value will be emitted immediately on subscribe.
   */
  @CheckResult @NonNull
  public static InitialValueObservable<CharSequence> textChanges(@NonNull TextView view) {
    Preconditions.checkNotNull(view, "view == null");
    return new TextViewTextObservable(view);
  }


  private RxTextView() {
    throw new AssertionError("No instances.");
  }
}
