def substring(s, k):
  start, maxLen = 0, 0
  chars = {}

  for end in range(0, len(s)):
    rc = s[end]
    if rc not in chars:
      chars[rc] = 0
    chars[rc] += 1
    while len(chars) > k:
      lc = s[start]
      chars[lc] -= 1
      if chars[lc] == 0:
        del chars[lc]
      start += 1
    maxLen = max(maxLen, end - start + 1)
  return maxLen

def main():
  print(str(substring("araaci", 2)))

main()