class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        words = sentence.split(" ")
        for i, word in enumerate(words):
            if(word.startswith(searchWord) == 0):
                return i+1
        return -1
