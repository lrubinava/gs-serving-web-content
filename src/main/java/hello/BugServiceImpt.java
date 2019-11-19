package hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BugServiceImpt implements BugService {

    static Map<Long, Bug> bugsDB = new HashMap<>();

    @Override
    public List<Bug> findAll() {
        return new ArrayList<>(bugsDB.values());
    }

    @Override
    public void saveAll(List<Bug> bugsList) {
        long nextId = getNextId();
        for (Bug bug : bugsList) {
            if (bug.getId() == 0) {
                bug.setId(nextId++);
            }
        }

        Map<Long, Bug> bugMap = bugsList.stream()
                .collect(Collectors.toMap(Bug::getId, Function.identity()));

        bugsDB.putAll(bugMap);
    }

    private Long getNextId() {
        return bugsDB.keySet()
                .stream()
                .mapToLong(value -> value)
                .max()
                .orElse(0) + 1;
    }
}