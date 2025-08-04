class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ladders = new ArrayList<>();

        // Add all words to a set for quick lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return ladders;

        // Map to store the shortest distance from beginWord to each word
        Map<String, Integer> distanceMap = new HashMap<>();

        // Map to track all parents (previous words) of a word for DFS path reconstruction
        Map<String, List<String>> parentMap = new HashMap<>();

        // Step 1: Build the graph using BFS
        bfs(beginWord, endWord, wordSet, distanceMap, parentMap);

        // Step 2: Backtrack using DFS from endWord to beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord); // Start path from the endWord
        dfs(endWord, beginWord, parentMap, ladders, path);

        return ladders;
    }

    /**
     * Performs BFS to compute the shortest distance from beginWord to all reachable words.
     * Builds parentMap to store all paths contributing to the shortest transformation.
     */
    private void bfs(String beginWord, String endWord,
                     Set<String> wordSet,
                     Map<String, Integer> distanceMap,
                     Map<String, List<String>> parentMap) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0); // Distance to beginWord is 0

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                int currentDist = distanceMap.get(currentWord);

                for (String neighbor : getNeighbours(currentWord, wordSet)) {
                    // If visiting neighbor for the first time, record its distance
                    if (!distanceMap.containsKey(neighbor)) {
                        distanceMap.put(neighbor, currentDist + 1);
                        queue.offer(neighbor);
                    }

                    // If this path to neighbor is the shortest, record the current word as its parent
                    if (distanceMap.get(neighbor) == currentDist + 1) {
                        parentMap.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(currentWord);
                    }
                }
            }
        }
    }

    /**
     * Performs DFS from endWord to beginWord using the parentMap to reconstruct all shortest paths.
     */
    private void dfs(String currentWord, String beginWord,
                     Map<String, List<String>> parentMap,
                     List<List<String>> ladders,
                     List<String> path) {

        // Base case: if we've reached the beginWord, reverse the path and add to result
        if (currentWord.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath); // Since we're going from endWord to beginWord
            ladders.add(validPath);
            return;
        }

        // If no parent exists, we can't go further
        if (!parentMap.containsKey(currentWord)) return;

        for (String parent : parentMap.get(currentWord)) {
            path.add(parent);                   // Choose
            dfs(parent, beginWord, parentMap, ladders, path);  // Explore
            path.remove(path.size() - 1);       // Backtrack
        }
    }

    /**
     * Returns a list of all valid one-letter transformations of the word that exist in wordSet.
     */
    private List<String> getNeighbours(String word, Set<String> wordSet) {
        List<String> neighbours = new ArrayList<>();
        char[] charArray = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char originalChar = charArray[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;

                charArray[i] = c;
                String newWord = new String(charArray);

                if (wordSet.co



//not optimized, will give TLE

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> ladders = new ArrayList<>();
        if (!wordSet.contains(endWord)) return ladders;

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(beginWord));
        boolean foundEnd = false;
        Set<String> visitedThisLevel = new HashSet<>();

        while (!queue.isEmpty() && !foundEnd) {
            int size = queue.size();
            visitedThisLevel.clear(); // clear for this level

            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String lastWord = path.get(path.size() - 1);
                char[] lastWordChars = lastWord.toCharArray();

                for (int j = 0; j < lastWordChars.length; j++) {
                    char original = lastWordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        lastWordChars[j] = c;
                        String nextWord = new String(lastWordChars);

                        if (wordSet.contains(nextWord)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(nextWord);

                            if (nextWord.equals(endWord)) {
                                ladders.add(newPath);
                                foundEnd = true; // allow level to finish
                            } else {
                                if (!foundEnd) queue.offer(newPath);
                            }

                            visitedThisLevel.add(nextWord);
                        }
                    }

                    lastWordChars[j] = original; // restore for next char
                }
            }

            // remove all visited words after current level to avoid cross-level interference
            for (String word : visitedThisLevel) {
                wordSet.remove(word);
            }
        }

        return ladders;
    }
}
