package net.jcip.examples;

/**
 * ThisEscape
 * <p/>
 * Implicitly allowing the this reference to escape
 * 隐式地允许this引用逸出（不明白？）
 * 个人理解：在ThisEscape构造函数完全完成 EventListener才算完成，
 * 但是这里可能出现情况，EventListener有引用可用但未完全完成的时候就被其他线程使用
 * Date：2014-09-10
 * @author Brian Goetz and Tim Peierls
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
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

