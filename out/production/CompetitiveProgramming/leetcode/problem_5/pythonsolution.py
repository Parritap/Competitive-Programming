# Python program to find the longest palindromic substring in a given string.

def longest_palin(s):
    # Initialize variables to keep track
    # of the longest palindrome and its length.
    count = -1
    ans = ""

    # Get the length of the input string.
    n = len(s)

    # Create a boolean 2D array to
    # store palindrome information.
    dp = [[False] * n for _ in range(n)]

    # Iterate through different substring lengths.
    # Let's suppose n = 10, then g = (0..9)
    for g in range(n):  # g is going to determine the size of the substring.
        # let g be 4 in this example
        for i in range(n - g):  # then i <= g. i is the right pointer
            # if g=4 then i = (0 until (10-4)) -> (0 until 6)
            j = i + g  # if  i = 2, then j = 6

            # Check if the substring is of length 1 (base case).
            if g == 0:
                dp[i][j] = True
            # Check if the substring is of length 2 (base case).
            elif g == 1:
                dp[i][j] = (s[i] == s[j])
            else:
                # Check if the current substring is a
                # palindrome based on its ends.
                dp[i][j] = (s[i] == s[j] and dp[i + 1][j - 1])

            # Update the longest palindrome and its length if found.
            if dp[i][j] and count < j - i + 1:
                ans = s[i:j + 1]
                count = len(ans)
    return ans


if __name__ == '__main__':
    # Input string
    str = "ababbad"
    # Print the longest palindromic substring.
    print(longest_palin(str))
