package org.learn.rxjava;

import io.reactivex.Observable;

/**
 * 
 * @author nirwan
 *	
 *	RxJava explicit thread management
 *
 */
public class InfiniteIntStream {
	
	
	private InfiniteIntStream() {
		// TODO Auto-generated constructor stub
	}
	
	public InfiniteIntStream getInstance() {
		return new InfiniteIntStream();
	}
	
	/**
	 * 
	 * @return {@link Observable}
	 * 
	 * Returns infinite integer stream (synchronised and blocking)
	 */
	public Observable<Integer> create() {
		return Observable.<Integer>create(subscriber->{
			int i = 0;
			while(!subscriber.isDisposed()) {
				subscriber.onNext(i++);
			}
			subscriber.onComplete();
		});
	}
}
