package liquibase.sdk.state;

import java.util.Map;
import java.util.SortedMap;

public class TestPermutation {

    private String key;
    private SortedMap<String, VerifyTest.Value> data;
    private SortedMap<String,VerifyTest.Value> permutationDefinition;
    private SortedMap<String,VerifyTest.Value> info;
    private Boolean validated;

    public TestPermutation(VerifyTest run) {
        this.permutationDefinition = run.getPermutationDefinition();
        this.info = run.getInfo();
        this.data = run.getData();

        this.key = serialize(permutationDefinition, info);
    }

    public String getKey() {
        return key;
    }

    public SortedMap<String, VerifyTest.Value> getData() {
        return data;
    }

    public SortedMap<String, VerifyTest.Value> getPermutationDefinition() {
        return permutationDefinition;
    }

    public SortedMap<String, VerifyTest.Value> getInfo() {
        return info;
    }

    private String serialize(SortedMap<String, VerifyTest.Value> map1, SortedMap<String, VerifyTest.Value> map2) {
        return serialize(map1)+"\n"+serialize(map2);

    }

    private String serialize(SortedMap<String, VerifyTest.Value> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, VerifyTest.Value> entry : map.entrySet()) {
            builder.append("- **").append(entry.getKey()).append("** ").append(entry.getValue().serialize()).append("\n");
        }
        return builder.toString();
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public boolean isValidated() {
        return validated;
    }
}
