# Last updated: 09/07/2026, 10:13:46
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        # return True iff n > 0 and has exactly one 1-bit
        return n > 0 and (n & (n - 1)) == 0
sol = Solution()
print(sol.isPowerOfTwo(1))   # True
print(sol.isPowerOfTwo(16))  # True
print(sol.isPowerOfTwo(3))   # False

