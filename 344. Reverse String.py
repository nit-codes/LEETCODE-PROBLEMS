class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        left=0;
        right = len(s)-1
        while left < right:
            tmp = s[left]
            s[left] = s[right]
            left += 1
            s[right] = tmp
            right -= 1
