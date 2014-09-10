package net.jcip.examples;

/**
 * SafeListener
 * <p/>
 * Using a factory method to prevent the this reference from escaping during construction
 * 使用工厂方法防止引用逸出
 * @since 2014-09-10
 * @author Brian Goetz and Tim Peierls
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        };
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}

