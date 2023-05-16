package interfaces;

import java.util.List;

@FunctionalInterface
public interface IEntityFilter<T> {
    List<T> filter(List<T> list);
}
