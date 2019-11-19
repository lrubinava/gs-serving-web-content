package hello;

import java.util.List;

public interface BugService {

    List<Bug> findAll();

    void saveAll(List<Bug> bugsList);
}

