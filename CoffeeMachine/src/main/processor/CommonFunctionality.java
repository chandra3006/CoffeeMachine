package processor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Common Interface for accessing  inventory data
 */

public interface CommonFunctionality<T> {

    void create(T value);
    Optional<T> get(String id);
    void update(T value);
    public Collection<T> getAll();
    List<Optional<T>> getBatch(String id);

}
