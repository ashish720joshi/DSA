class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordList.stream().forEach(word -> {
            wordSet.add(word);
        });
        if (!wordSet.contains(endWord))
            return 0;
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] charArray = word.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (charArray[j] == k)
                            continue;

                        charArray[j] = k;
                        String newWord = new String(charArray);

                        if (newWord.equals(endWord))
                            return level + 1;

                        else if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}