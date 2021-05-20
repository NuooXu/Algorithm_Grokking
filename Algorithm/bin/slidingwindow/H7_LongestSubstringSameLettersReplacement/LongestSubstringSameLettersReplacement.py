def substring(s, k):
  start, maxlen, repeat = 0, 0, 0
  chars = {}

  for end in range(0, len(s)):
    rc = s[end]
    if rc not in chars:
      chars[rc] = 0
    chars[rc] += 1
    repeat = max(repeat, chars[rc])

    if end - start + 1 - repeat > k:
      chars[s[start]] -= 1
      start += 1
    maxlen = max(maxlen, end - start + 1)
  return maxlen

def main():
  print(substring("aabccbb", 2))

main()