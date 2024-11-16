package algorithm.collection.primary.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1、比较两个数得大小，比如字典序o1.compareTo(o2)的大小
 * 2、比较Integer的大小，比如o1.compareTo(o2)的大小
 * 3、堆定义的：
 * <block>
 * <code>
 * PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {@Override
 * public int compare(Integer o1, Integer o2) {
 * return o1-o2;
 * }
 * });
 * </code>
 * </block>
 * 如果o1-o2为则为最小堆，o2-o1为最大堆;每次进入堆即为o1和顶o2进行比较
 * 构建大顶堆和小顶堆
 */
public class HeapExample {

    public void minHeapOnInteger(List<Integer> datas) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 添加元素
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(1);
        minHeap.add(4);

        // 输出小顶堆的元素
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }

    public void maxHeapOnInteger(List<Integer> datas) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 添加元素
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(8);
        maxHeap.add(1);
        maxHeap.add(4);

        // 输出大顶堆的元素
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }

    public void minHeapOnStr(List<Integer> datas) {
        PriorityQueue<String> minHeap = new PriorityQueue<>();

        // 添加元素
        minHeap.add("apple");
        minHeap.add("banana");
        minHeap.add("cherry");
        minHeap.add("date");

        // 输出小顶堆的元素
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }

    public void maxHeapOnStr(List<Integer> datas) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 添加元素
        maxHeap.add("apple");
        maxHeap.add("banana");
        maxHeap.add("cherry");
        maxHeap.add("date");

        // 输出大顶堆的元素
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }

    public void minHeapOnObj(List<Integer> datas) {
        PriorityQueue<Person> minHeap = new PriorityQueue<>(Comparator.comparingInt(Person::getAge));

        // 添加元素
        minHeap.add(new Person("Alice", 30));
        minHeap.add(new Person("Bob", 25));
        minHeap.add(new Person("Charlie", 35));
        minHeap.add(new Person("David", 20));

        // 输出小顶堆的元素
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }

    public void maxHeapOnObj(List<Integer> datas) {
        PriorityQueue<Person> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Person::getAge).reversed());

        // 添加元素
        maxHeap.add(new Person("Alice", 30));
        maxHeap.add(new Person("Bob", 25));
        maxHeap.add(new Person("Charlie", 35));
        maxHeap.add(new Person("David", 20));

        // 输出大顶堆的元素
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }


    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

}
