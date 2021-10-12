package domain.external;

import java.util.List;

public interface ContactRepository {
    List<String> findAll();
}
