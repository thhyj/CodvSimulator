package codv.Tools;

/**
 * 模拟指针,在别处修改变量的值
 * 因为Java中没有指针,不能像C/C++一样通过指针修改变量的值,
 * 因此创建一个类来实现类似的操作
 * @param <T>
 */
public class PointerSimulator<T> {
    public T value;
    public PointerSimulator(T value) {
        this.value = value;
    }
}
