"""
Convert the sentence into “Goat Latin” using these rules:
    1. If a word starts with a vowel, add "ma" to the end.
    2. If it starts with a consonant, move the first letter to the end and then add "ma".
    3. Then add "a" repeated (word index) times — the first word gets "a", the second "aa", etc.
"""

# Time: O(N) - single pass through the sentence
# Space: O(N) - storing the transformed words
class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        # set of vowels
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        # split sentence into words
        words = sentence.split()

        # traverse each word and convert
        for i in range(len(words)):
            word = words[i]
            if word[0] in vowels:
                words[i] = word + 'ma' + 'a' * (i + 1)
            else:
                words[i] = word[1:] + word[0] + 'ma' + 'a' * (i + 1)
        # join words back into a sentence
        return ' '.join(words)