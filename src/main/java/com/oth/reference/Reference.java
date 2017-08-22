package com.oth.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oth.concurrent.Print;

/**
 * created by anyanwen on 2017/8/22.
 */
public class Reference {
    private String id;

    public Reference(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "id='" + id + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Map<String, Reference> referenceMap = new HashMap<>(2);
        List<Reference> referenceList = new ArrayList<>(2);
        Reference r1 = new Reference("1");
        Reference r2 = new Reference("2");
        referenceList.add(r1);
        referenceList.add(r2);
        referenceMap.put("1", r1);
        referenceMap.put("2", r2);
        for (Map.Entry<String, Reference> entry : referenceMap.entrySet()) {
            entry.getValue().setId("new" + entry.getKey());
        }
        System.out.println(referenceMap);
        System.out.println(referenceList);
    }
}
