import java.util.NoSuchElementException;

class NumberContainers {
    Map<Integer, Integer> map; 
    Map<Integer, TreeSet<Integer>> valIdx; 
    public NumberContainers() {
        map = new HashMap<>();
        valIdx = new HashMap<>();
    }
    public void change(int index, int number) {
        if (!valIdx.containsKey(number)) {
            valIdx.put(number, new TreeSet<>());
        }
        if (map.containsKey(index)) {
            if(map.get(index)==number) return;
            int prevVal = map.get(index);
            valIdx.get(prevVal).remove(index); 
        }
        valIdx.get(number).add(index);
        map.put(index, number);
    }
    public int find(int number) {
        if (valIdx.containsKey(number)) {
            try {
                return valIdx.get(number).first();
            } catch (NoSuchElementException e) {
                return -1;
            }
        }
        // If the number is not found, return -1
        return -1;
    }
}