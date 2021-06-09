def flag(arr):
  start, end = 0, len(arr) - 1
  cur = 0
  while cur <= end:
    if arr[cur] == 0:
      arr[cur], arr[start] = arr[start], arr[cur]
      cur += 1
      start += 1
    elif arr[cur] == 1:
      cur += 1
    elif arr[cur]== 2:
      arr[cur], arr[end] = arr[end], arr[cur]
      end -= 1


def main():
  arr = [1, 0, 2, 1, 0]
  flag(arr)
  print(arr)

main()