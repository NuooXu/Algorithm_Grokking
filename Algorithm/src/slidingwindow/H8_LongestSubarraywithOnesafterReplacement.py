def find(arr, k):
  start, maxlen, count = 0, 0, 0
  for end in range(0, len(arr)):
    if arr[end] == 1:
      count += 1
    while end - start + 1 - count > k:
      if arr[start] == 1:
        count -= 1
      start += 1
    maxlen = max(maxlen, end - start + 1)
  return maxlen

def main():
  print(find([0,1,1,0,0,0,0,1,1,0,1,1], 2))

main()