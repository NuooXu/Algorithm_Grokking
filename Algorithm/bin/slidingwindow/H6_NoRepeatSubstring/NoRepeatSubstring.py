def findSubstring(s):
  start, maxLen = 0, 0
  chars = {}

  for end in range(0, len(s)):
    if s[end] in chars:
      start = max(start, chars[s[end]] + 1)
    chars[s[end]] = end
    maxLen = max(maxLen, end - start + 1)
  return maxLen

def main():
  print(str(findSubstring("aabccbb")))

main()